package cn.likegirl.mina.example.aoyi.utils;


/**
 * int<-->byte转换工具类
 * 
 * @author xu
 *
 */
public class ByteDisposeUtil {
	/**
	 * 一字节byte数组中取int数值
	 *
	 * <p> 无符号解析 </p>
	 * <p> 取值范围：0 - 255 </p>
	 * <p> 本方法适用于(低位在前，高位在后)的顺序 </p>
	 *
	 * @param ary		byte数组
	 * @param offset	从数组的第offset位开始
	 * @return int		数值
	 */
	public static int bytesL1ToUInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF));
		return value;
	}

	/**
	 * 一字节byte数组中取int数值
	 *
	 * <p> 有符号解析 </p>
	 * <p> 取值范围：-127 - 127 </p>
	 * <p> 本方法适用于(低位在前，高位在后)的顺序 </p>
	 *
	 * @param ary		byte数组
	 * @param offset	从数组的第offset位开始
	 * @return int		数值
	 */
	public static int bytesL1ToInt(byte[] ary, int offset) {
		int value;
		value = (int) (ary[offset]);
		return value;
	}



	/**
	 * 二字节byte数组中取int数值
	 *
	 *  <p> 无符号解析 </p>
	 * 	<p> 取值范围：0 - 65535 </p>
	 * 	<p> 本方法适用于(低位在前，高位在后)的顺序 </p>
	 *
	 * @param ary		byte数组
	 * @param offset	从数组的第offset位开始
	 * @return int		数值
	 */
	public static int bytesL2ToUInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] & 0xFF) << 8));
		return value;
	}

	/**
	 * 二字节byte数组中取int数值
	 *
	 *  <p> 有符号解析 </p>
	 * 	<p> 取值范围：-32767 - 32767 </p>
	 * 	<p> 本方法适用于(低位在前，高位在后)的顺序 </p>
	 *
	 * @param ary		byte数组
	 * @param offset	从数组的第offset位开始
	 * @return int		数值
	 */
	public static int bytesL2ToInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | (ary[offset + 1] << 8));
		return value;
	}



	/**
	 * 四字节byte数组中取int数值
	 *
	 * <p> 无符号解析 </p>
	 * <p> 取值范围：0 - 4294967295 </p>
	 * <p> 本方法适用于(低位在前，高位在后)的顺序 </p>
	 *
	 * @param ary		byte数组
	 * @param offset	从数组的第offset位开始
	 * @return int		数值
	 */
	public static int bytesL4ToUInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] & 0xFF) << 8) | ((ary[offset + 2] & 0xFF) << 16) | ((ary[offset + 3] & 0xFF)) << 24);
		return value;
	}

	/**
	 * 四字节byte数组中取int数值
	 *
	 * <p> 有符号解析 </p>
	 * <p> 取值范围：-2147483647 - 2147483647 </p>
	 * <p> 本方法适用于(低位在前，高位在后)的顺序 </p>
	 *
	 * @param ary		byte数组
	 * @param offset	从数组的第offset位开始
	 * @return int		数值
	 */
	public static int bytesL4ToInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] & 0xFF) << 8) | ((ary[offset + 2] & 0xFF) << 16) | (ary[offset + 3]) << 24);
		return value;
	}

	/**
	 * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。
	 * 
	 * @param value
	 *            要转换的int值
	 * @return byte数组
	 */
	public static byte[] intToBytes(int value) {
		byte[] byte_src = new byte[4];
		byte_src[3] = (byte) ((value & 0xFF000000) >> 24);
		byte_src[2] = (byte) ((value & 0x00FF0000) >> 16);
		byte_src[1] = (byte) ((value & 0x0000FF00) >> 8);
		byte_src[0] = (byte) ((value & 0x000000FF));
		return byte_src;
	}

	/**
	 * 将byte数组转成16进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun3(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) { // 使用String的format方法进行转换
			buf.append(String.format("%02x", new Integer(b & 0xff)) + " ");
		}

		return buf.toString();
	}

	/**
	 * 将字符串形式表示的十六进制数转换为byte数组
	 */
	public static byte[] hexStringToBytes(String hexString) {
		hexString = hexString.toLowerCase();
		String[] hexStrings = hexString.split(" ");
		byte[] bytes = new byte[hexStrings.length];
		for (int i = 0; i < hexStrings.length; i++) {
			char[] hexChars = hexStrings[i].toCharArray();
			bytes[i] = (byte) (charToByte(hexChars[0]) << 4 | charToByte(hexChars[1]));
		}
		return bytes;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789abcdef".indexOf(c);
	}
}
