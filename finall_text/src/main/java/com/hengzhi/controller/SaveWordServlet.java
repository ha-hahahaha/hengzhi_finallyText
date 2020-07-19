/**
 * projectName: finall_text
 * fileName: SaveWordServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-15 0:19
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SaveWordServlet
 * @packageName: com.hengzhi.controller
 * @description: 接受来自主页面的关键字保存到httpsession中
 * @data: 2020-07-15 0:19
 **/
@WebServlet(name = "SaveWordServlet")
public class SaveWordServlet extends HttpServlet {
    /**
     * 临时保存搜索关键词
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受来自主页面的关键字保存到httpsession中
        String json = "{}";
        String keyword= req.getParameter("info");
        HttpSession session=req.getSession();
        session.setAttribute("keyword", keyword);

        //返回一个包含关键字的json
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(keyword);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json); //输出数据---会付给ajax中 responseText属性
        pw.flush();
        pw.close();
    }
}