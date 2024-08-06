package cl.bennu.note.mapper.mybatis;

import cl.bennu.note.domain.Note;
import cl.bennu.note.mapper.iface.NoteMapper;
import cl.bennu.note.mapper.mybatis.base.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoteImpl extends MyBatisUtils implements NoteMapper {
    @Override
    public List<Note> getAll() {
        return this.open().selectList("selectNote");
    }

    @Override
    public Note getById(Long id) {
        return this.open().selectOne("selectNoteById",id);
    }

    @Override
    public void insert(Note note) {
        SqlSession sqlSession = this.open();
        try {
            sqlSession.insert("insertNote", note);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    @Override
    public void update(Note note) {
        SqlSession sqlSession = this.open();
        try {
            sqlSession.update("updateNote", note);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    @Override
    public void deleteById(Long id) {
        SqlSession sqlSession = this.open();
        try {
            sqlSession.delete("deleteNoteById", id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }
}
