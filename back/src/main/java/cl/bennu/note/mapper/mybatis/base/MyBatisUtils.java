package cl.bennu.note.mapper.mybatis.base;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {

    public SqlSession open() {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.err.println("Error al abrir la conexion con la base de datos.");
            e.printStackTrace(); 
        }

        return sqlSessionFactory == null ? null : sqlSessionFactory.openSession();
    }

}
