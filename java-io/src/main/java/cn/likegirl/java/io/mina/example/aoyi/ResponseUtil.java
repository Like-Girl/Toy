package cn.likegirl.java.io.mina.example.aoyi;

import java.util.Arrays;

import cn.likegirl.网络编程.mina.example.aoyi.utils.CRCUtil;
import cn.likegirl.网络编程.mina.example.aoyi.utils.DataTransferUtil;

public class ResponseUtil {
	
	/**
	 * 生成响应报文
	 * 
	 * @param no
	 * @param flag
	 * @return
	 */
	public static byte[] createResultData(byte[] no, byte flag) {
		byte[] byts = new byte[] { 126, no[0], no[1], 8, 0, 20, flag, 0, 0, 126 };
		byte[] message = Arrays.copyOfRange(byts, 1, 7);
		// 生成crc校验码
		int crc = CRCUtil.do_crc(message);
		// 打印16进制crc值
		System.out.println(String.format("0x%04x", crc));

		byts[7] = (byte) (crc & 0x000000ff);
		byts[8] = (byte) (crc >> 8 & 0x0000ff);

		// 下行报文转换
		byte[] aferTransfer = DataTransferUtil.downDataTransfer(byts);

		return aferTransfer;
	}

}
