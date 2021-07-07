package com.bug.free.invention.api.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataAccess {

    // Creates the SQL Session every time a new instance of the class is called
    // These connections MUST be closed

    //Usage example:
    //		DataAccess db = new DataAccess();
    //		SqlSession session = db.access();
    //      <relevant database code>
    //		session.close();

    public SqlSession access() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        SqlSession session = factory.openSession();
        return session;
    }
}
