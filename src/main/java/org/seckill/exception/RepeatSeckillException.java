package org.seckill.exception;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class RepeatSeckillException extends SeckillException {
    public RepeatSeckillException(String message) {
        super(message);
    }

    public RepeatSeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatSeckillException() {
    }
}
