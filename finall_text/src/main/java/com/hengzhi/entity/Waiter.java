/**
 * projectName: finall_text
 * fileName: Waiter.java
 * packageName: com.hengzhi.entity
 * date: 2020-07-15 21:40
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.entity;

/**
 * @version: V1.0
 * @author: huangks
 * @className: Waiter
 * @packageName: com.hengzhi.entity
 * @description: 等待审核实体
 * @data: 2020-07-15 21:40
 **/
public class Waiter {
    int waitId;
    String waitUsername;
    String waitUserPwd;

    public int getWaitId() {
        return waitId;
    }

    public String getWaitUsername() {
        return waitUsername;
    }

    public String getWaitUserPwd() {
        return waitUserPwd;
    }

    public void setWaitId(int waitId) {
        this.waitId = waitId;
    }

    public void setWaitUsername(String waitUsername) {
        this.waitUsername = waitUsername;
    }

    public void setWaitUserPwd(String waitUserPwd) {
        this.waitUserPwd = waitUserPwd;
    }
}