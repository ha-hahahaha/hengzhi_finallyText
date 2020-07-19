/**
 * projectName: finall_text
 * fileName: MyBatisUtils.java
 * packageName: com.hengzhi.common
 * date: 2020-07-12 19:14
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @version: V1.0
 * @author: huangks
 * @className: MyBatisUtils
 * @packageName: com.hengzhi.common
 * @description: mybatis工具
 * @data: 2020-07-12 19:14
 **/
public class MyBatisUtils {

    private static SqlSessionFactory factory = null;

    public MyBatisUtils() {
    }

    /**
     * 静态代码块，保证只执行一次
     * @return
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession(true);
        }

        return sqlSession;
    }

    /**
     * 静态代码块，保证只执行一次
     */
    static {
        String config = "config\\mybatis.xml";

        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = (new SqlSessionFactoryBuilder()).build(in);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}