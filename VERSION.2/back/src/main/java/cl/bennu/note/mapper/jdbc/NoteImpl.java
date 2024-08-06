package cl.bennu.note.mapper.jdbc;

import cl.bennu.note.domain.Note;
import cl.bennu.note.mapper.iface.NoteMapper;
import cl.bennu.note.mapper.jdbc.base.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteImpl extends JDBCUtils implements NoteMapper {


    @Override
    public List<Note> getAll() {
        List<Note> notes = new ArrayList<>();
        Connection connection = this.open();
        try {

            String selectQuery = "SELECT * FROM note" ;
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getLong(1));
                note.setCategoryId(resultSet.getLong(2));
                note.setNoteTypeid(resultSet.getLong(3));
                note.setLabelId(resultSet.getLong(4));
                note.setStatusId(resultSet.getLong(5));
                note.setCode(resultSet.getString(6));
                note.setShortName(resultSet.getString(7));
                note.setName(resultSet.getString(8));
                note.setDeleted(resultSet.getBoolean(9));
                note.setActive(resultSet.getBoolean(10));
                notes.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
        return notes;
    }

    @Override
    public Note getById(Long id) {
        Note note = null;
        Connection connection = this.open();
        try {

            String selectQuery = "SELECT * FROM note WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                note = new Note();
                note.setId(resultSet.getLong(1));
                note.setCategoryId(resultSet.getLong(2));
                note.setNoteTypeid(resultSet.getLong(3));
                note.setLabelId(resultSet.getLong(4));
                note.setStatusId(resultSet.getLong(5));
                note.setCode(resultSet.getString(6));
                note.setShortName(resultSet.getString(7));
                note.setName(resultSet.getString(8));
                note.setDeleted(resultSet.getBoolean(9));
                note.setActive(resultSet.getBoolean(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
        return note;
    }

    @Override
    public void insert(Note note) {
        Connection connection = this.open();
        try {
            String insertQuery = "INSERT INTO note (category_id, note_type_id, label_id, status_id, code, short_name, name, deleted, active) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement =connection.prepareStatement(insertQuery);
            preparedStatement.setLong(1, note.getCategoryId());
            preparedStatement.setLong(2, note.getNoteTypeid());
            preparedStatement.setLong(3, note.getLabelId());
            preparedStatement.setLong(4, note.getStatusId());
            preparedStatement.setString(5, note.getCode());
            preparedStatement.setString(6, note.getShortName());
            preparedStatement.setString(7, note.getName());
            preparedStatement.setBoolean(8, note.isDeleted());
            preparedStatement.setBoolean(9, note.isActive());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
    }

    @Override
    public void update(Note note) {
        Connection connection = this.open();
        try {
            String updateQuery = "UPDATE note SET category_id = ?, note_type_id = ?," +
                    " label_id = ?, status_id = ?, code = ?, short_name = ?, name = ?," +
                    " deleted = ?, active = ? WHERE id = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);

            updateStmt.setLong(1,note.getCategoryId());
            updateStmt.setLong(2,note.getNoteTypeid());
            updateStmt.setLong(3,note.getLabelId());
            updateStmt.setLong(4,note.getStatusId());
            updateStmt.setString(5,note.getCode());
            updateStmt.setString(6,note.getShortName());
            updateStmt.setString(7,note.getName());
            updateStmt.setBoolean(8,note.isDeleted());
            updateStmt.setBoolean(9,note.isActive());

            updateStmt.setLong(10, note.getId());
            updateStmt.executeUpdate();

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
            String deleteQuery = "DELETE FROM note WHERE id = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(deleteQuery);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(connection);
        }
    }

}
