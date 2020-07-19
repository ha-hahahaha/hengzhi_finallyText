/**
 * projectName: finall_text (2)
 * fileName: UpdateSortServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-19 2:37
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.entity.Sort;
import com.hengzhi.service.Impl.NavMapperImpl;
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
 * @className: UpdateSortServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-19 2:37
 **/
@WebServlet(name = "UpdateSortServlet")
public class UpdateSortServlet extends HttpServlet {
    /**
     * 更新分类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端
        String json = "{}";
        String sortName = req.getParameter("name");
        String sortId= req.getParameter("id");

        //操作数据库更新数据库
        SortMapperImpl sortMapperImpl = new SortMapperImpl();
        sortMapperImpl.updateSort(sortName,Integer.valueOf(sortId));

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}