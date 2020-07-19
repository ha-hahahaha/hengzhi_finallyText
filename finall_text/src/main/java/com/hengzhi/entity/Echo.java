/**
 * projectName: finall_text
 * fileName: Echo.java
 * packageName: com.hengzhi.entity
 * date: 2020-07-16 17:33
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.entity;

/**
 * @version: V1.0
 * @author: huang'k's
 * @className: Echo
 * @packageName: com.hengzhi.entity
 * @description: 回显状态实体类
 * @data: 2020-07-16 17:33
 **/
public class Echo {
    String echoName;
    String echoId;
    String echoStatus;

    public void setEchoName(String echoName) {
        this.echoName = echoName;
    }

    public void setEchoId(String echoId) {
        this.echoId = echoId;
    }

    public void setEchoStatus(String echoStatus) {
        this.echoStatus = echoStatus;
    }

    public String getEchoName() {
        return echoName;
    }

    public String getEchoId() {
        return echoId;
    }

    public String getEchoStatus() {
        return echoStatus;
    }
}