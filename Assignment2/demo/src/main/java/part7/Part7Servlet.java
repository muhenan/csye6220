package part7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Part7Servlet", value = "/Part7Servlet")
public class Part7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isUserAuthorized(request, response)) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"Shopping Cart\"");
            response.sendError(401, "Unauthorized");
        } else {
            // now you are authorized, you can play with the servlet
            String action = request.getParameter("action");
            if (action != null && action.equals("shopping-cart")) {
                handleShoppingCartAction(request, response);
            } else {
                displayShoppingCart(request, response);
            }
        }
    }


    private void handleShoppingCartAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        String[] items = request.getParameterValues("item");
        if (items != null) {
            for (String item : items) {
                if (!cart.contains(item))
                    cart.add(item);
            }
        }
        String removeIndex = request.getParameter("removeIndex");
        if (removeIndex != null && !removeIndex.isEmpty()) {
            int index = Integer.parseInt(removeIndex);
            cart.remove(index);
        }
        displayShoppingCart(request, response);
    }
    private void displayShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Part 7 Shopping Cart</h1>");
        out.println("<a href=\"/demo_war_exploded\">Go back to the main page</a>");
        out.println("<h2>Shopping Mall</h2>");

        out.println("<form action='Part7Servlet' method='get'>");
        out.println("<input type='checkbox' name='item' value='\"Head First Java\" by Kathy Sierra and Bert Bates - $30.99'>\"Head First Java\" by Kathy Sierra and Bert Bates - $30.99<br/>");
        out.println("<input type='checkbox' name='item' value='\"Java: A Beginner's Guide\" by Herbert Schildt - $44.99'>\"Java: A Beginner's Guide\" by Herbert Schildt - $44.99<br/>");
        out.println("<input type='checkbox' name='item' value='\"Effective Java\" by Joshua Bloch - $47.99'>\"Effective Java\" by Joshua Bloch - $47.99<br/>");
        out.println("<input type='checkbox' name='item' value='\"Java in a Nutshell\" by David Flanagan - $34.99'>\"Java in a Nutshell\" by David Flanagan - $34.99<br/>");
        out.println("<input type='checkbox' name='item' value='\"Java Performance\" by Charlie Hunt - $49.99'>\"Java Performance\" by Charlie Hunt - $49.99<br/>");
        out.println("<input type='checkbox' name='item' value='\"Java for Dummies\" by Barry Burd - $24.99'>\"Java for Dummies\" by Barry Burd - $24.99<br/>");
        out.println("<input type='checkbox' name='item' value='\"Java Web Services: Up and Running\" by Martin Kalin - $39.99'>\"Java Web Services: Up and Running\" by Martin Kalin - $39.99<br/>");
        out.println("<br/><input type='submit' value='Add to Cart'>");
        out.println("<br/><input type='hidden' name='action' value='shopping-cart'>");
        out.println("</form>");

        out.println("<h2>Your Shopping Cart</h2>");
        if (cart.size() == 0) {
            out.println("<p>Now your Shopping Cart is empty</p>");
        } else {
            out.println("<p>Now that's your Shopping Cart</p>");
            out.println("<table border='1'>");
            for (int i = 0; i < cart.size(); i++) {
                out.println("<tr>");
                out.println("<td>" + cart.get(i) + "</td><td> <a href='?action=shopping-cart&removeIndex=" + i + "'>remove</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }

        out.println("</body></html>");
    }

    private boolean isUserAuthorized(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getUserPrincipal() != null) {
            // user has already been authenticated
            return true;
        }
        String auth = request.getHeader("Authorization");
        if (auth == null) {
            return false;
        } else {
            String[] credentials = new String(Base64.getDecoder().decode(auth.substring(6).getBytes()), "UTF-8").split(":");
            String username = credentials[0];
            String password = credentials[1];
            request.login(username, password);
            if (request.isUserInRole("admin")) {
                return true;
            } else {
                return false;
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
