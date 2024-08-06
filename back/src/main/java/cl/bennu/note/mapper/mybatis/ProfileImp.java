package cl.bennu.note.mapper.mybatis;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import cl.bennu.note.domain.Profile;
import cl.bennu.note.mapper.iface.ProfileMapper;
import cl.bennu.note.mapper.mybatis.base.MyBatisUtils;

public class ProfileImp extends MyBatisUtils implements ProfileMapper {

    private SqlSession session;
    public ProfileImp(){
        this.session = this.open();
        if(this.session == null)
        {
            throw new RuntimeException("FALLO, ALGO FALLA AQUI EN ProfileImp");
        }
    }

    @Override
    public List<Profile> getAll(){
        try {
            return session.selectList("selectProfile");            
        } catch (PersistenceException  e) {
            throw new PersistenceException("algo falla");
        }
    }

    @Override
    public Profile getById(Long id) {
        try {
            Profile profile = session.selectOne("selectProfileById", id);
            if (profile == null) {
                System.out.println("No se encontró ningún perfil con el ID: " + id);
            }
            return profile;            
        } catch (PersistenceException e) {
            System.out.println("Error al obtener el perfil por id: " + id + ". " + e.getMessage());
            return null;
        }
    }

    @Override
    public void insert(Profile type) {
        try {
            session.insert("insertProfile", type);
            session.commit();
            System.out.println("PERFIL INSERTADO");
        } catch (Exception e) {
            System.out.println("PERFIL NO INSERTADO" + e.getMessage());
            
            session.rollback();
        }

    }

    @Override
    public void update(Profile type) {
        try {
            session.update("updateProfile", type);
            session.commit();
            System.out.println("PERFIL ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("PERFIL NO ACTUALIZADO");
            session.rollback();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            session.delete("deleteProfileById", id);
            session.commit();
            System.out.println("PERFIL " + id + " ELIMINADO");
        } catch (Exception e) {
            System.out.println("PERFIL NO ELIMINADO");
            session.rollback();
        }
    }

    public void close() {
        session.close();
    }
}
