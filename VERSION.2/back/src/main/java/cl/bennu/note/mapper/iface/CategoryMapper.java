package cl.bennu.note.mapper.iface;

import cl.bennu.note.domain.Category;
import cl.bennu.note.mapper.iface.base.BaseMapper;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> findCategory(Category category);

}
