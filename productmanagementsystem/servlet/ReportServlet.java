package servlet;
import com.dao.ProductDAO;
import com.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        ProductDAO dao = new ProductDAO();
        List<Product> report = dao.getReport(type);

        request.setAttribute("report", report);
        RequestDispatcher dispatcher = request.getRequestDispatcher("report_result.jsp");
        dispatcher.forward(request, response);
    }
}