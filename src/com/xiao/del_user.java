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
 * Created by Administrator on 2017/5/3.
 */
@WebServlet(name = "del_user")
public class del_user extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1=new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        del_user_java del1=new del_user_java();
        try {
            del1.del(id1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script language=javascript>");
        out.println(" setTimeout('window.location=\"/addressbook.html\"',5000)");
        out.println("</script>");
        out.println("用户已经删除成功,5秒后自动返回！");
    }
}
