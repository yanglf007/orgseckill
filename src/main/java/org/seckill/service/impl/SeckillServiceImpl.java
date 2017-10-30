package org.seckill.service.impl;

import org.seckill.Utils.StringUtils;
import org.seckill.dao.RedisDao;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessSeckillDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessSeckill;
import org.seckill.enums.StatusEnum;
import org.seckill.exception.RepeatSeckillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessSeckillDao successSeckillDao;

    @Autowired
    private RedisDao redisDao;
    public List<Seckill> queryAll(int offset, int limit) {
        return seckillDao.queryAll(offset,limit);
    }

    public Seckill queryById(long seckillId) {
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (seckill==null) {
            seckill = seckillDao.queryById(seckillId);
            if (seckill != null) {

                redisDao.putSeckill(seckill);
            }
        }
            return seckill;
    }

    public Exposer exporseSeckillURL(long seckillId) {



         Seckill  seckill = this.queryById(seckillId);

        if(seckill==null){
           // return new Exposer(false,seckillId);
            return  new Exposer.Builder(false,seckillId).build();
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date now = new Date();

        if(startTime.getTime()>now.getTime()||endTime.getTime()<now.getTime()){
           // return new Exposer(false,now,seckillId,startTime,endTime);
            return  new Exposer.Builder(false,seckillId)
                    .now(now)
                    .startTime(startTime)
                    .endTime(endTime)
                    .build();
        }
       // return new Exposer(true, StringUtils.getMD5(seckillId),seckillId);
        return new Exposer.Builder(true,seckillId).md5(StringUtils.getMD5(seckillId)).build();
    }

    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatSeckillException, SeckillCloseException {

        if(md5==null||!md5.equals(StringUtils.getMD5(seckillId))){
            throw new SeckillException("数据异常");
        }
        int i1 = seckillDao.reduceNum(seckillId, new Date());
        if(i1<=0){
            throw new SeckillCloseException("秒杀结束");
        }
        int i = successSeckillDao.insertSuccessedKill(seckillId, userPhone);
        if(i<=0){
            throw new RepeatSeckillException("重复秒杀");
        }
        SuccessSeckill successSeckill = successSeckillDao.queryByIdWidthSeckill(seckillId, userPhone);


        return new SeckillExecution(seckillId, StatusEnum.Success,successSeckill);
    }
}
