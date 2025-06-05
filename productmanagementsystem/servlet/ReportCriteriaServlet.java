package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ReportCriteriaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("report_form.jsp");
        dispatcher.forward(request, response);
    }
}