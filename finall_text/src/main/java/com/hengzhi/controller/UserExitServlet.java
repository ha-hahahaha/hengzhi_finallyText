/**
 * projectName: finall_text (2)
 * fileName: UserExitServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 17:32
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

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
 * @className: UserExitServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 17:32
 **/
@WebServlet(name = "UserExitServlet")
public class UserExitServlet extends HttpServlet {
    /**
     * 用户退出，设置回显
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("statusName", "0");
        session.setAttribute("statusId", "0");
        session.setAttribute("statusNum","");
        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}