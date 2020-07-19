/**
 * projectName: finall_text (2)
 * fileName: UpdateNSonServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 3:38
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.NavMapperImpl;

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
 * @className: UpdateNSonServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 3:38
 **/
@WebServlet(name = "UpdateNSonServlet")
public class UpdateNSonServlet extends HttpServlet {
    /**
     * 更新子类导航
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端
        String json = "{}";
        String navName = req.getParameter("navName");
        String toLink= req.getParameter("toLink");
        String navId=req.getParameter("navId");
        String fatherId=req.getParameter("fatherId");

        //操作数据库更新数据库
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        navMapperImpl.updateNSon(navName,toLink,Integer.valueOf(navId),Integer.valueOf(fatherId));

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}