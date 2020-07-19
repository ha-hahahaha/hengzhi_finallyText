/**
 * projectName: finall_text (2)
 * fileName: SelectWaiterServlet.java
 * packageName: com.hengzhi.controller
 * date: 2020-07-18 16:39
 * copyright(c) 2017-2020 xxx公司
 */
package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.entity.User;
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
import java.util.List;

/**
 * @version: V1.0
 * @author: huangks
 * @className: SelectWaiterServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-18 16:39
 **/
@WebServlet(name ="SelectWaiterServlet")
public class SelectWaiterServlet extends HttpServlet {
    /**
     * 返回所有的待审核
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受
        String json = "{}";

        //操作数据库返回一个列表
        WaiterMapperImpl waiterMapperImpl = new WaiterMapperImpl();
        List<Waiter> waiters = waiterMapperImpl.selectWaiter();

        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(waiters);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}