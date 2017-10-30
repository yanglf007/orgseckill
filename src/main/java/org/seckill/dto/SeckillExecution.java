package org.seckill.dto;

import org.seckill.entity.SuccessSeckill;
import org.seckill.enums.StatusEnum;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class SeckillExecution {
    private long seckillId;
    private int state;
    private String stateInfo;
    private SuccessSeckill successSeckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessSeckill getSuccessSeckill() {
        return successSeckill;
    }

    public void setSuccessSeckill(SuccessSeckill successSeckill) {
        this.successSeckill = successSeckill;
    }

    public SeckillExecution(long seckillId, StatusEnum statusEnum, SuccessSeckill successSeckill) {
        this.seckillId = seckillId;
        this.state = statusEnum.getStatus();
        this.stateInfo = statusEnum.getStatusInfo();
        this.successSeckill = successSeckill;
    }


}
