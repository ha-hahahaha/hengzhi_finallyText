/**
 * projectName: finall_text (2)
 * fileName: SelectNavNameServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 2:30
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Nav;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.NavMapperImpl;
import com.hengzhi.service.Impl.UserMapperImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SelectNavNameServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 2:30
 **/
@WebServlet(name ="SelectNavNameServlet")
public class SelectNavNameServlet extends HttpServlet {
    /**
     * 搜索 返回nav
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受
        String json = "{}";
        String navName= req.getParameter("info");

        //操作数据库返回一个列表
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        List<Nav> list =navMapperImpl.selectNavName(navName);

        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}