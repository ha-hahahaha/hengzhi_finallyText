/**
 * projectName: finall_text (2)
 * fileName: ShowNavSonServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 21:18
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Nav;
import com.hengzhi.service.Impl.NavMapperImpl;
import com.sun.scenario.effect.impl.sw.java.JSWBrightpassPeer;

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
 * @className: ShowNavSonServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 21:18
 **/
@WebServlet(name = "ShowNavSonServlet")
public class ShowNavSonServlet extends HttpServlet {
    /**
     * 根据父类导航返回下层子类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        String navId=req.getParameter("id");

        //操作数据库返回符合条件的
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        List<Nav> list = navMapperImpl.selectAllSon(Integer.valueOf(navId));

        //需要使用jackson 把  list列表转为 json
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}