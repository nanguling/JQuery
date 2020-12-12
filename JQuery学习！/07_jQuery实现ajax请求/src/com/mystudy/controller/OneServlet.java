package com.mystudy.controller;

import com.mystudy.dao.ProvinceDao;
import com.mystudy.entity.Province;
import com.mystudy.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String res = "{}";//默认值
        //1.通过请求对象读取请求参数信息
        String id = request.getParameter("id");
        //2.调用Dao类通过省份表的id查询省份信息
        Province p = null;
        if (id != null && id != "") {
            p = ProvinceDao.select(Integer.valueOf(id));
            //3.获取json字符串
            res = JsonUtil.serialize(p);
        }
        //4.将获取的json字符串传给ajax异步对象，响应结果数据
        //指定服务器端（servlet）返回给浏览器的是json格式的数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(res);
        out.flush();
        out.close();
    }
}
