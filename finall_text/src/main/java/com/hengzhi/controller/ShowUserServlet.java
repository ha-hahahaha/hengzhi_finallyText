package com.hengzhi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengzhi.common.MyBatisUtils;
import com.hengzhi.dao.UserMapper;
import com.hengzhi.entity.NewOne;
import com.hengzhi.entity.User;
import com.hengzhi.service.Impl.NewsMapperImpl;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @version: V1.0
 * @author: huangks
 * @className: ShowUserServlet
 * @packageName: com.hengzhi.controller
 * @description:
 * @data: 2020-07-13 16:34
 **/
@WebServlet(name = "ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
    /**
     * 返回所有用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper dao  =  sqlSession.getMapper(UserMapper.class);
        //调用dao的方法， 执行数据库的操作
        List<User> list = dao.selectAllUsers();
        ObjectMapper om  = new ObjectMapper();
        json =  om.writeValueAsString(list);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}
