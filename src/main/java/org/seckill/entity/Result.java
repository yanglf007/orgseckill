package org.seckill.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
public class Result {

    private long id;
    private long phone;
    private String state;
    private Date  createDate;
    private Date endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", phone=" + phone +
                ", state='" + state + '\'' +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                '}';
    }
}
