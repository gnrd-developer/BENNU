package cl.bennu.note.mapper.jdbc;
import cl.bennu.note.domain.Country;
import cl.bennu.note.mapper.iface.CountryMapper;
import cl.bennu.note.mapper.jdbc.base.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


public class CountryImpl extends JDBCUtils implements CountryMapper {


    @Override
    public List<Country> getAll() {
        List<Country> countrys = new ArrayList<>();
        Connection connection = this.open();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name, flag, prefix from Country");
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getLong(1));
                country.setName(resultSet.getString(2));
                country.setFlag(resultSet. getString(3));
                country.setPrefix(resultSet.getLong(4));


                countrys.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }

        return countrys;
    }




    @Override
    public Country getById(Long id) {
        Country country = new Country();
        Connection connection = this.open();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name from Country where id = "+ id );

            if (resultSet.next()) {

                country.setId(resultSet.getLong(1));
                country.setName(resultSet.getString(2));
            } else {
                throw new Exception("No se a encontrado ese registro.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }

        return country;
    }

    @Override
    public void insert(Country country) {
        Connection connection = this.open();
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement("INSERT INTO country( name, flag, prefix ) VALUES ( ?, ?, ?)");
            stat.setString(1, country.getName());
            stat.setString(2, country.getFlag());
            stat.setLong(3, country.getPrefix());
            stat.executeUpdate();

            System.out.println("Se ingreso un Country de manera correcta");
        } catch (Exception e) {
            System.out.println("No se ingreso de manera correcta Country"+ e.getMessage());
        } finally {
            this.close(connection);
        }


    }

    @Override
    public void update(Country country) {
        Connection connection = this.open();
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement("UPDATE country SET name = ?, flag= ?, prefix=? WHERE id= ?");
            stat.setString(1, country.getName());
            stat.setString(2, country.getFlag());
            stat.setLong(3, country.getPrefix());
            stat.setLong(4, country.getId());
            if (stat.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya modificado Country");
            }
            System.out.println("COUNTRY ACTUALIDADA");
        }catch (Exception e){
            System.out.println("Error al actualizar Country");
        }
    }
    @Override
    public void deleteById(Long id) {
        Connection connection = this.open();
        try {

            Statement statement = connection.createStatement();


            if (statement.executeUpdate("delete from Country where id = "+ id ) ==0){
                throw new Exception("Puede que Country no se haya borrado. ");
            } else {
                System.out.println("Se borro correctamente el country ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }



    }

    @Override
    public Country getByCommune(Long communeId) {
        return null;
    }
}
