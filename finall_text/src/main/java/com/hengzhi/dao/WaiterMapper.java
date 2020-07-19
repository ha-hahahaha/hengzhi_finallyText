package com.hengzhi.dao;

import com.hengzhi.entity.User;
import com.hengzhi.entity.Waiter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WaiterMapper {
    /**
     * 插入待审核
     * @param username
     * @param password
     */
    public void insertWaiter(@Param("username") String username,
                             @Param("password") String password);
    /**
     * 搜索所有待审核
     * @return
     */
    public List<Waiter> selectWaiter();
    /**
     * 搜索待审核id
     * @param waiterName
     * @return
     */
    public Waiter selectWaiterName(String waiterName);
    /**
     * 删除一个待审核
     * @param waiterName
     */
    public void  deleteWaiter(String waiterName);

}
