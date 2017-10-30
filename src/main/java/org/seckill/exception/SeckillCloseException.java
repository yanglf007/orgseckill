package org.seckill.exception;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class SeckillCloseException extends  SeckillException{
    public SeckillCloseException() {
    }

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
