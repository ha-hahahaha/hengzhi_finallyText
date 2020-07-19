/**
 * projectName: finall_text (2)
 * fileName: DeleteWaiterServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 17:15
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.hengzhi.entity.Waiter;
import com.hengzhi.service.Impl.UserMapperImpl;
import com.hengzhi.service.Impl.WaiterMapperImpl;

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
 * @className: DeleteWaiterServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 17:15
 **/
@WebServlet(name = "DeleteWaiterServlet")
public class DeleteWaiterServlet extends HttpServlet {
    /**
     * 删除一个待审核
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收name
        String json = "{}";
        String waitName= req.getParameter("name");

        //操作数据库删除
        WaiterMapperImpl waiterMapperImpl = new WaiterMapperImpl();
        waiterMapperImpl.deleteWaiter(waitName);

        PrintWriter pw  = resp.getWriter();
        pw.println("1");
        pw.flush();
        pw.close();
    }
}