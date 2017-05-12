package com.xiao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoxuhong on 2017/4/23.
 */
public class Find_by_name extends DB_connection implements JDBC_Find{
    public List Find_by_condition(String condition)  throws ClassNotFoundException, SQLException {
        Connection conn=link();
        // 执行 SQL 查询
        Statement stmt = conn.createStatement();
        String sql2 = "SELECT * FROM stu WHERE name LIKE '%" + condition + "%'";
         PreparedStatement ps1 = conn.prepareStatement(sql2);
        ResultSet rs1 = ps1.executeQuery();
        List<String> res = new ArrayList<>();
        while (rs1.next()) {
            // 通过字段检索
            int id = rs1.getInt("id");
            String name = rs1.getString("name");
            String tel = rs1.getString("tel");

            // 输出数据
            res.add("<td><input id=\"id_"+id+"\"type=\"text\" readonly=\"true\" value=\"" +id+"\"></td>"+"<td><input type=\"text\" id=\"name_"+id+"\" value=\"" + name+"\"></td>"+"<td><input type=\"text\"id=\"tel_"+id+"\" value=\"" +tel+"\"></td>"+"</td>"+"<td><a href=\"javascript:if(confirm('确实要删除该内容吗?'))location='/del?id="+id+"'\">删除</a> <input type=\"button\" name=\""+id+"\" class=\"btn btn-primary btn-sm\" onclick=\"b("+id+")\" value=\"提交修改\"></td>");
        }
        return res;
    }
}
