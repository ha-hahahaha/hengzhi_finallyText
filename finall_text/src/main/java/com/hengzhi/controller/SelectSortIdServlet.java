/**
 * projectName: finall_text (2)
 * fileName: SelectSortIdServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-19 2:26
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Sort;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.SortMapperImpl;
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
 * @author: huangks
 * @className: SelectSortIdServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-19 2:26
 **/
@WebServlet(name ="SelectSortIdServlet")
public class SelectSortIdServlet extends HttpServlet {
    /**
     * 根据分类名字返回一个分类
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
        Sort sort = sortMapperImpl.selectSortId(sortName);

        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(sort);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}