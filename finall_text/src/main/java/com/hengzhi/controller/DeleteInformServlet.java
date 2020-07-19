/**
 * projectName: finall_text (2)
 * fileName: DeleteInformServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-17 12:56
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.service.Impl.InformMapperImpl;
import com.hengzhi.service.Impl.NewsMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DeleteInformServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-17 12:56
 **/
@WebServlet(name = "DeleteNewsServlet")
public class DeleteInformServlet extends HttpServlet {
    /**
     * 删除通知
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收title
        String json = "{}";
        String title = req.getParameter("title");

        //操作数据库删除
        InformMapperImpl informMapperImpl = new InformMapperImpl();
        informMapperImpl.deleteInform(title);

        PrintWriter pw = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}