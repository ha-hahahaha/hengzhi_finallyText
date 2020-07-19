/**
 * projectName: finall_text
 * fileName: User.java
 * packageName: com.hengzhi.entity
 * date: 2020-07-14 2:27
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.entity;

/**
 * @version: V1.0
 * @author: huangks
 * @className: User
 * @packageName: com.hengzhi.entity
 * @description: 用户类
 * @data: 2020-07-14 2:27
 **/
public class User {
    int userId;
    String username;
    String password;
    String image;
    int age;
    String information;
    int ifAdmin;

    public void setIfAdmin(int ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    public int getIfAdmin() {
        return ifAdmin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getInformation() {
        return information;
    }

    public String getImage() {
        return image;
    }
}