/**
 * projectName: finall_text
 * fileName: UpdateNewsServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 0:58
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.NewsMapperImpl;
import com.hengzhi.service.Impl.UserMapperImpl;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

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

import static com.hengzhi.common.MD5Utils.stringToMD5;

/**
 * @version: V1.0
 * @author: huangks
 * @className: UpdateNewsServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 0:58
 **/
@WebServlet(name = "UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
    /**
     * 更新新闻
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
        NewsMapperImpl newsMapperImpl = new NewsMapperImpl();
        newsMapperImpl.updateNews(newTitle,newAuthor,newContent,sqlDate,Integer.valueOf(newsId));

        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}