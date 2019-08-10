package cn.likegirl.java.jvm.io.mina.example.aoyi.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * 针对奥一规则指定的转换
 * 
 * @author xu
 */
public class DataTransferUtil {

	/**
	 * 上行数据转换
	 */
	public static byte[] upDataTransfer(byte[] datas) {

		// int length = datas.length;
		// System.out.println("-----------转换前的长度-----------: " + length);

		TreeMap<Integer, Object> treeMap = new TreeMap<>();

		// 开始进行报文转义

		// 记录要转义字符的数量
		int transferNum = 0;

		List<Object> indexArray = new ArrayList<>();
		for (int i = 0; i < datas.length; i++) {
			treeMap.put(i, datas[i]);

		}

		for (int i = 0; i < datas.length; i++) {
			if (datas[i] == 0x7D && datas[i + 1] == 0x01) {
				treeMap.put(i, (byte) 0x7D);
				// 记录要开始转义的第一个字节位置
				indexArray.add(i + 1);
				transferNum++;
			}

			if (datas[i] == 0x7D && datas[i + 1] == 0x02) {
				treeMap.put(i, (byte) 0x7E);
				// 记录要开始转义的第一个字节位置
				indexArray.add(i + 1);
				transferNum++;
			}
		}

		for (Object object : indexArray) {
			int index = (int) object;

			treeMap.remove(index);
		}

		byte[] datasTransfer = new byte[datas.length - transferNum];
		ArrayList<Object> datasTransferArray = new ArrayList<>();
		// 遍历treemap
		Set<Integer> keySet = treeMap.keySet();
		for (Integer key : keySet) {
			byte object = (byte) treeMap.get(key);
			datasTransferArray.add(object);
		}

		for (int i = 0; i < datasTransferArray.size(); i++) {
			datasTransfer[i] = (byte) datasTransferArray.get(i);
		}

		// System.out.println("-----------转换的字节数-----------: " + transferNum);
		// System.out.println("-----------转换后的长度-----------: " + datasTransfer.length);
		return datasTransfer;

	}

	/**
	 * 下行数据转换
	 */
	public static byte[] downDataTransfer(byte[] byts) {
		// 响应报文转换
		ArrayList<Object> arrayList = new ArrayList<>();

		// transferNum 记录转换次数
		int transferNum = 0;
		for (int i = 0; i < byts.length; i++) {
			if (i == 0 || i == byts.length - 1) {
				arrayList.add(byts[i]);
			} else {
				if (byts[i] == 0x7D) {
					arrayList.add((byte) 0x7D);
					arrayList.add((byte) 0x01);
					transferNum++;
				} else if (byts[i] == 0x7E) {
					arrayList.add((byte) 0x7D);
					arrayList.add((byte) 0x02);
					transferNum++;
				} else {
					arrayList.add(byts[i]);
				}
			}

		}

		// 转换后的数组
		byte[] aferTransfer = new byte[arrayList.size()];

		for (int i = 0; i < aferTransfer.length; i++) {
			aferTransfer[i] = (byte) arrayList.get(i);
		}
		return aferTransfer;
	}

}
