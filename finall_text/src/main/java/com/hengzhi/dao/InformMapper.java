package com.hengzhi.dao;

import com.hengzhi.entity.Inform;
import com.hengzhi.entity.NewOne;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface InformMapper {
    /**
     * 查找所有新闻
     * @return
     */
    public List<Inform> selectAllInform(String keyword);

    /**
     * 更新通知
     * @param newTitle
     * @param newAuthor
     * @param newContent
     * @param newTime
     * @param newsId
     */
    public void updateInform(@Param("newTitle") String newTitle,
                           @Param("newAuthor") String newAuthor,
                           @Param("newContent")String newContent,
                           @Param("newTime") Date newTime,
                           @Param("newsId")int newsId);
    /**
     * 插入一个新的通知
     * @param newTitle
     * @param newAuthor
     * @param newContent
     * @param newTime
     */
    public void insertInform(@Param("newTitle") String newTitle,
                           @Param("newAuthor") String newAuthor,
                           @Param("newContent")String newContent,
                           @Param("newTime")Date newTime);
    /**
     * 根据标题删除通知
     * @param title
     */
    public void deleteInform(String title);
}
