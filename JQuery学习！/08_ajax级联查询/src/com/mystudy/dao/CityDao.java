package com.mystudy.dao;

import com.mystudy.entity.City;
import com.mystudy.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    //根据pid查询所关联的所有城市信息
    public static List select(int pid) {
        String sql = "select id,name from city where pid = ?";
        //创建数据库连接&sql命令对象
        PreparedStatement ps = JdbcUtil.createPs(sql);
        List list = new ArrayList();
        ResultSet rs = null;
        try {
            //替换占位符
            ps.setInt(1,pid);
            //执行sql
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                City c = new City();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
        }
        return list;
    }
}
