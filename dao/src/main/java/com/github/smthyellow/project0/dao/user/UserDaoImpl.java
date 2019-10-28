package com.github.smthyellow.project0.dao.user;

import com.github.smthyellow.project0.dao.DataSource;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    public static class Singleton {
        static UserDao HOLDER_INSTANCE = new UserDaoImpl();
    }

    public static UserDao getInstance(){
        return UserDaoImpl.Singleton.HOLDER_INSTANCE;
    }

    @Override
    public int save(String firstName, String lastName, String email, String phone, String password) {
        final String sql = "insert into user(firstName, lastName, email, phone, password, role) values(?,?,?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, password);
            ps.setString(6, "CLIENT");
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                return keys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getByEmail(String email) {

        final String sql = "select * from user where email = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    //String firstName, String lastName, String phone, String email, int userId, String password, String role
                    return new User(
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getInt("userId"),
                            rs.getString("password"),
                            Role.valueOf(rs.getString("role"))
                            );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {
        final String sql = "delete from user where email = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        final String sql = "update user set firstName = ?, lastName = ?, email = ?, phone = ?, password = ?, role = ?) where id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole().name());
            ps.setInt(7, user.getUserId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
