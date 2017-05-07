package com.xiao;

import java.sql.*;

/**
 * Created by xiaoxuhong on 2017/4/27.
 */
public class new_addressbook extends DB_connection{
        public String SET(String id,String name,String tel) throws SQLException, ClassNotFoundException {
        Connection conn=link();
        String SQL="insert into stu  values('"+id+"','"+name+"','"+tel+"');";
            Statement stmt = conn.createStatement();
            PreparedStatement ps1 = conn.prepareStatement(SQL);
            int count = ps1.executeUpdate(SQL);
         if (count>0)
             return "创建新用户成功!";
         else
             return "创建新用户失败!";
    }
}
