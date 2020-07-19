/**
 * projectName: finall_text
 * fileName: UpdataUserServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-16 3:15
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.dao.WaiterMapper;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.UserMapperImpl;
import com.hengzhi.service.Impl.WaiterMapperImpl;

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
 * @className: UpdataUserServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-16 3:15
 **/
@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    /**
     * 查重，更新用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端要更新的用户数据
        String json = "{}";
        String userId= req.getParameter("userId");
        String userName= req.getParameter("userName");
        String age= req.getParameter("age");
        String info= req.getParameter("info");
        String pastname= req.getParameter("pastname");
        boolean ifequal;
        //操作数据库更新用户
        UserMapperImpl userMapperImpla = new UserMapperImpl();
        User user = userMapperImpla.checkUserName(userName);
        System.out.println(user);
        if(user==null){
            ifequal=false;
        }
        else {
            ifequal=user.getUserName().equals(pastname);
        }

        if(ifequal){
            userMapperImpla.updateUser(Integer.valueOf(userId),userName,Integer.valueOf(age),info);
            //操作数据库把这个用户返回给前端
            UserMapperImpl userMapperImplb = new UserMapperImpl();
            User usera = userMapperImplb.checkUserId(Integer.valueOf(userId));
            ObjectMapper om  = new ObjectMapper();
            json =  om.writeValueAsString(usera);
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter pw  = resp.getWriter();
            pw.println(json);
            pw.flush();
            pw.close();
        }
        else{
            if(user==null){
                System.out.println("保存新数据");
                UserMapperImpl userMapperImplb = new UserMapperImpl();
                userMapperImplb.updateUser(Integer.valueOf(userId),userName,Integer.valueOf(age),info);
                //操作数据库把这个用户返回给前端
                UserMapperImpl userMapperImplc = new UserMapperImpl();
                User userc = userMapperImplc.checkUserId(Integer.valueOf(userId));
                ObjectMapper om  = new ObjectMapper();
                json =  om.writeValueAsString(userc);
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter pw  = resp.getWriter();
                pw.println(json);
                pw.flush();
                pw.close();
            }
            else{
                PrintWriter pw  = resp.getWriter();
                pw.println("1");
                pw.flush();
                pw.close();
            }
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}