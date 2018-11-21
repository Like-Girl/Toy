package cn.likegirl.mina.example.aoyi;


import java.io.Serializable;

/**
 * 配置信息主动下发实体类; 注意: 实体的每个属性必须有值, 否则下发配置会不成功, 这里会标识一个默认值, 如不需要更改配置, 请给默认值;
 * 
 * @author xu
 *
 */
public class RequestConfDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String devNum;// 终端编号,终端唯一识别码
	private Integer nonElectricReportPeriod = 15;// 无电上报周期, 单位为 1 分钟 默认为 240（4 小时）(目前默认值是15分钟上报一次)
	private Integer electricReportPeriod = 1;// 有电上报周期, 单位为 1 分钟 默认为 5
	private Integer electricReportDistance = 500;// 有电上报距离, 单位为 1 米 默认为 500
	private Integer vibrationThreshold = 8;// 震动门限, 表示加速度级别等级
	private Integer remind1 = 0;// 保留值1, 默认填 0
	private Integer tempAndHumSamplePeriod = 5;// 温湿度采样周期, 单位为分钟
	private Integer tempAndHumReportPeriod = 15;// 温湿上报周期, 单位为分钟
	private Integer tempHighThreshold = 40;// 温度过高报警门限, 单位为摄氏度 范围[-40~80]
	private Integer tempLowThreshold = -20;// 温度过低报警门限, 单位为摄氏度 范围[-40~80]
	private Integer humHighThreshold = 100;// 湿度过高报警门限, 取值范围[0~100]
	private Integer humLowThreshold = 60;// 湿度过低报警门限, 取值范围[0~100]
	private Integer inclineThreshold = 46;// 倾斜角报警门限 , 单位为 2 度，范围[0~180]
	private Integer remind2 = 0;// 保留值2, 默认填 0

	public String getDevNum() {
		return devNum;
	}

	public void setDevNum(String devNum) {
		this.devNum = devNum;
	}

	public Integer getNonElectricReportPeriod() {
		return nonElectricReportPeriod;
	}

	public void setNonElectricReportPeriod(Integer nonElectricReportPeriod) {
		this.nonElectricReportPeriod = nonElectricReportPeriod;
	}

	public Integer getElectricReportPeriod() {
		return electricReportPeriod;
	}

	public void setElectricReportPeriod(Integer electricReportPeriod) {
		this.electricReportPeriod = electricReportPeriod;
	}

	public Integer getElectricReportDistance() {
		return electricReportDistance;
	}

	public void setElectricReportDistance(Integer electricReportDistance) {
		this.electricReportDistance = electricReportDistance;
	}

	public Integer getVibrationThreshold() {
		return vibrationThreshold;
	}

	public void setVibrationThreshold(Integer vibrationThreshold) {
		this.vibrationThreshold = vibrationThreshold;
	}

	public Integer getRemind1() {
		return remind1;
	}

	public void setRemind1(Integer remind1) {
		this.remind1 = remind1;
	}

	public Integer getTempAndHumSamplePeriod() {
		return tempAndHumSamplePeriod;
	}

	public void setTempAndHumSamplePeriod(Integer tempAndHumSamplePeriod) {
		this.tempAndHumSamplePeriod = tempAndHumSamplePeriod;
	}

	public Integer getTempAndHumReportPeriod() {
		return tempAndHumReportPeriod;
	}

	public void setTempAndHumReportPeriod(Integer tempAndHumReportPeriod) {
		this.tempAndHumReportPeriod = tempAndHumReportPeriod;
	}

	public Integer getTempHighThreshold() {
		return tempHighThreshold;
	}

	public void setTempHighThreshold(Integer tempHighThreshold) {
		this.tempHighThreshold = tempHighThreshold;
	}

	public Integer getTempLowThreshold() {
		return tempLowThreshold;
	}

	public void setTempLowThreshold(Integer tempLowThreshold) {
		this.tempLowThreshold = tempLowThreshold;
	}

	public Integer getHumHighThreshold() {
		return humHighThreshold;
	}

	public void setHumHighThreshold(Integer humHighThreshold) {
		this.humHighThreshold = humHighThreshold;
	}

	public Integer getHumLowThreshold() {
		return humLowThreshold;
	}

	public void setHumLowThreshold(Integer humLowThreshold) {
		this.humLowThreshold = humLowThreshold;
	}

	public Integer getInclineThreshold() {
		return inclineThreshold;
	}

	public void setInclineThreshold(Integer inclineThreshold) {
		this.inclineThreshold = inclineThreshold;
	}

	public Integer getRemind2() {
		return remind2;
	}

	public void setRemind2(Integer remind2) {
		this.remind2 = remind2;
	}

}
