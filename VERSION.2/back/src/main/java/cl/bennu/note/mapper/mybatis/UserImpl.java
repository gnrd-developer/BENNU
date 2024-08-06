package cl.bennu.note.mapper.mybatis;

import cl.bennu.note.domain.User;
import cl.bennu.note.mapper.iface.UserMapper;
import cl.bennu.note.mapper.mybatis.base.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserImpl extends MyBatisUtils implements UserMapper {

    @Override
    public List<User> getAll() {
        try (SqlSession sqlSession = this.open()) {
            return sqlSession.selectList("selectAllUsers");
        }
    }

    @Override
    public User getById(Long id) {
        try (SqlSession sqlSession = this.open()) {
            return sqlSession.selectOne("selectUserById", id);
        }
    }

    @Override
    public void insert(User user) {
        try (SqlSession sqlSession = this.open()) {
            sqlSession.insert("insertUser", user);
            sqlSession.commit();
            System.out.println("Usuario insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (SqlSession sqlSession = this.open()) {
            sqlSession.update("updateUser", user);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession sqlSession = this.open()) {
            sqlSession.delete("deleteUserById", id);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}