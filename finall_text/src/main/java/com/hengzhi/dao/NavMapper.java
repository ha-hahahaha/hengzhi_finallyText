package com.hengzhi.dao;

import com.hengzhi.entity.Inform;
import com.hengzhi.entity.Nav;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NavMapper {
    /**
     * 所有父类列表
     * @return
     */
    public List<Nav> selectAllFather();
    /**根据父类id返回所有子类
     * @param navId
     * @return
     */
    public List<Nav> selectAllSon(int navId);
    /**
     * 根据导航名选出导航
     * @param navName
     * @return
     */
    public List<Nav> selectNavName(String navName);
    /**
     * 更新父类
     * @param navName
     * @param toLink
     * @param navId
     */
    public Nav selectFatherName(String fatherName);


    public  void  updateNFather(@Param("navName") String navName,
                                @Param("toLink") String toLink,
                                @Param("navId") int navId);
    /**
     * 更新子类
     * @param navName
     * @param toLink
     * @param navId
     * @param fatherId
     */
    public  void  updateNSon(  @Param("navName") String navName,
                                @Param("toLink") String toLink,
                                @Param("navId") int navId,
                                @Param("fatherId") int fatherId);
    /**
     * 增加父类
     * @param navName
     * @param toLink
     */
    public  void  addNFather(  @Param("navName") String navName,
                               @Param("toLink") String toLink);
    /**
     * 增加子类
     * @param navName
     * @param toLink
     * @param fatherId
     */
    public  void  addNSon(  @Param("navName") String navName,
                            @Param("toLink") String toLink,
                            @Param("fatherId") int fatherId);
    /**
     * 删除导航
     * @param navName
     */
    public  void  deleteNav(String navName);
}
