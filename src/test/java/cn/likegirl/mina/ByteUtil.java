package cn.likegirl.mina;

import org.junit.Test;

import java.util.Arrays;

public class ByteUtil {

	/**
	 * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。
	 * 
	 * @param value
	 *            要转换的int值
	 * @return byte数组
	 */
	public static byte[] intToBytes(int value) {
		byte[] bytes = new byte[4];
		bytes[3] = (byte) ((value & 0xFF000000) >> 24);
		bytes[2] = (byte) ((value & 0x00FF0000) >> 16);
		bytes[1] = (byte) ((value & 0x0000FF00) >> 8);
		bytes[0] = (byte) ((value & 0x000000FF));
		return bytes;
	}

	public static byte[] intToBytes2(int value) {
		byte[] bytes = new byte[4];
		bytes[3] = (byte) ((value >> 24) & 0xFF);
		bytes[2] = (byte) ((value >> 16) & 0xFF);
		bytes[1] = (byte) ((value >> 8) & 0xFF);
		bytes[0] = (byte) (value & 0xFF);
		return bytes;
	}

	@Test
	public void test01() {
		int value = -16;
		System.out.println(intToBytes(value));
		System.out.println(intToBytes2(value));
	}

	/**
	 * 四字节byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序。
	 * 
	 * @param ary
	 *            byte数组
	 * @param offset
	 *            从数组的第offset位开始
	 * @return int数值
	 */
	public static int bytesToInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] << 8) & 0xFF00) | ((ary[offset + 2] << 16) & 0xFF0000)
				| ((ary[offset + 3] << 24) & 0xFF000000));
		return value;
	}

	public static int bytesToInt2(byte[] ary, int offset) { // error
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] << 8) & 0xFF) | ((ary[offset + 2] << 16) & 0xFF)
				| ((ary[offset + 3] << 24) & 0xFF));
		return value;
	}

	public static int bytesToInt3(byte[] ary, int offset) { // 无符号位
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] & 0xFF) << 8) | ((ary[offset + 2] & 0xFF) << 16)
				| ((ary[offset + 3] & 0xFF)) << 24);
		return value;
	}

	@Test
	public void test02() {
		byte[] ary = intToBytes(-123456789);
		System.out.println(bytesToInt(ary, 0));
		System.out.println(bytesToInt2(ary, 0)); // error
		System.out.println(bytesToInt3(ary, 0));
	}

	public static int bytesToInt4(byte[] ary, int offset) { // 有符号位
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] & 0xFF) << 8) | ((ary[offset + 2] & 0xFF) << 16)
				| (ary[offset + 3] << 24));
		return value;
	}

	@Test
	public void test03() {
		byte[] ary = intToBytes(2147483647);
		System.out.println(bytesToInt4(ary, 0));
		System.out.println(bytesToInt3(ary, 0));
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
	public static int bytesL2ToInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | ((ary[offset + 1] & 0xFF) << 8));
		return value;
	}
	
	public static int bytesL2ToUInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF) | (ary[offset + 1] << 8));
		return value;
	}

	@Test
	public void test04() {
		byte[] ary = intToBytes(33000);
		System.out.println(Arrays.toString(ary));
		System.out.println(bytesL2ToInt(ary, 0));
		System.out.println(bytesL2ToUInt(ary, 0));
	}
	
	/**
	 * 一字节byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序。
	 * 
	 * @param ary
	 *            byte数组
	 * @param offset
	 *            从数组的第offset位开始
	 * @return int数值
	 */
	public static int bytesL1ToInt(byte[] ary, int offset) {
		int value;
		value = (int) ((ary[offset] & 0xFF));
		return value;
	}
	
	public static int bytesL1ToUInt(byte[] ary, int offset) {
		int value;
		value = (int) (ary[offset]);
		return value;
	}

	@Test
	public void test05() {
		byte[] ary = intToBytes(-100);
		System.out.println(Arrays.toString(ary));
		System.out.println(bytesL1ToInt(ary, 0));
		System.out.println(bytesL1ToUInt(ary, 0));

	}
	

}
