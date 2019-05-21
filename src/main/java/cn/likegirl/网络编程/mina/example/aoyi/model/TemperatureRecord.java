package cn.likegirl.网络编程.mina.example.aoyi.model;

import java.io.Serializable;
import java.util.Date;

public class TemperatureRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -785273311132715873L;
	public Integer id;
	public String vin;
	public String plateLicenseNo;//车牌号
	public String deviceNumber;//设备编码
	public Float temperature1;
	public Float temperature2;
	public Float temperature3;
	public Float temperature4;
	public Float temperature5;
	public Date createTime;
	public Date timestamp;
	private Integer humidity;//湿度
	private Double latitude;//纬度
	private Double longitude;//经度
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getPlateLicenseNo() {
		return plateLicenseNo;
	}
	public void setPlateLicenseNo(String plateLicenseNo) {
		this.plateLicenseNo = plateLicenseNo;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public Float getTemperature1() {
		return temperature1;
	}
	public void setTemperature1(Float temperature1) {
		this.temperature1 = temperature1;
	}
	public Float getTemperature2() {
		return temperature2;
	}
	public void setTemperature2(Float temperature2) {
		this.temperature2 = temperature2;
	}
	public Float getTemperature3() {
		return temperature3;
	}
	public void setTemperature3(Float temperature3) {
		this.temperature3 = temperature3;
	}
	public Float getTemperature4() {
		return temperature4;
	}
	public void setTemperature4(Float temperature4) {
		this.temperature4 = temperature4;
	}
	public Float getTemperature5() {
		return temperature5;
	}
	public void setTemperature5(Float temperature5) {
		this.temperature5 = temperature5;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "TemperatureRecord [id=" + id + ", vin=" + vin + ", plateLicenseNo=" + plateLicenseNo + ", deviceNumber="
				+ deviceNumber + ", temperature1=" + temperature1 + ", temperature2=" + temperature2 + ", temperature3="
				+ temperature3 + ", temperature4=" + temperature4 + ", temperature5=" + temperature5 + ", createTime="
				+ createTime + ", timestamp=" + timestamp + ", humidity=" + humidity + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	
}
