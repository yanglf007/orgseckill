package org.seckill.Utils;

import org.springframework.util.DigestUtils;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class StringUtils {
    private static String salt = "f2q432qASDS2E1124!$!%$%";

    public static String getMD5(long seckillId) {
        String base = seckillId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
