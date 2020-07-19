/**
 * projectName: finall_text (2)
 * fileName: Sort.java
 * packageName: com.hengzhi.entity
 * date: 2020-07-18 18:59
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.entity;

/**
 * @version: V1.0
 * @author: huangks
 * @className: Sort
 * @packageName: com.hengzhi.entity
 * @description: 新闻分类
 * @data: 2020-07-18 18:59
 **/
public class Sort {
    int sortId;
    String sortName;
    String addTime;

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}