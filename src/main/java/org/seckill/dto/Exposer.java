package org.seckill.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class Exposer {
    private boolean exposed;
    private long seckillId;
    private Date now;
    private Date startTime;
    private Date endTime;
    private String md5;

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }



    public static class Builder{
        //必须属性
        private boolean explosed;
        private  long seckillId;
        //可选属性
        private Date now;
        private Date startTime;
        private Date endTime;
        private String md5;

        public Builder(boolean explosed,long seckillId){
            this.explosed = explosed;
            this.seckillId = seckillId;
        }

        public Builder now(Date now){
            this.now = now;
            return this;
        }
        public Builder startTime(Date startTime){
            this.startTime = startTime;
            return this;
        }
        public Builder endTime(Date endTime){
            this.endTime = endTime;
            return this;
        }
        public Builder md5(String md5){
            this.md5 = md5;
            return this;
        }

        public Exposer build(){
            return new Exposer(this);
        }
    }

    private Exposer(Builder builder){
        this.exposed = builder.explosed;
        this.seckillId = builder.seckillId;
        this.now = builder.now;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.md5 = builder.md5;
    }
}

