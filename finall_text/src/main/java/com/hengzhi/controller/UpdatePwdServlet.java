/**
 * projectName: finall_text
 * fileName: UpdatePwdServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-16 16:34
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.hengzhi.common.MD5Utils.stringToMD5;

/**
 * @version: V1.0
 * @author: huangks
 * @className: UpdatePwdServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-16 16:34
 **/
@WebServlet(name = " UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
    /**
     * 核对原有密码修改当前密码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端要更新的用户数据
        String json = "{}";
        String userName = req.getParameter("userName");
        String pwdpast= stringToMD5(req.getParameter("pwdpast"));
        String pwdnow= stringToMD5(req.getParameter("pwdnow"));


        //操作数据库检查用户
        UserMapperImpl userMapperImpla = new UserMapperImpl();
        User user =  userMapperImpla.checkUser(userName,pwdpast);

        //如果用户不存在就返回前端标志0密码错误
        if(user==null){
            PrintWriter pw  = resp.getWriter();
            pw.println("0");
            pw.flush();
            pw.close();
        }
        else{
            //密码正确更新密码,设置回显
            HttpSession session = req.getSession();
            session.setAttribute("statusName", "0");
            session.setAttribute("statusId", "0");
            session.setAttribute("statusNum","");

            UserMapperImpl userMapperImplb = new UserMapperImpl();
            userMapperImplb.updatePwd(userName,pwdnow);
            PrintWriter pw  = resp.getWriter();
            pw.println("111");
            pw.flush();
            pw.close();
        }
    }
}