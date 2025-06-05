package dao;

import java.sql.*;
import java.util.*;
import com.model.Product;

public class ProductDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/productmanagementdb";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = ""; // Update if needed

    private static final String INSERT_PRODUCT = "INSERT INTO Products VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM Products";
    private static final String DELETE_PRODUCT = "DELETE FROM Products WHERE ProductID = ?";
    private static final String UPDATE_PRODUCT = "UPDATE Products SET ProductName=?, Category=?, Price=?, Quantity=? WHERE ProductID=?";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void addProduct(Product product) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT_PRODUCT)) {
            stmt.setInt(1, product.getProductID());
            stmt.setString(2, product.getProductName());
            stmt.setString(3, product.getCategory());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.executeUpdate();
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ProductID"), rs.getString("ProductName"),
                        rs.getString("Category"), rs.getDouble("Price"), rs.getInt("Quantity")));
            }
        }
        return list;
    }

    public void updateProduct(Product product) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE_PRODUCT)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getCategory());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getProductID());
            stmt.executeUpdate();
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }

    // Add methods for reports if needed
}

