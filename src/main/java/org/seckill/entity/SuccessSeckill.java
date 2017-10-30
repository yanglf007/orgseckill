package org.seckill.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class SuccessSeckill {
    private long seckillId;
    private long userPhone;
    private Date createTime;
    private char state;
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessSeckill{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", createTime=" + createTime +
                ", state=" + state +
                ", seckill=" + seckill.toString() +
                '}';
    }
}
