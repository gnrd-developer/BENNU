package cl.bennu.note.mapper.iface;

import cl.bennu.note.domain.Country;

import cl.bennu.note.mapper.iface.base.BaseMapper;

import java.util.List;

public interface CountryMapper  extends BaseMapper<Country> {

    List<Country> findCountry (Country country);



}
