/**
 * projectName: finall_text
 * fileName: Inform.java
 * packageName: com.hengzhi.entity
 * date: 2020-07-13 22:34
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.entity;

/**
 * @version: V1.0
 * @author: huangks
 * @className: Inform
 * @packageName: com.hengzhi.entity
 * @description: 通知实体类
 * @data: 2020-07-13 22:34
 **/
public class Inform {
    private int informId;
    private String title;
    private String author;
    private String content;
    private String writeTime;
    private String alterTime;
    private int sortId;

    public int getNewsId() {
        return informId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public int getSortId() {
        return sortId;
    }

    public void setNewsId(int newsId) {
        this.informId = newsId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "NewOne{" +
                "newsId=" + informId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", writeTime='" + writeTime + '\'' +
                ", alterTime='" + alterTime + '\'' +
                ", sortId=" + sortId +
                '}';
    }
}