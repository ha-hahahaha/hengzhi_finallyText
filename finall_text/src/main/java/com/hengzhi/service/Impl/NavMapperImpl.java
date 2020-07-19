/**
 * projectName: finall_text (2)
 * fileName: NavMapperImpl.java
 * packageName: com.hengzhi.service.Impl
 * date: 2020-07-17 19:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.service.Impl;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.NavMapper;
import com.hengzhi.dao.NewsMapper;
import com.hengzhi.entity.Nav;
import com.hengzhi.entity.NewOne;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: NavMapperImpl
 * @packageName: com.hengzhi.service.Impl
 * @description:
 * @data: 2020-07-17 19:22
 **/
public class NavMapperImpl implements NavMapper {
    @Override
    public List<Nav> selectAllFather() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        //调用dao的方法， 执行数据库的操作

        List<Nav>  list = dao.selectAllFather();
        return list;
    }
    @Override
    public List<Nav> selectAllSon(int navId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        //调用dao的方法， 执行数据库的操作

        List<Nav>  list = dao.selectAllSon(navId);
        return list;
    }

    @Override
    public List<Nav> selectNavName(String navName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        //调用dao的方法， 执行数据库的操作

        List<Nav>  list = dao.selectNavName(navName);
        return list;
    }

    @Override
    public void updateNFather(String navName, String toLink, int navId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        //调用dao的方法， 执行数据库的操作
        dao.updateNFather(navName,toLink,navId);
    }

    @Override
    public void updateNSon(String navName, String toLink, int navId, int fatherId) {
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
            //调用dao的方法， 执行数据库的操作
            dao.updateNSon(navName,toLink,navId,fatherId);
    }

    @Override
    public void addNFather(String navName, String toLink) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        dao.addNFather(navName,toLink);
    }

    @Override
    public void addNSon(String navName, String toLink, int fatherId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        dao.addNSon(navName,toLink,fatherId);
    }

    @Override
    public void deleteNav(String navName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        dao.deleteNav(navName);
    }

    @Override
    public Nav selectFatherName(String fatherName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NavMapper dao  =  sqlSession.getMapper(NavMapper.class);
        Nav nav= dao.selectFatherName(fatherName);
        return nav;
    }
}