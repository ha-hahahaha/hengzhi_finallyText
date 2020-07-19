/**
 * projectName: finall_text
 * fileName: NewsMapperImpl.java
 * packageName: com.hengzhi.service.Impl
 * date: 2020-07-12 19:06
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.service.Impl;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.NewsMapper;
import com.hengzhi.entity.NewOne;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: NewsMapperImpl
 * @packageName: com.hengzhi.service.Impl
 * @description:
 * @data: 2020-07-12 19:06
 **/
public class NewsMapperImpl implements NewsMapper {
    @Override
    public List<NewOne> selectAllNews(String keyword) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NewsMapper dao  =  sqlSession.getMapper(NewsMapper.class);
        //调用dao的方法， 执行数据库的操作
        List<NewOne>  newsList = dao.selectAllNews(keyword);
        return newsList;
    }
    public List<NewOne> bothSelect(String keyword) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NewsMapper dao  =  sqlSession.getMapper(NewsMapper.class);
        //调用dao的方法， 执行数据库的操作
        List<NewOne>  newsList = dao.bothSelect(keyword);
        return newsList;
    }

    @Override
    public void updateNews(String newTitle, String newAuthor, String newContent, Date newTime , int newsId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NewsMapper dao  =  sqlSession.getMapper(NewsMapper.class);

        //调用dao的方法， 执行数据库的操作
        dao.updateNews(newTitle,newAuthor,newContent,newTime,newsId);
    }

    @Override
    public void insertNews(String newTitle, String newAuthor, String newContent, Date newTime,int sortId) {
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            NewsMapper dao  =  sqlSession.getMapper(NewsMapper.class);
            dao.insertNews(newTitle,newAuthor,newContent,newTime,sortId);
    }

    @Override
    public void deleteNews(String title) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NewsMapper dao  =  sqlSession.getMapper(NewsMapper.class);
        dao.deleteNews(title);
    }

    @Override
    public List<NewOne> selectSortNews(int sortId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        NewsMapper dao  =  sqlSession.getMapper(NewsMapper.class);
        List<NewOne>newOnes= dao.selectSortNews(sortId);
        return newOnes;
    }
}