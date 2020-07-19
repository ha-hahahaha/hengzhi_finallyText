/**
 * projectName: finall_text (2)
 * fileName: SavePicServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 12:48
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.UserMapperImpl;

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
 * @className: SavePicServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 12:48
 **/
@WebServlet(name = "SavePicServlet")
public class SavePicServlet extends HttpServlet {
    /**
     * 保存图片路径
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        String picLink = (String) session.getAttribute("uplodePic");
        String userId =(String)session.getAttribute("keyword");
        System.out.println(picLink+"  "+userId);

        UserMapperImpl userMapperImpl = new UserMapperImpl();
        userMapperImpl.savePic(picLink,Integer.valueOf(userId));
        PrintWriter out = resp.getWriter();
        out.println("<script>");
        out.println("alert('上传成功！');");
        out.println("history.back();");
        out.println("</script>");
    }

}