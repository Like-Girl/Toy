package cn.likegirl.java.io.mina.example.aoyi.model;


/**
 * 
 * @author LikeGirl
 *
 */
public class Status {
	/**
	 * <p>电池电量</p>
	 * 
	 * 说明:	百分比形式 如：90 表示 90%
	 */
	private int batteryPower; 
	
	/**
	 * <p>温度值</p>
	 * 
	 * 说明:	单位1摄氏度
	 */
	private int temperature; 
	
	/**
	 * <p>状态</p>
	 * 
	 * 说明:	
	 * 	BITO:表示装载状态
	 * 		0:空载  1:装载
	 * 	BIT1:表示外界电池状态
	 * 		0:电池供电 1:外界电源
	 * 	BIT2:拆盖指示
	 * 		0:未拆盖 1:拆盖
	 */
	private int status; 
	
	/**
	 * 保留字段
	 */
	private Object reserved;

	public int getBatteryPower() {
		return batteryPower;
	}

	public void setBatteryPower(int batteryPower) {
		this.batteryPower = batteryPower;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getReserved() {
		return reserved;
	}

	public void setReserved(Object reserved) {
		this.reserved = reserved;
	} 
	
	

}
