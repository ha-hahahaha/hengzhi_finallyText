/**
 * projectName: finall_text (2)
 * fileName: DeleteAdminServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 16:47
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.NavMapperImpl;
import com.hengzhi.service.Impl.UserMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DeleteAdminServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 16:47
 **/
@WebServlet(name ="DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收name
        String json = "{}";
        String userName= req.getParameter("name");

        //操作数据库删除
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        userMapperImpl.deleteAdmin(userName);

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}