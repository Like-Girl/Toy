package cn.likegirl.java.io.mina.example.aoyi.utils;

import cn.likegirl.java.io.mina.example.aoyi.model.Status;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>报文解析工具</p>
 * <p>针对aoyi设备</p>
 * 
 * @author LikeGirl
 * @since 1.0.0
 *
 */
public class MessageParsingUtil {

	/**
	 * <p>时间结构解析</p>
	 * 
	 * 
	 * @param datas byte 数组(定长，default:8)
	 * @return java.util.Date
	 */
	public static Date byteToDate(byte[] datas) {
		int year = ByteDisposeUtil.bytesL2ToUInt(Arrays.copyOfRange(datas, 0, 2), 0);
        int month = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 2, 3), 0);
        int day = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 3, 4), 0);
        int hour = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 4, 5), 0);
        int minute = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 5, 6), 0);
        int second = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 6, 7), 0);
        // reserved(保留字段) => start:7 end:8 暂未使用
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hour, minute, second);
        return calendar.getTime();
	}
	
	/**
	 * 
	 * @param datas byte 数组(定长，default:4)
	 * @return Status
	 */
	public static Status byteToStatus(byte[] datas) {
		Status status = new Status();
		// 电量
		int battery = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 0, 1), 0);
		// 温度
		int temperature = ByteDisposeUtil.bytesL1ToInt(Arrays.copyOfRange(datas, 1, 2), 0);
		// 状态
		int boxStatus = ByteDisposeUtil.bytesL1ToInt(Arrays.copyOfRange(datas, 2, 3), 0);
		// 保留字段
		int reserved = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 3, 4), 0);
		status.setBatteryPower(battery);
		status.setTemperature(temperature);
		status.setStatus(boxStatus);
		status.setReserved(reserved);
		return status;
	}
	
	public void test01() {
		String gj = "7e 1d fb 30 00 01 01 49 91 e6 01 e2 07 07 04 10 01 12 02 9d 78 3b 07 df a8 dd 01 01 12 1e 64 63 14 02 00 00 00 00 00 c7 01 00 00 00 00 00 00 56 74 7e";
		
		// 转成byte数组,转义前
        byte[] datas = ByteDisposeUtil.hexStringToBytes(gj);
        // 上行报文转换,转义后
        byte[] upDataTransfer = DataTransferUtil.upDataTransfer(datas);
        
        byte mesNum = datas[6];// 一条报文的报文体数量
        int total = 0; // 每次循环累计
        for (int j = 0; j < mesNum; j++) {
        	// 获取设备编号
            byte[] devNo = Arrays.copyOfRange(datas, 7 + total, 11 + total);
            String realDevNo = ByteDisposeUtil.bytesL4ToUInt(devNo, 0) + "";
            String realDevNoStr = "0" + realDevNo;
            System.out.println(realDevNoStr);
            
            // 采样时间
            byte[] firstSampletime = Arrays.copyOfRange(datas, 11 + total, 19 + total);
            
            Date sampleDateTime = MessageParsingUtil.byteToDate(firstSampletime);
            System.out.println(sampleDateTime.getTime());
            SimpleDateFormat df = new SimpleDateFormat(DateUtils.FORMAT_LONG);
            System.out.println(df.format(sampleDateTime));
        }
        
        
	}
	
	public void test02() {
		String wd = "7e e4 7f 50 03 09 0f 7d 02 7f e6 01 e2 07 07 09 07 38 02 00 90 e2 3a 07 25 21 db 01 01 15 00 00 e2 07 07 09 07 38 02 02 af da 3a 07 98 2c db 01 01 15 00 00 01 00 01 00 17 1d 64 00 00 00 00 00 7d 02 7f e6 01 e2 07 07 09 07 39 02 00 af da 3a 07 98 2c db 01 01 15 00 00 e2 07 07 09 07 39 02 02 68 ce 3a 07 fa 3a db 01 01 15 00 00 01 00 01 00 17 1d 64 00 00 00 00 00 7d 02 7f e6 01 e2 07 07 09 07 3a 03 00 68 ce 3a 07 fa 3a db 01 01 15 00 00 e2 07 07 09 07 3a 03 02 4e bc 3a 07 c2 4f db 01 01 14 00 00 01 00 01 00 17 1d 64 00 00 00 00 00 7d 02 7f e6 01 e2 07 07 09 07 3b 03 00 4e bc 3a 07 c2 4f db 01 01 14 00 00 e2 07 07 09 07 3b 03 02 56 a5 3a 07 53 6c db 01 01 16 00 00 01 00 01 00 17 1d 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 26 03 00 4e d8 39 07 7d 02 60 d9 01 01 15 00 00 e2 07 07 09 07 26 03 02 5e 09 3a 07 d1 76 d9 01 01 16 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 27 03 00 5e 09 3a 07 d1 76 d9 01 01 16 00 00 e2 07 07 09 07 27 03 02 7d 01 38 3a 07 f1 8d d9 01 01 15 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 28 04 00 7d 01 38 3a 07 f1 8d d9 01 01 15 00 00 e2 07 07 09 07 28 04 02 0f 6a 3a 07 12 a7 d9 01 01 15 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 29 05 00 0f 6a 3a 07 12 a7 d9 01 01 15 00 00 e2 07 07 09 07 29 05 02 70 92 3a 07 f3 c0 d9 01 01 15 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 2a 05 00 70 92 3a 07 f3 c0 d9 01 01 15 00 00 e2 07 07 09 07 2a 05 02 30 c5 3a 07 8e e1 d9 01 01 13 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 2b 06 00 30 c5 3a 07 8e e1 d9 01 01 13 00 00 e2 07 07 09 07 2b 06 02 01 e1 3a 07 b7 ef d9 01 01 12 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 2c 07 00 01 e1 3a 07 b7 ef d9 01 01 12 00 00 e2 07 07 09 07 2c 07 02 55 dc 3a 07 db 0a da 01 01 15 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 cc 94 e6 01 e2 07 07 09 07 2d 07 00 55 dc 3a 07 db 0a da 01 01 15 00 00 e2 07 07 09 07 2d 07 02 71 d4 3a 07 25 2d da 01 01 15 00 00 01 00 01 00 19 1f 64 00 00 00 00 00 d1 7f e6 01 e2 07 07 09 07 2f 1d 00 7c 3b 37 07 75 0d d2 01 01 13 00 00 e2 07 07 09 07 2f 1d 02 f1 21 37 07 12 38 d2 01 01 13 00 00 01 00 01 00 17 1c 64 00 00 00 00 00 d1 7f e6 01 e2 07 07 09 07 30 1d 00 f1 21 37 07 12 38 d2 01 01 13 00 00 e2 07 07 09 07 30 1d 02 ac 07 37 07 8b 64 d2 01 01 13 00 00 01 00 01 00 17 1c 64 00 00 00 00 00 d1 7f e6 01 e2 07 07 09 07 31 1e 00 ac 07 37 07 8b 64 d2 01 01 13 00 00 e2 07 07 09 07 31 1e 02 67 ed 36 07 b8 8f d2 01 01 13 00 00 01 00 01 00 17 1c 64 00 00 00 00 00 c6 b2 7e";
//		String wd = "7e a5 0f b8 00 09 03 cc 94 e6 01 e2 07 07 06 02 02 0e 00 84 18 30 07 e6 1e d2 01 01 14 00 00 e2 07 07 06 02 02 0e 02 f6 dd 2f 07 3c 07 d2 01 01 14 00 00 01 00 01 00 08 0d 64 00 00 00 00 00 d1 7f e6 01 e2 07 07 06 02 01 30 00 9b 40 3e 07 76 33 c8 01 01 04 00 00 e2 07 07 06 02 02 30 02 15 3f 3e 07 b8 37 c8 01 01 04 00 00 01 00 02 00 03 08 4c 00 00 00 00 00 03 08 4d 00 01 00 00 00 8f 80 e6 01 e2 07 07 06 02 02 2a 00 67 1f 36 07 43 3f e6 01 01 16 00 00 e2 07 07 06 02 02 2a 02 1b 2a 36 07 29 74 e6 01 01 15 00 00 01 00 01 00 f0 f7 5d 00 00 00 00 00 27 1c 7e";
		// 转成byte数组,转义前
        byte[] datas = ByteDisposeUtil.hexStringToBytes(wd);
        // 上行报文转换,转义后
        datas = DataTransferUtil.upDataTransfer(datas);
        byte mesNum = datas[6];// 一条报文的报文体数量
        int total = 0; // 每次循环累计
        // 判断一条报文有多少条消息
        for (int j = 0; j < mesNum; j++) {

            // 获取设备编号
            byte[] devNo = Arrays.copyOfRange(datas, 7 + total, 11 + total);
            String realDevNo = ByteDisposeUtil.bytesL4ToUInt(devNo, 0) + "";
            String realDevNoStr = "0" + realDevNo;

            try {

                // 首点采样时间
                byte[] firstSampleTime = Arrays.copyOfRange(datas, 11 + total, 19 + total);
                SimpleDateFormat df = new SimpleDateFormat(DateUtils.FORMAT_LONG);
                String firstSampleDateTime = df.format(byteToDate(firstSampleTime));
                
                System.out.println(firstSampleDateTime);

                // 采样周期
                int takeSamplePeriod = ByteDisposeUtil.bytesL2ToUInt(Arrays.copyOfRange(datas, 51 + total, 53 + total), 0);

                // 样本数
                int sampleNum = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(datas, 53 + total, 54 + total), 0);

                // 保留
                byte[] retention = Arrays.copyOfRange(datas, 54 + total, 55 + total);

                for (int i = 0; i < sampleNum; i++) {
                    // 样本1
                    byte[] sampleNO1 = Arrays.copyOfRange(datas, 55 + i * 8 + total, 63 + i * 8 + total);
                    // 温度1 箱内温度
                    int temperatureNO1 = ByteDisposeUtil.bytesL1ToInt(Arrays.copyOfRange(sampleNO1, 0, 1), 0);
                    // 温度2 箱外温度
                    int temperatureNO2 = ByteDisposeUtil.bytesL1ToInt(Arrays.copyOfRange(sampleNO1, 1, 2), 0);
                    // 湿度1 箱内湿度
                    int humidityNO1 = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(sampleNO1, 2, 3), 0);
                    // 湿度2 保留
                    int humidityNO2 = ByteDisposeUtil.bytesL1ToUInt(Arrays.copyOfRange(sampleNO1, 3, 4), 0);
                    // 相对时间 与前一个采样点的相对时间，单位为分钟
                    int relativeTime = ByteDisposeUtil.bytesL2ToUInt(Arrays.copyOfRange(sampleNO1, 4, 6), 0);

                    // 相对时间 时间戳
                    Date relativeTimeStamp = DateUtils.addDateMinut(firstSampleDateTime, takeSamplePeriod * i);
                }
                // 本次循环字节总数
                total = 55 + total + 8 * sampleNum - 7;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        

}
