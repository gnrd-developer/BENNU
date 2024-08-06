package cl.bennu.note.mapper.jdbc;

import cl.bennu.note.mapper.iface.ProfileMapper;
import cl.bennu.note.mapper.jdbc.base.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cl.bennu.note.domain.Profile;

public class ProfileImp extends JDBCUtils implements ProfileMapper {


    //----------------------------------GET ALL---------------------------------------------------------------------------------------------------------------------------
    @Override
    public List<Profile> getAll() {

        List<Profile> profiles = new ArrayList<>();
        Connection conn = this.open();
        String consulta = "SELECT id, user_id, mail, name, alias, country_id, address, phone_prefix_id, phone, photo FROM postgres.public.profile";
        try {
            PreparedStatement pS = conn.prepareStatement(consulta);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {
                Profile profile = new Profile(rs.getLong(1), rs.getLong(2), rs.getString(3),
                        rs.getString(4), rs.getString(5) , rs.getLong(6), rs.getString(7), rs.getLong(8),
                        rs.getLong(9), rs.getString(10), rs.getBoolean(11));
                profiles.add(profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(conn);
        }
        return profiles;
    }
    //----------------------------------CIERRE ALL---------------------------------------------------------------------------------------------------------------------------
    
    
    //----------------------------------GET BY ID---------------------------------------------------------------------------------------------------------------------------    
    @Override
    public Profile getById(Long id) {
        Profile profile = new Profile();
        Connection conn = this.open();
        try {
            String consulta = "SELECT user_id, mail, name, alias, country_id, address, phone_prefix_id, phone, photo, status_pofile FROM postgres.public.profile WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(consulta);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {

                profile = new Profile();
                profile.setUsuarioId(rs.getLong(1));
                profile.setMail(rs.getString(2));
                profile.setName(rs.getString(3));
                profile.setAlias(rs.getString(4));
                profile.setCountryId(rs.getLong(5));
                profile.setAddress(rs.getString(6));
                profile.setPhonePrefixId(rs.getLong(7));
                profile.setPhone(rs.getLong(8));
                profile.setPhoto(rs.getString(9));
                profile.setStatusProfile(rs.getBoolean(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(conn);
        }
        return profile;
    }
    //----------------------------------CIERRE GET BY ID---------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    @Override
    public void insert(Profile profile) {
        Connection conn = this.open();
        try {
            String query = "INSERT into postgres.public.profile (user_id, mail, name, alias, country_id, address, phone_prefix_id, phone, photo) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, profile.getUsuarioId());
            ps.setString(2, profile.getMail());
            ps.setString(3, profile.getName());
            ps.setLong(4, profile.getCountryId());
            ps.setString(5, profile.getAlias());
            ps.setLong(5, profile.getCountryId());
            ps.setString(6, profile.getAddress());
            ps.setLong(7, profile.getPhonePrefixId());
            ps.setLong(8, profile.getPhone());
            ps.setString(9, profile.getPhoto());
            ps.executeUpdate();
            System.out.println("\n\tPERFIL CREADO\n");
        } catch (Exception e) {
            System.out.println("\n\tFAIL PROFILE REGISTERED\n");
            e.printStackTrace();
        } finally {
            this.close(conn);
        }
    }//FALTA CORREGIR (AGREGAR ATRIBUTO STATUS PROFILE A PARTIR DE ESTE METODO HACIA ABAJO.)

    @Override
    public void update(Profile profile) {
        Connection conn = this.open();
        try {
            String consulta2 = "UPDATE postgres.public.profile SET mail=?, name=?, alias=?, country_id=?, address=?, phone_prefix_id=?, phone=?, photo=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(consulta2);
            ps.setString(1, profile.getMail());
            ps.setString(2, profile.getName());
            ps.setString(3, profile.getAlias());
            ps.setLong(4, profile.getCountryId());
            ps.setString(5, profile.getAddress());
            ps.setLong(6, profile.getPhonePrefixId());
            ps.setLong(7, profile.getPhone());
            ps.setString(8, profile.getPhoto());
            ps.setLong(9, profile.getId());
            ps.executeUpdate();
            System.out.println("\n\t---------------\n\tUPDATED PROFILE GOU\n\t-----------------------");
        } catch (Exception e) {
            System.out.println("---------------\n\tALGO FALLA GOU\n\t-----------------------");
            e.printStackTrace();
        } finally {
            this.close(conn);
        }

    }

    @Override
    public void deleteById(Long id) {
        Connection conn = this.open();
        try {
            String consulta3 = "DELETE FROM postgres.public.profile WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(consulta3);
            ps.setLong(1, id);
            Integer rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\n\tPERFIL ELIMINADO\n\t");
            } else {
                System.out.println("\n\tPERFIL NO ELIMINADO\n");
            }
        } catch (Exception e) {
            System.out.println("------------------\n\tFALLA EL METODO DELETE BY ID\n\t-----------------");
            e.printStackTrace();
        } finally {
            this.close(conn);
        }
    }
}
