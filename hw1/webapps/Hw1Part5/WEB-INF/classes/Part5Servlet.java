import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Part5Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/** hello **/
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("<head><title> Part 5 </title></head>");
		out.println("<body>");
		out.println("<h1> Part 5 </h1>");

		
		out.println("<h2> getX() methods from the HttpServletRequest class </h2>");



        out.println("getAuthType(): " + request.getAuthType() + "<br>");
        out.println("getContextPath(): " + request.getContextPath() + "<br>");
        out.println("getCookies(): " + Arrays.toString(request.getCookies()) + "<br>");
        out.println("getDateHeader(\"If-Modified-Since\"): " + request.getDateHeader("If-Modified-Since") + "<br>");
        out.println("getHeader(\"user-agent\"): " + request.getHeader("user-agent") + "<br>");
        out.println("getHeaderNames(): " + Collections.list(request.getHeaderNames()) + "<br>");
        out.println("getHeaders(\"name\"): " + Collections.list(request.getHeaders("name")) + "<br>");
        out.println("getIntHeader(\"Sec-WebSocket-Draft\"): " + request.getIntHeader("Sec-WebSocket-Draft") + "<br>");
        out.println("getMethod(): " + request.getMethod() + "<br>");
        out.println("getPathInfo(): " + request.getPathInfo() + "<br>");
        out.println("getPathTranslated(): " + request.getPathTranslated() + "<br>");
        out.println("getQueryString(): " + request.getQueryString() + "<br>");
        out.println("getRemoteUser(): " + request.getRemoteUser() + "<br>");
        out.println("getRequestURI(): " + request.getRequestURI() + "<br>");
        out.println("getRequestURL(): " + request.getRequestURL() + "<br>");
        out.println("getRequestedSessionId(): " + request.getRequestedSessionId() + "<br>");
        out.println("getServletPath(): " + request.getServletPath() + "<br>");
        out.println("getSession(): " + request.getSession() + "<br>");
        out.println("getUserPrincipal(): " + request.getUserPrincipal() + "<br>");


		out.println("<h2>  inherited getX() methods from the super interface ServletRequest </h2>");

		ServletRequest req = request;


        out.println("getAttribute(\"editKey\"): " + req.getAttribute("editKey") + "<br>");
        out.println("getAttributeNames(): " + Collections.list(req.getAttributeNames()) + "<br>");
        out.println("getCharacterEncoding(): " + req.getCharacterEncoding() + "<br>");
        out.println("getContentLength(): " + req.getContentLength() + "<br>");
        out.println("getContentLengthLong(): " + req.getContentLengthLong() + "<br>");
        out.println("getContentType(): " + req.getContentType() + "<br>");
        out.println("getInputStream(): " + req.getInputStream() + "<br>");
        out.println("getLocalAddr(): " + req.getLocalAddr() + "<br>");
        out.println("getLocalName(): " + req.getLocalName() + "<br>");
        out.println("getLocalPort(): " + req.getLocalPort() + "<br>");
        out.println("getParameter(\"editKey\"): " + req.getParameter("editKey") + "<br>");
        out.println("getParameterMap(): " + req.getParameterMap() + "<br>");
        out.println("getParameterNames(): " + Collections.list(req.getParameterNames()) + "<br>");
        out.println("getParameterValues(\"name\"): " + req.getParameterValues("name") + "<br>");
        out.println("getProtocol(): " + req.getProtocol() + "<br>");
        out.println("getReader(): " + req.getReader() + "<br>");
        out.println("getRemoteAddr(): " + req.getRemoteAddr() + "<br>");
        out.println("getRemoteHost(): " + req.getRemoteHost() + "<br>");
        out.println("getRemotePort(): " + req.getRemotePort() + "<br>");
        out.println("getRequestDispatcher(\"path\"): " + req.getRequestDispatcher("path") + "<br>");
        out.println("getScheme(): " + req.getScheme() + "<br>");
        out.println("getServerName(): " + req.getServerName() + "<br>");
		out.println("getServerPort(): " + req.getServerPort() + "<br>");
		out.println("getServletContext(): " + req.getServletContext() + "<br>");




		out.println("</body>");
		out.println("</HTML>");

	}

}
