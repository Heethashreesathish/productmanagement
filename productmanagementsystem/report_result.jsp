
<!DOCTYPE html>
<html>
<head><title>Report Result</title></head>
<body>
    <h2>Report Result</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Quantity</th>
        </tr>
        <%
            List<Product> report = (List<Product>) request.getAttribute("report");
            if (report != null) {
                for (Product p : report) {
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
