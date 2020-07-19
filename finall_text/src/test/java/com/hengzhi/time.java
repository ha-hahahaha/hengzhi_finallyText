/**
 * projectName: finall_text
 * fileName: time.java
 * packageName: com.hengzhi
 * date: 2020-07-17 1:51
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: time
 * @packageName: com.hengzhi
 * @description:
 * @data: 2020-07-17 1:51
 **/
public class time {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}