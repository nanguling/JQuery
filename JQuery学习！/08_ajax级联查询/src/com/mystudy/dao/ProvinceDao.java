package com.mystudy.dao;

import com.mystudy.entity.Province;
import com.mystudy.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao {
    //查询所有省份信息
    public static List select() {
        String sql = "select id,name from province";
        //创建数据库连接&sql命令对象
        PreparedStatement ps = JdbcUtil.createPs(sql);
        List list = new ArrayList();
        ResultSet rs = null;
        try {
            //执行sql
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                Province p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
        }
        return list;
    }
}
