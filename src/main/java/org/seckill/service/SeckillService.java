package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatSeckillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@Service
public interface SeckillService {
    /**
     * 查询秒杀列表页
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offset,int limit);

    /**
     * 查询秒杀详情
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 暴露秒杀接口
     * @param seckill
     * @return
     */
    Exposer exporseSeckillURL(long seckill);

    /**
     * 执行秒杀操作
     * @param seckill
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckill, long userPhone, String md5)
            throws SeckillException,RepeatSeckillException,SeckillCloseException;

}
