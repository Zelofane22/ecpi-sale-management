package com.sale.ecpisalemanagement.old;

import com.sale.ecpisalemanagement.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryService {

    final static Connection connection = DbService.getConnection();

    public static List<Category> all(String param) {

        List<Category> categories = new ArrayList<Category>();

        String sql = "SELECT * FROM categories WHERE  name LIKE '%" + param + "%' OR  description  LIKE '%" + param + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement
                    (sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category item = new Category();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                categories.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categories;
    }


    public static Category find(int id) {

        Category item = new Category();

        String sql = "SELECT * FROM categories WHERE   id='" + id + "'";
        try {
            PreparedStatement ps = connection.prepareStatement
                    (sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return item;
    }

    public static Category create(Category item) {

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("INSERT INTO categories (name,description) VALUES (?,?)");
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return item;

    }

    public static Category update(Category item) {

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("UPDATE categories set name=?,description=?  WHERE id=?");
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setInt(3, item.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return find(item.getId());
    }

    public static void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("DELETE FROM categories WHERE id=?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
