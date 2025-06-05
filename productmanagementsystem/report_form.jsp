<!DOCTYPE html>
<html>
<head><title>Select Report Type</title></head>
<body>
    <h2>Select Report Criteria</h2>
    <form action="generateReport" method="post">
        <select name="type">
            <option value="price">Price > 1000</option>
            <option value="category">Category = Electronics</option>
            <option value="top">Top 3 Products by Quantity</option>
        </select>
        <input type="submit" value="Generate Report">
    </form>
    <a href="index.jsp">Home</a>
</body>
</html>
