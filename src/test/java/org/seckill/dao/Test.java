package org.seckill.dao;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Test {

    public static void  main(String [] args){
        long time1 =System.currentTimeMillis();
        Long sum = 0L;
        for (int i=0;i<Integer.MAX_VALUE;i++){
            sum +=i;
        }
        long time2 = System.currentTimeMillis();
        System.out.println(sum+"--时间："+(time2-time1));
    }
}
