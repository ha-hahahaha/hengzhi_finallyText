/**
 * projectName: finall_text
 * fileName: UserMapperImpl.java
 * packageName: com.hengzhi.service.Impl
 * date: 2020-07-14 2:34
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.service.Impl;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.UserMapper;
import com.hengzhi.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserMapperImpl
 * @packageName: com.hengzhi.service.Impl
 * @description:
 * @data: 2020-07-14 2:34
 **/
public class UserMapperImpl implements UserMapper{
    @Override
    public List<User> selectAllUsers() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        //调用dao的方法， 执行数据库的操作
        List<User>  userList = dao.selectAllUsers();
        return userList;
    }
    public User checkUser(String username,String password) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        //调用dao的方法， 执行数据库的操作
        User user= dao.checkUser(username,password);
        return user;
    }

    @Override
    public User checkUserName(String username) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        User user= dao.checkUserName(username);
        return user;
    }

    public User checkUserId(int userId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        User user= dao.checkUserId(userId);
        return user;
    }

    @Override
    public void insertUser(String username, String password,int ifAdmin) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        dao.insertUser(username,password,ifAdmin);
    }

    @Override
    public void updatePwd(String userName, String pwdNow) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        dao.updatePwd(userName,pwdNow);
    }

    @Override
    public void updateUser(int userId, String userName, int age, String info) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        dao.updateUser(userId,userName,age,info);
    }

    @Override
    public void savePic(String picLink, int userId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        dao.savePic(picLink,userId);
    }

    @Override
    public List<User> selectAdmin() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        List<User> userList = dao.selectAdmin();
        return userList;
    }

    @Override
    public void deleteAdmin(String userName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        dao.deleteAdmin(userName);
    }
}