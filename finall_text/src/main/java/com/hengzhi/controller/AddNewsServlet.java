/**
 * projectName: finall_text
 * fileName: AddNewsServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 3:03
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.Sort;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.NewsMapperImpl;
import com.hengzhi.service.Impl.SortMapperImpl;
import com.hengzhi.service.Impl.UserMapperImpl;
import org.json.HTTPTokener;

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
 * @className: AddNewsServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 3:03
 **/
@WebServlet(name = "AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
    /**
     * 增加新闻
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
        String sortId=req.getParameter("sort");

        //
        //SortMapperImpl sortMapperImpl = new SortMapperImpl();
        //Sort sort =  sortMapperImpl.selectSortId(sortName);
        //int sortId = sort.getSortId();

        //设置时间，转换格式
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

        //操作数据库
        NewsMapperImpl newsMapperImpl = new NewsMapperImpl();
        newsMapperImpl.insertNews(newTitle,newAuthor,newContent,sqlDate,Integer.valueOf(sortId));

        //向前端输出
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}