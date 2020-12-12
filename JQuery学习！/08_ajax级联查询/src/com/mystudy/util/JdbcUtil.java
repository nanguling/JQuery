package com.mystudy.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 将JDBC规范下相关对象【创建】与【关闭】封装到方法
 */
public class JdbcUtil {
    //创建数据库连接池
    public static final DataSource dataSource = new MysqlDataSource();
    //多线程之后会优化为双重校验锁的单例模式来使用DataSource
    static {
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/db2020?user=root&password=19991230&useUnicode=true&useSSL=false&characterEncoding=UTF-8");
    }
    private static Connection con = null;
    private static PreparedStatement ps = null;


    //创建数据库连接
    public static Connection createCon() {
        //创建数据库连接
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    //创建sql命令对象
    public static PreparedStatement createPs(String sql) {
        try {
            ps = createCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    //关闭资源
    public static void close() {

        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //关闭ResultSet资源
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }
}
