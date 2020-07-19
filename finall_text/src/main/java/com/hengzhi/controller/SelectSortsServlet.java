/**
 * projectName: finall_text (2)
 * fileName: SelectSortsServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 19:04
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Nav;
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
import java.util.List;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SelectSortsServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 19:04
 **/
@WebServlet(name ="SelectSortsServlet")
public class SelectSortsServlet extends HttpServlet {
    /**
     * 返回所有分类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受
        String json = "{}";

        //操作数据库返回一个列表
        SortMapperImpl sortMapperImpl = new SortMapperImpl();
        List<Sort>sorts=  sortMapperImpl.selectSorts();

        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(sorts);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}