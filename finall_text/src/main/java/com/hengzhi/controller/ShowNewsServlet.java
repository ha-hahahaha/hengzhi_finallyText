/**
 * projectName: finall_text
 * fileName: ShowNewsServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-13 16:34
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @className: ShowNewsServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-13 16:34
 **/
@WebServlet(name = "ShowNewsServlet")
public class ShowNewsServlet extends HttpServlet {
    /**
     * 搜索新闻返回
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端新闻关键字
        String json = "{}";
        String keyword= req.getParameter("info");
        //操作数据库返回符合条件的新闻
        NewsMapperImpl newsMapperImpl = new NewsMapperImpl();
        List<NewOne> list= newsMapperImpl.selectAllNews(keyword);

        //需要使用jackson 把  list列表转为  json
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}