package cn.likegirl.mina.example.aoyi;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import cn.likegirl.mina.example.aoyi.codec.MyCodeFactory;

public class Client {

	private static final String AOYI_URL = "aoyi.56matrix.com";
	
	private static final String HOSTNAME = "172.19.30.219";
	
	private static final String LOCALHOST = "localhost";
	
	private static final int PORT = 5088;

	private static final int AOYI_PORT = 3016;

	private static final long CONNECT_TIMEOUT = 30 * 1000L; // 30 seconds

	// 将其设置成为: false 以 object serialization 为解码器而不是自定义解码器
	private static final boolean USE_CUSTOM_CODEC = true;

	public static void main(String[] args) throws InterruptedException, UnknownHostException {

		NioSocketConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(CONNECT_TIMEOUT);

		if (USE_CUSTOM_CODEC) {
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyCodeFactory()));
		} else {
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		}

		connector.getFilterChain().addLast("logger", new LoggingFilter());
		//
		connector.setHandler(new ClientHandler());
		IoSession session;

		for (;;) {
			System.out.println(InetAddress.getByName(AOYI_URL));
			try {
				// pro
//				ConnectFuture future = connector.connect(new InetSocketAddress(InetAddress.getByName(AOYI_URL), PORT));
				// local
				ConnectFuture future = connector.connect(new InetSocketAddress(LOCALHOST, AOYI_PORT));
				
				// 等待异步操作完成不间断。
				// 操作完成后，将会通知附加的听众。
				future.awaitUninterruptibly();
				session = future.getSession();
				break;
			} catch (RuntimeIoException e) {
				System.err.println("Failed to connect.");
				e.printStackTrace();
				Thread.sleep(5000);
			}
		}

		// wait until the summation is done
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}

}
