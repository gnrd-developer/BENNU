package cl.bennu.note.factory;

import cl.bennu.note.constants.NoteConstants;
import cl.bennu.note.mapper.iface.CategoryMapper;
import cl.bennu.note.mapper.iface.CountryMapper;
import cl.bennu.note.mapper.iface.NoteMapper;
import cl.bennu.note.mapper.iface.UserMapper;
import cl.bennu.note.mapper.jdbc.CountryImpl;
// import cl.bennu.note.mapper.jdbc.NoteImpl;
// import cl.bennu.note.mapper.jdbc.UserImpl;

public class MapperFactory {


    public static NoteMapper getNoteMapper() {
        if (NoteConstants.DB_MODE.equals("jdbc")) {
            return new cl.bennu.note.mapper.jdbc.NoteImpl();
        } else if (NoteConstants.DB_MODE.equals("mybatis")) {
            return new cl.bennu.note.mapper.mybatis.NoteImpl();
        } else {
            return null;
        }
    }

    public static CountryMapper getCountryMapper() {
        if (NoteConstants.DB_MODE.equals("jdbc")){
            return new cl.bennu.note.mapper.jdbc.CountryImpl();
        } else if (NoteConstants.DB_MODE.equals(("mybatis"))) {
            return new cl.bennu.note.mapper.mybatis.CountryImpl();

        }

        return new CountryImpl();
    }

    public static CategoryMapper getCategoryMapper() {
        if (NoteConstants.DB_MODE.equals("jdbc")) {
            return new cl.bennu.note.mapper.jdbc.CategoryImpl();
        } else if (NoteConstants.DB_MODE.equals("mybatis")) {
            return new cl.bennu.note.mapper.mybatis.CategoryImpl();
        } else {
            return null;
        }
    }

    public static UserMapper getUserMapper() {
        if (NoteConstants.DB_MODE.equals("jdbc")) {
            return new cl.bennu.note.mapper.jdbc.UserImpl();
        } else if (NoteConstants.DB_MODE.equals("mybatis")) {
            return new cl.bennu.note.mapper.mybatis.UserImpl();
        } else {
            return null;
        }
    }

    public static ProfileMapper getProfileMapper()
    {
        if (NoteConstants.DB_MODE.equals("jdbc")) {
            return new cl.bennu.note.mapper.jdbc.ProfileImp();
        } else if (NoteConstants.DB_MODE.equals("mybatis")) {
            return new cl.bennu.note.mapper.mybatis.ProfileImp();
        } else {
            return null;
        }

    }    
}
