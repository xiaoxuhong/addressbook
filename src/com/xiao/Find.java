package com.xiao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
/**
 * Created by xiaoxuhong on 2017/4/23.
 */
public class Find extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(" <script src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>");
        out.println("<script  type=\"text/javascript\">\n" +
                "        function b(value)"+
                "                var id_tmp=\"id_\"+value;\n" +
                "                var name_tmp=\"name_\"+value;\n" +
                "                var tel_tmp=\"tel_\"+value;\n" +
                "                var id_txt=document.getElementById(id_tmp).value;\n" +
                "                var name_txt=document.getElementById(name_tmp).value;\n" +
                "                var tel_txt=document.getElementById(tel_tmp).value;\n" +
                "                a(id_txt,name_txt,tel_txt);\n" +
                "            });\n" +
                "        })\n" +
                "        function a(id,name,tel) {\n" +
                "            $.post(\"/edit\",\n" +
                "                {\n" +
                "                    id:id,\n" +
                "                    name:name,\n" +
                "                    tel:tel\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "    </script>");
        String id1 = new String(request.getParameter("id").getBytes("ISO8859-1"), "UTF-8");
        String name1 = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
        String tel1 = new String(request.getParameter("tel").getBytes("ISO8859-1"), "UTF-8");

        out.println("<div align=\"center\">");
        out.println("<form action=\"/edit\" method=\"post\">");
        out.println("<table class=\"table-bordered table-hover table-striped\">");
        Find_by_ID ID = new Find_by_ID();
        Find_by_name name = new Find_by_name();
        Find_by_tel tel = new Find_by_tel();

        out.println("<tr><td>ID</td><td>姓名</td><td>电话号码</td><td>操作</td></tr>");

        if (id1.hashCode() ==0 && name1.hashCode() ==0  && tel1.hashCode() ==0 ) {
          Find_all all=new Find_all();
            try {
                List<String> res1=all.all();
                for (String a : res1) {
                    out.println("<tr>" + a + "</tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<String> res1 = ID.Find_by_condition(id1);
                for (String a : res1) {
                    out.println("<tr>" + a + "</tr>");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                List<String> res2 = name.Find_by_condition(id1);
                for (String a : res2)
                    out.println("<tr>" + a + "</tr>");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                List<String> res3 = tel.Find_by_condition(id1);
                for (String a : res3)
                    out.println("<tr>" + a + "</tr>");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            out.println("</div>");
            out.println("</form>");
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
