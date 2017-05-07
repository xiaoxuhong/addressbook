package com.xiao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/5/4.
 */
public class edit_addressbook extends DB_connection {
    public String SET(String id,String name,String tel) throws SQLException, ClassNotFoundException {
        Connection conn=link();
        String SQL="update stu set name='"+name+"',tel='"+tel+"' where id='"+id+"'";
        Statement stmt = conn.createStatement();
        PreparedStatement ps1 = conn.prepareStatement(SQL);
        int count = ps1.executeUpdate(SQL);
        if (count>0)
            return "修改用户信息成功!";
        else
            return "修改用户信息失败!";
    }
}
