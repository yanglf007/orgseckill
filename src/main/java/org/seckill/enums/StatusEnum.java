package org.seckill.enums;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public enum StatusEnum {
    Success(0,"成功"),Pay(1,"付款"),Failed(-1,"失败");
    private int status;
    private String statusInfo;

    StatusEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
    public static StatusEnum valueof(int status){
        for (StatusEnum s:values()
             ) {
            if(s.getStatus()==status){
                return s;
            }
        }
        return null;
    }
}
