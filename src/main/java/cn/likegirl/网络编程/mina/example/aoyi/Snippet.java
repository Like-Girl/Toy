package cn.likegirl.网络编程.mina.example.aoyi;

public class Snippet {
	public static String VEHICLE_CURRENT_ALARM = "VDATA:DATA:VEHICLE_CURRENT_ALARM:";// 报警
		public static String VDATA_VEHICLE_CURRENT_TEMP = "VDATA:DATA:VEHICLE_CURRENT_TEMP:";// 温度
		public static String VDATA_INTERNET_EQUIPMENT = "VDATA:COMMON:INTERNET_EQUIPMENT:";// 互联网设备缓存
		public static String VDATA_CUR_COM_CONDITION = "VDATA:DATA:CUR_COM_CONDITION:";// 整合后的车况信息
		// 车辆基本信息，2018-5-16添加了车辆使用车载设备的类型，datatype=0，使用TBOX数据为主干，GPS使用TBOX的，datatype=1，不使用TBOX，使用互联网设备对数据进行拼凑
		public static String VDATA_VEHICLE_INFO = "VDATA:COMMON:VEHICLE_INFO:";
		public static String VDATA_DEVICENUMBER_INFO = "VDATA:COMMON:DEVICENUMBER_INFO:";
		public static String VDATA_TEMPERATURE_ALARM = "VDATA:DATA:TEMPERATURE_ALARM:";//温度报警的设置，哪些温湿度设备有哪些设置
		public static String VDATA_CURRENT_CONDITION = "VDATA:DATA:CURRENT_CONDITION:";//修改后，以vdata开头保留TBOX数据
}

