/**
 * projectName: finall_text (2)
 * fileName: AddSortServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-19 2:56
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.SortMapperImpl;

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
 * @className: AddSortServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-19 2:56
 **/

@WebServlet(name ="AddSortServlet")
public class AddSortServlet extends HttpServlet {
    /**
     * 增加新闻分类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        String sortName= req.getParameter("name");

        SortMapperImpl sortMapperImpl = new SortMapperImpl();
        sortMapperImpl.addSort(sortName);

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}