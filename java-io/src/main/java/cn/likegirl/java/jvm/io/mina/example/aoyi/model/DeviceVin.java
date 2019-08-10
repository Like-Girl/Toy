package cn.likegirl.java.jvm.io.mina.example.aoyi.model;

public class DeviceVin {
    private Integer id;
    private String deviceNumber;
    private String vin;
    private Integer deviceType;
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

	@Override
	public String toString() {
		return "DeviceVin [id=" + id + ", deviceNumber=" + deviceNumber + ", vin=" + vin + ", deviceType=" + deviceType
				+ ", isDeleted=" + isDeleted + "]";
	}
    
    

}
