<%@ page import="java.util.List" %>
<%@ page import="com.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Product List</title></head>
<body>
    <h2>All Products</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Quantity</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null) {
                for (Product p : products) {
        %>
        <tr>
            <td><%= p.getProductId() %></td>
            <td><%= p.getProductName() %></td>
            <td><%= p.getCategory() %></td>
            <td><%= p.getPrice() %></td>
            <td><%= p.getQuantity() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <a href="index.jsp">Home</a>
</body>
</html>
