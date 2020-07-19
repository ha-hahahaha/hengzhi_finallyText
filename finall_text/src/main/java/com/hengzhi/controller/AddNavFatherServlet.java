/**
 * projectName: finall_text (2)
 * fileName: AddNavFatherServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 4:05
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.InformMapperImpl;
import com.hengzhi.service.Impl.NavMapperImpl;

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
 * @author: haungks
 * @className: AddNavFatherServlet
 * @packageName: com.hengzhi.controller
 * @description: 增加父类导航
 * @data: 2020-07-18 4:05
 **/
@WebServlet(name = "AddNavFatherServlet")
public class AddNavFatherServlet extends HttpServlet {
    /**
     * 增加导航父类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端要添加的父类元素
        String json = "{}";
        String navName = req.getParameter("navName");
        String toLink= req.getParameter("toLink");

        //操作数据库插入父类元素
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        navMapperImpl.addNFather(navName,toLink);

        //向前端输出
        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}