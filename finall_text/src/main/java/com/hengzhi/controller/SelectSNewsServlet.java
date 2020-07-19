/**
 * projectName: finall_text (2)
 * fileName: SelectSNewsServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 19:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.dao.NewsMapper;
import com.hengzhi.dao.SortMapper;
import com.hengzhi.entity.Nav;
import com.hengzhi.entity.NewOne;
import com.hengzhi.entity.Sort;
import com.hengzhi.service.Impl.NavMapperImpl;
import com.hengzhi.service.Impl.NewsMapperImpl;
import com.hengzhi.service.Impl.SortMapperImpl;

import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SelectSNewsServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 19:22
 **/
@WebServlet(name ="SelectSNewsServlet")
public class SelectSNewsServlet extends HttpServlet {
    /**
     * 根据分类选择新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受
        String json = "{}";
        String sortName= req.getParameter("sortName");

        SortMapperImpl sortMapperImpl = new SortMapperImpl();
        Sort sort = sortMapperImpl.selectSortId(sortName);
        int sortId=sort.getSortId();

        NewsMapperImpl newsMapperImpl=new NewsMapperImpl();
        List<NewOne>newOnes= newsMapperImpl.selectSortNews(sortId);


        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(newOnes);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();


    }
}