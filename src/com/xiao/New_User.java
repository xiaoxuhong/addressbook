package com.xiao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by xiaoxuhong on 2017/4/27.
 */
@WebServlet(name = "New_User")
public class New_User extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id1=new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        String name1=new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String tel1=new String(request.getParameter("tel").getBytes("ISO8859-1"),"UTF-8");
        new_addressbook temp=new  new_addressbook();
        try {
            out.println(temp.SET(id1,name1,tel1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
