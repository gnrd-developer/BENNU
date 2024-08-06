package cl.bennu.note.mapper.jdbc;

import cl.bennu.note.domain.Category;
//import cl.bennu.note.domain.User;
import cl.bennu.note.mapper.iface.CategoryMapper;
import cl.bennu.note.mapper.jdbc.base.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl extends JDBCUtils implements CategoryMapper {


    @Override
    public void insert(Category category) {

        Connection connection = this.open();
        try{
            String query = "INSERT INTO category (user_id, label_id, name, active) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, category.getUserId());
            preparedStatement.setLong(2, category.getLabelId());
            preparedStatement.setString(3, category.getName());
            preparedStatement.setBoolean(4,category.getActive());
            preparedStatement.executeUpdate();
            System.out.println("categoria insertada");

        }catch (Exception e){

            System.err.println("error al insertar una categoria");
        }finally {
            this.close(connection);
        }
    }


    @Override
    public Category getById(Long id) {
        Category category = null;
        Connection connection = this.open();
        try {
            String query = "SELECT id, user_id, label_id, name, active FROM category WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setUserId(resultSet.getLong("user_id"));
                category.setLabelId(resultSet.getLong("label_id"));
                category.setName(resultSet.getString("name"));
                category.setActive(resultSet.getBoolean("active"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
        return category;
    }

    @Override
    public void update(Category category) {

        Connection connection = this.open();

        try {
            String query = "UPDATE category SET name = ?, active = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setBoolean(2, category.getActive());
            preparedStatement.setLong(3,category.getId());
            preparedStatement.executeUpdate();
            System.out.println("categoria actualizada con exito");

        }catch (Exception e){
            System.out.println("error al actualizar una categoria");
        }finally {
            this.close(connection);
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = this.open();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, user_id, label_id, name, active FROM category");
            while (resultSet.next()) {
                Category category = new Category();

                category.setId(resultSet.getLong(1));
                category.setUserId(resultSet.getLong(2));
                category.setLabelId(resultSet.getLong(3));
                category.setName(resultSet.getString(4));
                category.setActive(resultSet.getBoolean(5));

                categories.add(category);
            }

        } catch (Exception e) {
            System.out.println("error al conectarse");
        } finally {
            this.close(connection);
        }

        return categories;
    }



    @Override
    public void deleteById(Long id) {
        Connection connection = this.open();

        try{
            String query = "DELETE FROM category WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close(connection);
        }


    }

    @Override
    public List<Category> findCategory(Category category) {
        return null;
    }
}
