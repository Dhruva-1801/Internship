import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "1234".equals(pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user);

            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "Invalid username or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}