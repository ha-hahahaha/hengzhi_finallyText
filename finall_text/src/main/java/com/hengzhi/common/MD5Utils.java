/**
 * projectName: finall_text
 * fileName: MD5Utils.java
 * packageName: com.hengzhi.common
 * date: 2020-07-13 16:35
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version: V1.0
 * @author: huangks
 * @className: MD5Utils
 * @packageName: com.hengzhi.common
 * @description: md5密码加密工具类
 * @data: 2020-07-13 16:35
 **/
public class MD5Utils {
    /**
     *
     * @param plainText
     * @return 字符串
     */
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}