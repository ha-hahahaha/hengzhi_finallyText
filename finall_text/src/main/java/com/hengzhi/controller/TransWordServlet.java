/**
 * projectName: finall_text
 * fileName: TransWordServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-15 12:34
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
 * @className: TransWordServlet
 * @packageName: com.hengzhi.controller
 * @description: 给出数据
 * @data: 2020-07-15 12:34
 **/
@WebServlet(name = "TransWordServlet")
public class TransWordServlet extends HttpServlet {
    /**
     * 传输临时保存的关键字
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //等待前端请求提取保存的keyword
        String json = "{}";
        HttpSession session = req.getSession();
        String keywordOut =(String)session.getAttribute("keyword");
        System.out.println("得到共享数据 "+keywordOut);

        //传给前端
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(keywordOut);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json); //输出数据---会付给ajax中 responseText属性
        pw.flush();
        pw.close();
    }
}