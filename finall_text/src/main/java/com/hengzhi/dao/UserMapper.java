package com.hengzhi.dao;

import com.hengzhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 搜索用户
     * @return
     */
    public List<User> selectAllUsers();
    /**
     * 核对登录用户
     * @param username
     * @param password
     * @return
     */
    public User checkUser(@Param("username") String username,
                          @Param("password") String password);
    /**
     * 搜索用户id
     * @param userId
     * @return
     */
    public User checkUserId(int userId);
    /**
     * 搜索用户名字
     * @param username
     * @return
     */
    public User checkUserName(String username);
    /**
     * 插入用户
     * @param username
     * @param password
     * @param ifAdmin
     */
    public void insertUser(@Param("username") String username,
                           @Param("password") String password,
                           @Param("ifAdmin") int ifAdmin);
    /**
     * 更新用户
     * @param userId
     * @param userName
     * @param age
     * @param info
     */
    public void updateUser(@Param("userId") int userId,
                           @Param("userName") String userName,
                           @Param("age") int age,
                           @Param("info")String info);
    /**
     * 单独更新密码
     * @param userName
     * @param pwdNow
     */
    public void updatePwd(@Param("userName") String userName,
                           @Param("pwdNow")String pwdNow);
    /**
     * 保存图片到用户表
     * @param picLink
     * @param userId
     */
    public void savePic(@Param("picLink") String picLink,
                          @Param("userId")int userId);
    /**
     * 选出所有管理员
     * @return
     */
    public List<User> selectAdmin();
    /**
     * 删除管理员
     * @param userName
     */
    public void deleteAdmin(String userName);
}
