/**
 * projectName: finall_text
 * fileName: InformMapperIml.java
 * packageName: com.hengzhi.service.Impl
 * date: 2020-07-13 22:38
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.service.Impl;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.InformMapper;
import com.hengzhi.dao.NewsMapper;
import com.hengzhi.entity.Inform;
import com.hengzhi.entity.NewOne;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: InformMapperIml
 * @packageName: com.hengzhi.service.Impl
 * @description: 接口实现类
 * @data: 2020-07-13 22:38
 **/
public class InformMapperImpl implements InformMapper {
    @Override
    public List<Inform> selectAllInform(String keyword) {
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            InformMapper dao  =  sqlSession.getMapper(InformMapper.class);
            //调用dao的方法， 执行数据库的操作
            List<Inform>  informList = dao.selectAllInform(keyword);
            return informList;
    }
    @Override
    public void updateInform(String newTitle, String newAuthor, String newContent, Date newTime , int newsId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        InformMapper dao = sqlSession.getMapper(InformMapper.class);
        dao.updateInform(newTitle,newAuthor,newContent,newTime,newsId);
    }

    @Override
    public void insertInform(String newTitle, String newAuthor, String newContent, Date newTime) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        InformMapper dao = sqlSession.getMapper(InformMapper.class);
        dao.insertInform(newTitle,newAuthor,newContent,newTime);
    }

    @Override
    public void deleteInform(String title) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        InformMapper dao = sqlSession.getMapper(InformMapper.class);
        dao.deleteInform(title);
    }
}