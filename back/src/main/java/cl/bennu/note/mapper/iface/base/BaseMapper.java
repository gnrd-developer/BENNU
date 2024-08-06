package cl.bennu.note.mapper.iface.base;

import java.util.List;

public interface BaseMapper<T> {

    List<T> getAll();

    T getById(Long id);

    void insert(T type);

    void update(T type);

    void deleteById(Long id);

}
