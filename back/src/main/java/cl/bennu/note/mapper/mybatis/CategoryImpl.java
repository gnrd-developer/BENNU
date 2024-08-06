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
    public void insert(Category type) {
        SqlSession sqlSession = this.open();
        try {
            sqlSession.insert("insertCategory", type);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    @Override
    public void update(Category type) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Category> findCategory(Category category) {
        return open().selectList("findCategory", category);
    }


}
