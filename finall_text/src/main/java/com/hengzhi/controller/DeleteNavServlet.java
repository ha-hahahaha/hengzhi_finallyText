/**
 * projectName: finall_text (2)
 * fileName: DeleteNavServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 4:32
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.NavMapperImpl;
import com.hengzhi.service.Impl.NewsMapperImpl;
import org.json.HTTPTokener;

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
 * @className: DeleteNavServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 4:32
 **/
@WebServlet(name = "DeleteNavServlet")
public class DeleteNavServlet extends HttpServlet {
    /**
     * 删除导航
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收name
        String json = "{}";
        String navName= req.getParameter("navName");

        //操作数据库删除
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        navMapperImpl.deleteNav(navName);

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}