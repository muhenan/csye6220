import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Part4Servlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/** hello **/
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("<head><title> Part 4 </title></head>");
		out.println("<body>");
		out.println("<h1> Part 4 </h1>");

		Map<String, String[]> m = request.getParameterMap();

		Enumeration<String> names = request.getParameterNames();

		while (names.hasMoreElements()) {

			String name = (String)names.nextElement();

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
