package cl.bennu.note.mapper.mybatis;

import cl.bennu.note.domain.Category;
import cl.bennu.note.mapper.iface.CategoryMapper;
import cl.bennu.note.mapper.mybatis.base.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryImpl extends MyBatisUtils implements CategoryMapper {
    @Override
    public List<Category> getAll() {
        return this.open().selectList("selectCategory");
    }

    @Override
    public Category getById(Long id) {
        return this.open().selectOne("selectCategoryById", id);
    }

    @Override
    public void insert(Category category) {
        try (SqlSession sqlSession = this.open()) {
            sqlSession.insert("insertCategory", category);
            sqlSession.commit();
            System.out.println("Categoria insertada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar categoria: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        SqlSession sqlSession = this.open();
        try {
            sqlSession.update("updateCategory", category);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    @Override
    public void deleteById(Long id) {
        SqlSession sqlSession = this.open();
        try {
            sqlSession.delete("deleteCategory", id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    @Override
    public List<Category> findCategory(Category category) {
        return open().selectList("findCategory", category);
    }


}
