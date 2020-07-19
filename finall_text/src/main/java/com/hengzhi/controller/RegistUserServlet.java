/**
 * projectName: finall_text
 * fileName: RegistUserServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-15 20:15
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.common.MD5Utils;
import com.hengzhi.dao.WaiterMapper;
import com.hengzhi.entity.User;
import com.hengzhi.entity.Waiter;
import com.hengzhi.service.Impl.UserMapperImpl;
import com.hengzhi.service.Impl.WaiterMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import static com.hengzhi.common.MD5Utils.stringToMD5;

/**
 * @version: V1.0
 * @author: hks
 * @className: RegistUserServlet
 * @packageName: com.hengzhi.controller
 * @description: 注册用户
 * @data: 2020-07-15 20:15
 **/
public class RegistUserServlet extends HttpServlet {
    /**
     * 用户注册判断验证码，查重，设置回显
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得用户注册时输入的用户名密码以及是否成为管理员
        String json = "{}";
        String username= req.getParameter("username");
        String password= stringToMD5(req.getParameter("userpwd"));
        String manager=req.getParameter("manager");
        String VCode = req.getParameter("verify");
        HttpSession session = req.getSession();
        String Vcode = (String) session.getAttribute("code");

        if(VCode.equals(Vcode)){
            //操作数据库，先检查用户名是否存在，如果存在返回同名用户在返回前端值“1”
            UserMapperImpl userMapperImpl = new UserMapperImpl();
            User user = userMapperImpl.checkUserName(username);
            if(user!=null)
            {
                PrintWriter pw  = resp.getWriter();
                pw.println("1");
                pw.flush();
                pw.close();
            }
            else{
                //如果普通用户直接注册成功插入用户数据库返回用户
                if(Integer.valueOf(manager)==0){
                    UserMapperImpl userMapperImplInst = new UserMapperImpl();
                    userMapperImplInst.insertUser(username,password,0);
                    UserMapperImpl userMapperImplSel = new UserMapperImpl();
                    User userSuc = userMapperImplSel.checkUserName(username);

                    ObjectMapper om  = new ObjectMapper();
                    json =  om.writeValueAsString(userSuc);
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter pw  = resp.getWriter();
                    pw.println(json);
                    pw.flush();
                    pw.close();
                }
                //如果用户注册管理员放进waitAg则回显管理员且设置状态
                else{
                    WaiterMapper waiterMapper = new WaiterMapperImpl();
                    waiterMapper.insertWaiter(username,password);

                    HttpSession sessiona = req.getSession();
                    sessiona.setAttribute("statusName", username);
                    sessiona.setAttribute("statusNum","2");
                    PrintWriter pw  = resp.getWriter();
                    pw.println("2");
                    pw.flush();
                    pw.close();
                }
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