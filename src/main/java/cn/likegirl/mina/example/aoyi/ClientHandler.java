package cn.likegirl.mina.example.aoyi;

import java.net.InetSocketAddress;
import java.util.Arrays;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.likegirl.mina.example.aoyi.utils.ByteDisposeUtil;
import cn.likegirl.mina.example.aoyi.utils.CRCUtil;
import cn.likegirl.mina.example.aoyi.utils.DataTransferUtil;

public class ClientHandler extends IoHandlerAdapter {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("remote client [" + session.getRemoteAddress().toString() + "] connected.");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionOpened...");

		byte[] loginData = new byte[] { 0x7E, 0x3E, 0x01, 0x30, 0x00, 0x05, 0x01, 0x79, 0x69, 0x74, 0x61, 0x69, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x79, 0x69, 0x74,
				0x61, 0x69, 0x00, 0x00, 0x00, 0x00, 0x00, 0x79, 0x69, 0x74, 0x61, 0x69, 0x5F, 0x74, 0x65, 0x73, 0x74,
				0x07, (byte) 0x89, 0x7E };
		
//		session.write(loginData);
		
		
		/*String wd = "7e b9 0e 50 00 09 03 c7 2a 24 02 e2 07 04 0e 0f 24 21 00 ea 78 3b 07 61 ab dd 01 01 04 00 00 e2 07 04 0e 0f 2e 35 00 33 79 3b 07 4e ab dd 01 01 04 00 00 05 00 03 00 0d 00 5f 00 00 00 00 00 0d 00 5f 00 05 00 00 00 0d 00 5f 00 05 00 00 00 c7 2a 24 02 e2 07 04 0e 0f 24 21 00 ea 78 3b 07 61 ab dd 01 01 04 00 00 e2 07 04 0e 0f 2e 35 00 33 79 3b 07 4e ab dd 01 01 04 00 00 05 00 03 00 0d 00 5f 00 00 00 00 00 0d 00 5f 00 05 00 00 00 0d 00 5f 00 05 00 00 00 c7 2a 24 02 e2 07 04 0e 0f 24 21 00 ea 78 3b 07 61 ab dd 01 01 04 00 00 e2 07 04 0e 0f 2e 35 00 33 79 3b 07 4e ab dd 01 01 04 00 00 05 \r\n" + 
				"00 03 00 0d 00 5f 00 00 00 00 00 0d 00 5f 00 05 00 00 00 0d 00 5f 00 05 00 00 00 f4 b1 7e";
		*/
		String wd = "7e 2e 8b 98 00 09 02 76 7f e6 01 e2 07 07 16 0a 02 35 00 db e3 34 07 6d 89 d5 01 01 14 00 00 e2 07 07 16 0a 02 35 02 3b 1a 35 07 7a a7 d5 01 01 14 00 00 01 00 01 00 17 1d 64 00 00 00 00 00 af 7f e6 01 e2 07 07 16 09 3a 2e 00 54 01 30 07 40 46 dc 01 01 13 00 00 e2 07 07 16 0a 02 2e 02 45 01 30 07 45 46 dc 01 01 13 00 00 01 00 05 00 17 1c 64 00 00 00 00 00 17 1c 64 00 01 00 00 00 17 1c 64 00 01 00 00 00 17 1c 64 00 01 00 00 00 17 1c 64 00 01 00 00 00 e4 c0 7e";
		
		String gj = "7e 28 0b 80 00 01 03 76 7d 02 e6 01 e2 07 07 05 02 02 29 02 55 7f 39 07 89 2c ce 01 01 13 05 64 62 19 02 00 f0 23 8d 00 00 00 03 02 a8 28 02 00 76 7f e6 01 e2 07 07 05 02 02 30 02 a3 bb 3b 07 fa 2b dd 01 01 14 0d 64 63 14 02 00 00 19 10 00 00 00 f7 01 d1 11 00 00 7d 02 7f e6 01 e2 07 07 05 02 02 37 02 e8 71 36 07 dc 11 d7 01 01 15 08 64 63 21 02 00 c4 22 4f 00 00 00 0d 02 f5 05 01 00 bc 19 7e";
		
		// 温度数据  start
		byte[] wdData = ByteDisposeUtil.hexStringToBytes(wd);
		byte[] wdDataDtf = DataTransferUtil.upDataTransfer(wdData);
		byte[] message = Arrays.copyOfRange(wdDataDtf, 1, wdDataDtf.length - 3);
		// 生成crc校验码
		int crc = CRCUtil.do_crc(message);
		// 打印16进制crc值
		System.out.println(String.format("0x%04x", crc));
		wdData[wdData.length - 3] = (byte) (crc & 0x000000ff);
		wdData[wdData.length - 2] = (byte) (crc >> 8 & 0x0000ff);
		session.write(wdData);
		// 温度数据 end
		 
		
		// 轨迹数据   start
		byte[] gjData = ByteDisposeUtil.hexStringToBytes(gj);
		byte[] gjDataDtf = DataTransferUtil.upDataTransfer(gjData);
		message = Arrays.copyOfRange(gjDataDtf, 1, gjDataDtf.length - 3);
		crc = CRCUtil.do_crc(message);
		System.out.println(String.format("0x%04x", crc));
		gjData[gjData.length - 3] = (byte) (crc & 0x000000ff);
		gjData[gjData.length - 2] = (byte) (crc >> 8 & 0x0000ff);
//		session.write(gjData);
		// 轨迹数据   end

	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		session.closeOnFlush();
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		String str = message.toString();
		// 转成byte数组,转义前
		byte[] datas = ByteDisposeUtil.hexStringToBytes(str);
		// 下行报文转换,转义后
		byte[] data = DataTransferUtil.downDataTransfer(datas);
		
		Response response = new Response(data);
		System.out.println("本次接受的报文为: " + str);
		System.out.println("本次接受的报文为: " + response.toString());
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// 转byte数组
		byte[] objectToByteArray = (byte[]) message;
		// 转16进制字符串
		String bytesToHexFun3 = ByteDisposeUtil.bytesToHexFun3(objectToByteArray);

		System.out.println("messageSent:" + bytesToHexFun3);
	}

}
