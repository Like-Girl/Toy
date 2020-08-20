package cn.likegirl.java.io.mina.example.aoyi.codec;


import java.nio.ByteBuffer;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteArrayDecoder extends CumulativeProtocolDecoder {

	public static Logger log = LoggerFactory.getLogger(ByteArrayDecoder.class);

	/**
	 * 
	 * 这个方法的返回值是重点：
	 * 
	 * 1、当内容刚好时，返回false，告知父类接收下一批内容
	 * 
	 * 2、内容不够时需要下一批发过来的内容，此时返回false，这样父类 CumulativeProtocolDecoder
	 * 
	 * 会将内容放进IoSession中，等下次来数据后就自动拼装再交给本类的doDecode
	 * 
	 * 3、当内容多时，返回true，因为需要再将本批数据进行读取，父类会将剩余的数据再次推送本
	 * 
	 * 类的doDecode
	 * 
	 */

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

		if (in.remaining() < 1) {
			return false;
		}
		in.mark();

		ByteBuffer bf = in.buf();
		byte[] data = new byte[bf.limit()];
		bf.get(data);

		//byte[] data = new byte[in.remaining()];
		//in.get(data);
		log.info("--------------------------------本次报文接收长度为--------------------------------: " + data.length);
		int pos = 0;
		in.reset();
		while (in.remaining() > 0) {
			in.mark();
			byte tag = in.get();
			// 搜索包的开始位置
			if (tag == 0x7E && in.remaining() > 0) {
				tag = in.get();
				// 寻找包的结束
				while (tag != 0x7E) {
					if (in.remaining() <= 0) {
						in.reset(); // 没有找到结束包，等待下一次包
						return false;
					}
					tag = in.get();
				}
				pos = in.position();
				int packetLength = pos - in.markValue();
				if (packetLength > 1) {
					byte[] tmp = new byte[packetLength];
					in.reset();
					in.get(tmp);
					// 解析
					String result = "";
					for (int i = 0; i < tmp.length; i++) { // 转换16进制 String
						String getM = Integer.toHexString(tmp[i] & 0xFF) + "";
						if (getM.length() < 2) {
							getM = "0" + getM;
						}
						result += getM + " ";
					}
					out.write(result); // 触发接收Message的事件
				}
			}
		}
		return false;
	}

	/**
	 * 二字节byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序。
	 * 
	 * @param ary
	 *            byte数组
	 * @param offset
	 *            从数组的第offset位开始
	 * @return int数值
	 */
	public static int bytesToInt2(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] << 8) & 0xFF00));
		return value;
	}

}
