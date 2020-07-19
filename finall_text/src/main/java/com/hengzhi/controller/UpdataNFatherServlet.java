/**
 * projectName: finall_text (2)
 * fileName: UpdataNFatherServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 3:02
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.NavMapperImpl;
import com.hengzhi.service.Impl.NewsMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: V1.0
 * @author: huangks
 * @className: UpdataNFatherServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 3:02
 **/
@WebServlet(name = "UpdataNFatherServlet")
public class UpdataNFatherServlet extends HttpServlet {
    /**
     * 更新父类导航
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


        //操作数据库更新数据库
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        navMapperImpl.updateNFather(navName,toLink,Integer.valueOf(navId));

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}