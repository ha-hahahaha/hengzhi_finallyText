/**
 * projectName: finall_text (2)
 * fileName: UpdateInformServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 12:34
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.InformMapper;
import com.hengzhi.service.Impl.InformMapperImpl;
import com.hengzhi.service.Impl.NewsMapperImpl;
import org.apache.ibatis.session.SqlSession;

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
 * @className: UpdateInformServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 12:34
 **/
@WebServlet(name = "UpdateInformServlet")
public class UpdateInformServlet extends HttpServlet {
    /**
     * 更新通告
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到前端更新的新闻信息
        String json = "{}";
        String newTitle = req.getParameter("title");
        String newAuthor= req.getParameter("author");
        String newContent=req.getParameter("text");
        String newsId = req.getParameter("newId");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowTime = df.format(new Date());
        Date utilDate = null;
        try {
            utilDate = df.parse(nowTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(time);

        //操作数据库更新数据库
        InformMapperImpl informMapperImpl = new InformMapperImpl();
        informMapperImpl.updateInform(newTitle,newAuthor,newContent,sqlDate,Integer.valueOf(newsId));

        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}