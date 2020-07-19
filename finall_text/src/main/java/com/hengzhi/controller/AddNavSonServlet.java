/**
 * projectName: finall_text (2)
 * fileName: AddNavSonServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 4:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.entity.Nav;
import com.hengzhi.service.Impl.NavMapperImpl;

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
 * @className: AddNavSonServlet
 * @packageName: com.hengzhi.controller
 * @description: 增加导航子元素
 * @data: 2020-07-18 4:22
 **/
@WebServlet(name = "AddNavSonServlet")
public class AddNavSonServlet extends HttpServlet {
    /**
     * 增加导航子类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端要添加的导航子元素
        String json = "{}";
        String navName = req.getParameter("navName");
        String toLink= req.getParameter("toLink");
        String fatherName=req.getParameter("fatherName");
        
        NavMapperImpl navMapperImpl = new NavMapperImpl();
        Nav nav = navMapperImpl.selectFatherName(fatherName);
        int faherId =nav.getNameId();

        //操作数据库插入子类，有一个父类的id
        navMapperImpl = new NavMapperImpl();
        navMapperImpl.addNSon(navName,toLink,faherId);

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}