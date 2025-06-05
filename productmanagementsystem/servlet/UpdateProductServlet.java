package servlet;
import com.dao.ProductDAO;
import com.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product(id, name, category, price, quantity);
        ProductDAO dao = new ProductDAO();
        dao.updateProduct(product);

        response.sendRedirect("productdisplay.jsp");
    }
}