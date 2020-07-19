/**
 * projectName: finall_text (2)
 * fileName: ShowNavFatherServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 19:27
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Nav;
import com.hengzhi.entity.NewOne;
import com.hengzhi.service.Impl.NavMapperImpl;
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
 * @className: ShowNavFatherServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 19:27
 **/
@WebServlet(name = "ShowNavFatherServlet")
public class ShowNavFatherServlet extends HttpServlet {
    /**
     * 搜索所有的父类导航返回
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";

        //操作数据库返回符合条件的
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        List<Nav>list = navMapperImpl.selectAllFather();

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