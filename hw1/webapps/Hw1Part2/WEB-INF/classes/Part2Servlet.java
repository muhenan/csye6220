import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Part2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/** hello **/
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("<head><title> Part 2 </title></head>");
		out.println("<body>");
		out.println("<h1> Part 2 </h1>");


		/** getHeaderNames **/
		Enumeration<String> enumerationGetHeaderNames = request.getHeaderNames();

		out.println("<h2> Enumeration getHeaderNames()  </h2>");

		while (enumerationGetHeaderNames.hasMoreElements()) {
			out.println("<p> " + (String)enumerationGetHeaderNames.nextElement() + " </p>");
    	}

    	

    	/** getHeaders **/
		out.println("<h2> Enumeration getHeaders(String name)  </h2>");

		Enumeration<String> enumerationGetHeaderNames2 = request.getHeaderNames();

		while (enumerationGetHeaderNames2.hasMoreElements()) {
			String name = (String)enumerationGetHeaderNames2.nextElement();
			out.println("<h3> " + name + " </h3>");	

			Enumeration<String> enumerationGetHeaders = request.getHeaders(name);

			while (enumerationGetHeaders.hasMoreElements()) {
				out.println("<p> " + (String)enumerationGetHeaders.nextElement() + " </p>");
    		}

    	}

		out.println("</body>");
		out.println("</HTML>");

	}

}
