package cl.bennu.note.mapper.jdbc;

import cl.bennu.note.domain.Category;
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
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("INSERT INTO category (user_id, label_id, name, active) VALUES (?,?,?,?)");
            statement.setLong(1, category.getUserId());
            statement.setLong(2, category.getLabelId());
            statement.setString(3, category.getName());
            statement.setBoolean(4,category.getActive());
            statement.executeUpdate();
            System.out.println("\tcategoria insertada");

        }catch (Exception e){
            System.err.println("\terror al insertar una categoria");
            e.printStackTrace();
        }finally {
            this.close(connection);
        }
    }


    @Override
    public Category getById(Long id) {

        Connection connection = this.open();
        Category categoryForId = new Category();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT  user_id, label_id, name, active FROM category order by id");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                categoryForId.setUserId(result.getLong(1));
                categoryForId.setLabelId(result.getLong(2));
                categoryForId.setName(result.getString(2));
                categoryForId.setActive(result.getBoolean(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error al leer la categoria");

        }
        return categoryForId;
    }

    @Override
    public void update(Category category) {

        Connection connection = this.open();


        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE category SET name = ?, active = ? WHERE id=?");

            statement.setString(1,category.getName());
            statement.setBoolean(2, category.getActive());
            statement.setLong(3,category.getId());
            statement.executeUpdate();
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

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM category WHERE id = ?");
            statement.setLong(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("categoria borrada con exito");
            } else {
                System.out.println("no pudo eliminar la categoria ");
            }

        } catch (Exception e) {
            System.out.println("error al borrar la categoria");

        } finally {
            this.close(connection);
        }



    }

    @Override
    public List<Category> findCategory(Category category) {
        return null;
    }
}
