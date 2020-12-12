package com.mystudy.controller;

import com.mystudy.dao.CityDao;
import com.mystudy.entity.City;
import com.mystudy.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CitySelectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象获取请求参数信息
        String pid = request.getParameter("id");
        if (pid != null && pid != "") {
            //通过省份id调用相关dao查询其所关联的所有城市信息
            List<City> list = CityDao.select(Integer.valueOf(pid));;
            //将得到的list集合转换为json数组
            String json = JsonUtil.DeSerialize(list);
            //将json数组写入响应体返回给前端
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }
    }
}
