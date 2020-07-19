/**
 * projectName: finall_text
 * fileName: echoStatusServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-16 17:45
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Echo;

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
 * @className: echoStatusServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-16 17:45
 **/
@WebServlet(name = "EchoStatusServlet")
public class EchoStatusServlet extends HttpServlet {
    /**
     * 给首页回显状态
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //找到回显的session拿出并且放到一个回显对象中
        String json ="{}";
        HttpSession session = req.getSession();
        Echo newecho = new Echo();
        newecho.setEchoName((String)session.getAttribute("statusName"));
        newecho.setEchoStatus((String)session.getAttribute("statusNum"));
        newecho.setEchoId((String)session.getAttribute("statusId"));

        System.out.println("回显ID"+newecho.getEchoId());
        System.out.println("状态是"+newecho.getEchoStatus());

        //把回显对象转换为json给前端让前端判断状态
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(newecho);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}