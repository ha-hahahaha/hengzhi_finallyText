/**
 * projectName: finall_text (2)
 * fileName: AddAdminServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 17:00
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.hengzhi.entity.Waiter;
import com.hengzhi.service.Impl.UserMapperImpl;
import com.hengzhi.service.Impl.WaiterMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version: V1.0
 * @author: huangks
 * @className: AddAdminServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 17:00
 **/
@WebServlet(name = "AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    /**
     * 审核管理员通过，加入用户列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        String userName = req.getParameter("name");
        //从wait表中拿到用户
        WaiterMapperImpl waiterMapperImpl = new WaiterMapperImpl();
        Waiter waiter = waiterMapperImpl.selectWaiterName(userName);

        //保存密码
        String userPwd = waiter.getWaitUserPwd();
        //删除审核表中的用户
        waiterMapperImpl.deleteWaiter(userName);

        UserMapperImpl userMapperImpl = new UserMapperImpl();
        userMapperImpl.insertUser(userName,userPwd,1);

        //向前端输出json
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}