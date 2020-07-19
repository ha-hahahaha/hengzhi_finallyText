package com.hengzhi.dao;

import com.hengzhi.entity.NewOne;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface NewsMapper {
    /**
     * 查找所有新闻
     * @return
     */
    public List<NewOne> selectAllNews(String keyword);
    /**
     * 联合搜索
     * @param keyword
     * @return
     */
    public List<NewOne>  bothSelect(String keyword);
    /**
     * 更新新闻
     * @param newTitle
     * @param newAuthor
     * @param newContent
     * @param newTime
     * @param newsId
     */
    public void updateNews(@Param("newTitle") String newTitle,
                           @Param("newAuthor") String newAuthor,
                           @Param("newContent")String newContent,
                           @Param("newTime")Date newTime,
                           @Param("newsId")int newsId);
    /**
     * 插入新闻
     * @param newTitle
     * @param newAuthor
     * @param newContent
     * @param newTime
     */
    public void insertNews(@Param("newTitle") String newTitle,
                           @Param("newAuthor") String newAuthor,
                           @Param("newContent")String newContent,
                           @Param("newTime")Date newTime,
                           @Param("sortId") int sortId);
    /**
     * 删除新闻
     * @param title
     */
    public void deleteNews(String title);
    /**
     * 搜索分类新闻
     * @param sortId
     * @return
     */
    public List<NewOne> selectSortNews(int sortId);

}
