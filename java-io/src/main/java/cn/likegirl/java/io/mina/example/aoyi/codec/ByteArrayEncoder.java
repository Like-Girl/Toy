package cn.likegirl.java.io.mina.example.aoyi.codec;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * @author BruceYang
 * 
 *         编写编码器的注意事项： 1、 mina 为 IoSession 写队列里的每个对象调用 ProtocolEncode.encode 方法。
 *         因为业务处理器里写出的都是与编码器对应高层对象，所以可以直接进行类型转换。 2、从 jvm 堆分配
 *         IoBuffer，最好避免使用直接缓存，因为堆缓存一般有更好的性能。 3、开发人员不需要释放缓存， mina 会释放。 4、在
 *         dispose 方法里可以释放编码所需的资源。
 */
public class ByteArrayEncoder extends ProtocolEncoderAdapter {
	//编码方法
	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		byte[] bytes = (byte[]) message;

		IoBuffer buffer = IoBuffer.allocate(1024);
		buffer.setAutoExpand(true);

		buffer.put(bytes);
		buffer.flip();

		out.write(buffer);
		out.flush();

		buffer.free();
	}
}
