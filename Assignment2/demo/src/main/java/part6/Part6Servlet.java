package part6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "Part6Servlet", value = "/Part6Servlet")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"admin"}))
public class Part6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("./part6.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE HTML>");
        out.println("<HTML>");
        out.println("<head><title> Part 6 </title></head>");
        out.println("<body>");
        out.println("<h1> Part 6 </h1>");

        Map<String, String[]> m = request.getParameterMap();

        Enumeration<String> names = request.getParameterNames();

        while (names.hasMoreElements()) {

            String name = names.nextElement();

            out.println("<h3> " + name + " </h3>");

            String[] values = m.get(name);

            for (String value:values) {
                out.println("<p> " + value + " <p>");
            }
        }

        out.println("</body>");
        out.println("</HTML>");

    }
}
