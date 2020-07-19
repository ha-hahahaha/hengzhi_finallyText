/**
 * projectName: finall_text
 * fileName: VerifycodeServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-16 19:51
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.common.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @version: V1.0
 * @author: huangks
 * @className: VerifycodeServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-16 19:51
 **/
@WebServlet(name = "VerifycodeServlet")
public class VerifycodeServlet extends HttpServlet {
    /**
     * 验证码
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");

        String namevalue=req.getParameter("Vname");
        //创建自定义的验证码类的对象
        VerifyCode vc=new VerifyCode();
        //设置图片缓存器
        BufferedImage image=vc.getImage();

        req.getSession().setAttribute("code", vc.getText());
        System.out.println("验证码："+vc.getText());
        VerifyCode.output(image,res.getOutputStream());
    }
}