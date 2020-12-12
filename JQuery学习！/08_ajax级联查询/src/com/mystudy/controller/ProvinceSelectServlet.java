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
import java.util.List;

public class ProvinceSelectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用相关的dao类完成省份信息的查询功能
        List<Province> list = ProvinceDao.select();
        //调用jackson将list中实体类转为json数组返回给前端
        String json = JsonUtil.DeSerialize(list);
        //将json数组写入到响应体中返回给前端
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
