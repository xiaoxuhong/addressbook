package com.xiao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by xiaoxuhong on 2017/4/23.
 */
public class Find_by_ID  extends DB_connection implements JDBC_Find{
    public List Find_by_condition(String condition)  throws ClassNotFoundException, SQLException  {
        Connection conn=link();
        // 执行 SQL 查询
        Statement stmt = conn.createStatement();

        String sql1 = "SELECT * FROM stu WHERE id =" + condition;

        PreparedStatement ps1 = conn.prepareStatement(sql1);
         ResultSet rs1 = ps1.executeQuery();
        List<String> res = new ArrayList<>();
        while (rs1.next()) {
            // 通过字段检索
            int id = rs1.getInt("id");
            String name = rs1.getString("name");
            String tel = rs1.getString("tel");

            // 输出数据
            res.add("<td>" + id+"</td>"+"<td>" + name+"</td>"+"<td>" + tel+"</td>"+"<td><a href=\"/del?id="+id+"\">删除</a></td>");
        }
        return res;
    }
}
