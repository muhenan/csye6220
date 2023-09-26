package part4;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.net.URL;
import java.sql.*;

@WebServlet(name = "Part4Servlet", value = "/Part4Servlet/parking_facilities.csv")
public class Part4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML>");
        out.println("<head><title> Part 4 </title></head>");
        out.println("<body>");
        out.println("<h1> Part 4 </h1>");
        out.println("<p> " + "Now, let see the csv" + " <p>");

        String file_name = request.getParameter("csv");
        if (!file_name.equals("parking_facilities.csv")) {
            if (!file_name.equals("")) out.println("<p> " + "Sorry we don't have the csv file " + file_name + ", the only csv file we have is parking_facilities.csv" + " <p>");
            else out.println("<p> " + "Your input is empty, please input the name of csv file, the only csv file we have is parking_facilities.csv" + " <p>");
        } else {
            out.println("<p> " + "Ok now that's your csv file " + file_name + " <p>");
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                URL url = this.getClass().getResource("/file");
                Connection connection = DriverManager.getConnection("jdbc:relique:csv:" + url.getPath());
                Statement statement = connection.createStatement();
                ResultSet data = statement.executeQuery("select * from parking_facilities");
                ResultSetMetaData meta = data.getMetaData();

                out.println("<table border='1'>");
                out.println("<tr>");
                int colCount = meta.getColumnCount();
                for (int i = 0; i < colCount; i++) {
                    out.println("<th>" + meta.getColumnName(i + 1) + "</th>");
                }
                out.println("</tr>");

                while (data.next())
                {
                    out.println("<tr>");
                    for (int i = 0; i < colCount; i++) {
                        out.println("<td>" + data.getString(i + 1) + "</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
                
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        out.println("</body>");
        out.println("</HTML>");

    }
}
