/**
 * projectName: finall_text
 * fileName: SelectUserIdServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-15 21:06
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.UserMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SelectUserIdServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-15 21:06
 **/
@WebServlet(name ="SelectUserIdServlet")
public class SelectUserIdServlet extends HttpServlet {
    /**
     * 根据Id搜索用户返回
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受来自前端的用户Id
        String json = "{}";
        String userId= req.getParameter("userId");

        //操作数据库返回这个用户，写入json给前端
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        User user= userMapperImpl.checkUserId(Integer.valueOf(userId));

        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(user);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}