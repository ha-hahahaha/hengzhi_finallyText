/**
 * projectName: finall_text (2)
 * fileName: AddInformServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 12:47
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.dao.InformMapper;
import com.hengzhi.service.Impl.InformMapperImpl;
import com.hengzhi.service.Impl.NewsMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: V1.0
 * @author: huangks
 * @className: AddInformServlet
 * @packageName: com.hengzhi.controller
 * @description: 增加新闻
 * @data: 2020-07-17 12:47
 **/
@WebServlet(name = "AddInformServlet")
public class AddInformServlet extends HttpServlet {
    /**
     * 增加通告
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端需要插入的新闻信息
        String json = "{}";
        String newTitle = req.getParameter("title");
        String newAuthor= req.getParameter("author");
        String newContent=req.getParameter("text");

        //设置时间转换格式，设置日期格式
        System.out.println(newTitle+newAuthor);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = df.format(new Date());
        Date utilDate = null;
        try {
            utilDate = df.parse(nowTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(time);

        //操作数据库插入通告
        InformMapperImpl informMapperImpl = new InformMapperImpl();
        informMapperImpl.insertInform(newTitle,newAuthor,newContent,sqlDate);

        //向前端输出json
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}