package servlet;
import com.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        ProductDAO dao = new ProductDAO();
        dao.deleteProduct(id);

        response.sendRedirect("productdisplay.jsp");
    }
}