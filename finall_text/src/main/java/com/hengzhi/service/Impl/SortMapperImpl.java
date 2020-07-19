/**
 * projectName: finall_text (2)
 * fileName: SortMapperImpl.java
 * packageName: com.hengzhi.service.Impl
 * date: 2020-07-18 19:01
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.service.Impl;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.SortMapper;
import com.hengzhi.dao.UserMapper;
import com.hengzhi.entity.Sort;
import com.hengzhi.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SortMapperImpl
 * @packageName: com.hengzhi.service.Impl
 * @description:
 * @data: 2020-07-18 19:01
 **/
public class SortMapperImpl implements SortMapper {
    @Override
    public List<Sort> selectSorts() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SortMapper dao  =  sqlSession.getMapper(SortMapper.class);
        //调用dao的方法， 执行数据库的操作
        List<Sort>sorts= dao.selectSorts();
        return sorts;
    }

    @Override
    public Sort selectSortId(String sortName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SortMapper dao  =  sqlSession.getMapper(SortMapper.class);
        Sort sort = dao.selectSortId(sortName);
        return  sort;
    }

    @Override
    public void updateSort(String sortName, int sortId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SortMapper dao  =  sqlSession.getMapper(SortMapper.class);
        dao.updateSort(sortName,sortId);
    }

    @Override
    public void deleteSort(String sortName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SortMapper dao  =  sqlSession.getMapper(SortMapper.class);
        dao.deleteSort(sortName);
    }

    @Override
    public void addSort(String sortName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SortMapper dao  =  sqlSession.getMapper(SortMapper.class);
        dao.addSort(sortName);
    }
}