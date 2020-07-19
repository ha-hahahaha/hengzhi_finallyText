/**
 * projectName: finall_text (2)
 * fileName: Nav.java
 * packageName: com.hengzhi.entity
 * date: 2020-07-17 19:17
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.entity;

/**
 * @version: V1.0
 * @author: huangks
 * @className: Nav
 * @packageName: com.hengzhi.entity
 * @description: 导航实体
 * @data: 2020-07-17 19:17
 **/
public class Nav {
    int nameId;
    int fatherId;
    String navName;
    String toLink;

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public String getToLink() {
        return toLink;
    }

    public void setToLink(String toLink) {
        this.toLink = toLink;
    }
}