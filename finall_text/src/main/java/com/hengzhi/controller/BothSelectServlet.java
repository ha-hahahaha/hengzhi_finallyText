/**
 * projectName: finall_text
 * fileName: BothSelectServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-15 12:45
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.NewOne;
import com.hengzhi.service.Impl.NewsMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @version: V1.0
 * @author: huangks
 * @className: BothSelectServlet
 * @packageName: com.hengzhi.controller
 * @description: 接受搜索关键词
 *               模糊搜索新闻和通知表，返回一个包括全部符合条件的list
 * @data: 2020-07-15 12:45
 **/
@WebServlet(name = "BothSelectServlet")
public class BothSelectServlet extends HttpServlet {
    /**
     * 新闻通知同时搜索
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置默认值，接受关键字
        String json = "{}";
        String keyword= req.getParameter("info");
        System.out.println("收到"+keyword);

        //操作数据库,模糊搜索新闻和通知表，返回一个包括全部符合搜索条件的list
        NewsMapperImpl newsMapperImpl = new NewsMapperImpl();
        List<NewOne> list= newsMapperImpl.bothSelect(keyword);

        //List写入Json并返回
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}