package com.product.dao;
import java.sql.*;
import java.util.*;
import com.product.model.Product;
public class ProductDAO {
	public static int addProduct(Product p) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, p.getName());
        ps.setString(2, p.getDescription());
        ps.setDouble(3, p.getPrice());
        ps.setInt(4, p.getQuantity());
        return ps.executeUpdate();
    }
	public static List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM products");
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));
            list.add(p);
        }
        return list;
    }

    public static int deleteProduct(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id = ?");
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    public static Product getProductById(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        	 Product p = new Product();
             p.setId(rs.getInt("id"));
             p.setName(rs.getString("name"));
             p.setDescription(rs.getString("description"));
             p.setPrice(rs.getDouble("price"));
             p.setQuantity(rs.getInt("quantity"));
             return p;
         }
         return null;
     }
    public static int updateProduct(Product p) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE products SET name=?, description=?, price=?, quantity=? WHERE id=?");
        ps.setString(1, p.getName());
        ps.setString(2, p.getDescription());
        ps.setDouble(3, p.getPrice());
        ps.setInt(4, p.getQuantity());
        ps.setInt(5, p.getId());
        return ps.executeUpdate();
    }
        }

