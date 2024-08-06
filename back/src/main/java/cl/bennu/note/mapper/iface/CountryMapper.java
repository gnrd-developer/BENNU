package cl.bennu.note.mapper.iface;

import cl.bennu.note.domain.Country;
import cl.bennu.note.mapper.iface.base.BaseMapper;

public interface CountryMapper  extends BaseMapper<Country> {

    Country getByCommune(Long communeId);

}
