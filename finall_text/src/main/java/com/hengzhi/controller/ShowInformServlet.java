/**
 * projectName: finall_text
 * fileName: ShowInformServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-13 22:49
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Inform;
import com.hengzhi.entity.NewOne;
import com.hengzhi.service.Impl.InformMapperImpl;
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
 * @className: ShowInformServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-13 22:49
 **/
@WebServlet(name = "ShowInformServlet")
public class ShowInformServlet extends HttpServlet {
    /**
     * 搜索通知返回
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端搜索关键字
        String json = "{}";
        String keyword= req.getParameter("info");

        //操作数据库返回通知列表
        InformMapperImpl informMapperImpl = new InformMapperImpl();
        List<Inform> list= informMapperImpl.selectAllInform(keyword);

        //jackson把list列表转为json
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}