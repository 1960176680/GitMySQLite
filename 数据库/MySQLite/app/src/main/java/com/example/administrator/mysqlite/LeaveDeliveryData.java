package com.example.administrator.mysqlite;

/**
 * 留仓件实体类
 */
public class LeaveDeliveryData {

    private String leaveDeliveryCode;
    private String leaveDeliveryPerson;
    private String leaveDeliveryPersonNum;
    private String leaveDeliveryReason;
    private String scanTime;
    private String uploadTime;
    private int status;

    public String getLeaveDeliveryCode() {
        return leaveDeliveryCode;
    }

    public void setLeaveDeliveryCode(String leaveDeliveryCode) {
        this.leaveDeliveryCode = leaveDeliveryCode;
    }

    public String getLeaveDeliveryPerson() {
        return leaveDeliveryPerson;
    }

    public void setLeaveDeliveryPerson(String leaveDeliveryPerson) {
        this.leaveDeliveryPerson = leaveDeliveryPerson;
    }

    public String getLeaveDeliveryPersonNum() {
        return leaveDeliveryPersonNum;
    }

    public void setLeaveDeliveryPersonNum(String leaveDeliveryPersonNum) {
        this.leaveDeliveryPersonNum = leaveDeliveryPersonNum;
    }

    public String getLeaveDeliveryReason() {
        return leaveDeliveryReason;
    }

    public void setLeaveDeliveryReason(String leaveDeliveryReason) {
        this.leaveDeliveryReason = leaveDeliveryReason;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){//提高效率
            return true;
        }
        if(!(obj instanceof LeaveDeliveryData)){//调高安全性
            return false;
        }

        LeaveDeliveryData data=(LeaveDeliveryData) obj;
        return this.leaveDeliveryCode.equals(data.leaveDeliveryCode);
    }
}
