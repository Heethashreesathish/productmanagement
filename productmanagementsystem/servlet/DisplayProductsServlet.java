package servlet;
package com.servlet;

import com.dao.ProductDAO;
import com.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DisplayProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Product> productList = dao.getAllProducts();

        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productdisplay.jsp");
        dispatcher.forward(request, response);
    }
}