/**
 * projectName: finall_text
 * fileName: DeletNewsServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 3:26
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
 * @author: fendo
 * @className: DeletNewsServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 3:26
 **/
@WebServlet(name = "DeleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
    /**
     * 删除新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端新闻title
        String json = "{}";
        String title= req.getParameter("title");

        //操作数据库删除新闻
        NewsMapperImpl newsMapperImpl = new NewsMapperImpl();
        newsMapperImpl.deleteNews(title);

        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}