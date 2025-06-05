<!DOCTYPE html>
<html>
<head><title>Add Product</title></head>
<body>
    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        ID: <input type="number" name="productId"><br>
        Name: <input type="text" name="productName"><br>
        Category: <input type="text" name="category"><br>
        Price: <input type="text" name="price"><br>
        Quantity: <input type="number" name="quantity"><br>
        <input type="submit" value="Add Product">
    </form>
    <a href="index.jsp">Home</a>
</body>
</html>
