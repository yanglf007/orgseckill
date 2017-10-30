package org.seckill.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2017/7/15 0015.
 */
public class RedisDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JedisPool jedisPool;




    public RedisDao(String ip,int port){
        jedisPool = new JedisPool(ip, port);
    }


    private RuntimeSchema<Seckill> runtimeSchema = RuntimeSchema.createFrom(Seckill.class);
    public Seckill getSeckill(Long seckillId){
        Jedis resource = jedisPool.getResource();
        try {
            String key = "seckill:"+seckillId;
          byte [] bytes=  resource.get(key.getBytes());
          if (bytes!=null){
              Seckill seckill = runtimeSchema.newMessage();
              ProtobufIOUtil.mergeFrom(bytes,seckill,runtimeSchema);
              return seckill;
          }

        }finally {
            resource.close();
        }
        return null;
    }
    public String putSeckill(Seckill seckill){
        Jedis jedis = jedisPool.getResource();
        String key = "seckill:"+seckill.getSeckillId();
        byte [] bytes = ProtobufIOUtil.toByteArray(seckill,runtimeSchema,
                LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        String result = jedis.setex(key.getBytes(), 60 * 60, bytes);
        return result;
    }
}
