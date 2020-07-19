package com.hengzhi.dao;

import com.hengzhi.entity.Sort;
import com.hengzhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortMapper {
    /**
     * 搜索所有分类
     * @return
     */
    public List<Sort> selectSorts();
    /**
     * 搜索分类
     * @param sortName
     * @return
     */
    public Sort selectSortId(String sortName);
    /**
     * 更新分类
     * @param sortName
     * @param sortId
     */
    public void updateSort(@Param("sortName")String sortName,
                           @Param("sortId")int sortId);
    /**
     * 删除分类
     * @param sortName
     */
    public void deleteSort(String sortName);
    /**
     * 增加分类
     * @param sortName
     */
    public void addSort(String sortName);
}
