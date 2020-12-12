package com.mystudy.dao;

import com.mystudy.entity.Province;
import com.mystudy.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceDao {
    //查询
    public static Province select(int id) {
        String sql = "select id,name,jiancheng,shenghui from province where id = ?";
        //创建数据库连接&sql命令对象
        PreparedStatement ps = JdbcUtil.createPs(sql);
        ResultSet rs = null;
        Province p = new Province();
        try {
            //替换占位符
            ps.setInt(1,id);
            //执行sql
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
        }
        return p;
    }
}
