/**
 * projectName: finall_text
 * fileName: WaiterMapperImpl.java
 * packageName: com.hengzhi.service.Impl
 * date: 2020-07-15 21:49
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.service.Impl;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.UserMapper;
import com.hengzhi.dao.WaiterMapper;
import com.hengzhi.entity.User;
import com.hengzhi.entity.Waiter;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: WaiterMapperImpl
 * @packageName: com.hengzhi.service.Impl
 * @description:
 * @data: 2020-07-15 21:49
 **/
public class WaiterMapperImpl implements WaiterMapper{
    @Override
    public void insertWaiter(String username, String password) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        WaiterMapper dao  =  sqlSession.getMapper(WaiterMapper.class);
        dao.insertWaiter(username,password);
    }



    @Override
    public List<Waiter> selectWaiter() {
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        WaiterMapper dao  =  sqlSession.getMapper(WaiterMapper.class);
        List<Waiter>waiters= dao.selectWaiter();
        return waiters;
    }

    @Override
    public Waiter selectWaiterName(String waiterName) {
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        WaiterMapper dao  =  sqlSession.getMapper(WaiterMapper.class);
        Waiter waiter = dao.selectWaiterName(waiterName);
        return  waiter;
    }

    @Override
    public void deleteWaiter(String waiterName) {
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        WaiterMapper dao  =  sqlSession.getMapper(WaiterMapper.class);
        dao.deleteWaiter(waiterName);
    }
}