/**
 * projectName: finall_text
 * fileName: SelectUserServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-15 19:27
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.UserMapper;
import com.hengzhi.entity.Inform;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.InformMapperImpl;
import com.hengzhi.service.Impl.UserMapperImpl;
import org.apache.ibatis.session.SqlSession;
import sun.awt.windows.WPrinterJob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.hengzhi.common.MD5Utils.stringToMD5;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SelectUserServlet
 * @packageName: com.hengzhi.controller
 * @description: 根据用户名和密码提取用户
 * @data: 2020-07-15 19:27
 **/
@WebServlet(name ="SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    /**
     * 登录时验证码判断，验证登录，回显
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得前端用户的用户名和密码
        String json = "{}";
        String username= req.getParameter("userName1");
        String password= stringToMD5(req.getParameter("passWord1"));
        String VCode = req.getParameter("verify");
        HttpSession session = req.getSession();
        String Vcode = (String) session.getAttribute("code");

        if(VCode.equals(Vcode))
        {
            //操作数据库核对用户，并返回这个用户给前端
            UserMapperImpl userMapperImpl = new UserMapperImpl();
            User user= userMapperImpl.checkUser(username,password);
            if(user==null){
                PrintWriter pw  = resp.getWriter();
                pw.println("1");
                pw.flush();
                pw.close();
            }
            else{
                //状态设置成一代表已经登录
                session.setAttribute("statusName", username);
                System.out.println("设置回显id"+user.getUserId());

                session.setAttribute("statusId",String.valueOf(user.getUserId()));
                session.setAttribute("statusNum","1");

                ObjectMapper om  = new ObjectMapper();
                json =  om.writeValueAsString(user);
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter pw  = resp.getWriter();
                pw.println(json);
                pw.flush();
                pw.close();
            }
        }
        else{
            PrintWriter pw  = resp.getWriter();
            pw.println("0");
            pw.flush();
            pw.close();
        }
    }
}