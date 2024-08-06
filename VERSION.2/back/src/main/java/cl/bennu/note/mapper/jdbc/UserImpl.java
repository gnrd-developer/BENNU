package cl.bennu.note.mapper.jdbc;

import cl.bennu.note.domain.User;
import cl.bennu.note.mapper.iface.UserMapper;
import cl.bennu.note.mapper.jdbc.base.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserImpl extends JDBCUtils implements UserMapper {

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Connection connection = this.open();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, username, password, last_login, last_password, active FROM \"user\"");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setLastLogin(resultSet.getTimestamp("last_login"));
                user.setLastPassword(resultSet.getTimestamp("last_password"));
                user.setActive(resultSet.getBoolean("active"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
        return users;
    }

    @Override
    public User getById(Long id) {
        User user = null;
        Connection connection = this.open();
        try {
            String sql = "SELECT id, username, password, last_login, last_password, active FROM \"user\" WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setLastLogin(resultSet.getTimestamp("last_login"));
                user.setLastPassword(resultSet.getTimestamp("last_password"));
                user.setActive(resultSet.getBoolean("active"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
        return user;
    }

    @Override
    public void insert(User user) {
        Connection connection = this.open();
        try {
            String sql = "INSERT INTO \"user\" (username, password, last_login, last_password, active) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setTimestamp(3, user.getLastLogin());
            preparedStatement.setTimestamp(4, user.getLastPassword());
            preparedStatement.setBoolean(5, user.isActive());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
    }

    @Override
    public void update(User user) {
        Connection connection = this.open();
        try {
            String sql = "UPDATE \"user\" SET username = ?, password = ?, last_login = ?, last_password = ?, active = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setTimestamp(3, user.getLastLogin());
            preparedStatement.setTimestamp(4, user.getLastPassword());
            preparedStatement.setBoolean(5, user.isActive());
            preparedStatement.setLong(6, user.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = this.open();
        try {
            String sql = "DELETE FROM \"user\" WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
    }
}
