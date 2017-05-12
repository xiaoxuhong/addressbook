package com.xiao;

import java.sql.*;

/**
 * Created by Administrator on 2017/5/3.
 */
public class del_user_java extends DB_connection implements del_user_imp {
    @Override
    public void del(String id) throws SQLException, ClassNotFoundException {
        //连接数据库
        Connection conn=link();
        // 执行 SQL 查询
        Statement stmt = conn.createStatement();
        String sql="DELETE FROM stu WHERE id="+id;
        stmt.executeUpdate(sql);
    }
}
