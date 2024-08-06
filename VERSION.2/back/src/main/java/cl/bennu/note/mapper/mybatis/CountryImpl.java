package cl.bennu.note.mapper.mybatis;


import cl.bennu.note.domain.Country;
import cl.bennu.note.mapper.iface.CountryMapper;
import cl.bennu.note.mapper.mybatis.base.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
//import java.util.ArrayList;
import java.util.List;

public class CountryImpl extends MyBatisUtils implements CountryMapper {



    @Override
    public List<Country>  getAll() {
        try (SqlSession sqlSession = this.open()) {
            return sqlSession.selectList("selectAllCountry");
        }
    }

    @Override
    public  void insert(Country country) {

        try (SqlSession sqlSession = this.open()){
            sqlSession.insert("insert", country);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println("Error al inserta Country"+ e.getMessage());
        }
    }

    @Override
    public void update(Country country) {

        try (SqlSession sqlSession = this.open()){
            sqlSession.update("updateCountry", country);
            sqlSession.commit();
        }catch ( Exception e){
            System.err.println();
        }

    }

    @Override
    public Country getById(Long id) {
        return this.open().selectOne("selectCountryById", id);
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession sqlSession = this.open()) {
            sqlSession.delete("deleteCountryId", id );
            sqlSession.commit();
        }catch (Exception e){
            System.err.println();
        }

    }

    @Override
    public List<Country> findCountry(Country country) {
        return open().selectList("findCountry", country);
    }



}
