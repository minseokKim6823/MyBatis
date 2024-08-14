package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "root";
    private static String password;

    public static void main(String[] args) {
        /* 설명.
         *  JdbcTransactionFactory: 수동 커밋
         *  ManagedTransactionFactory: 자동 커밋
         *  -------------------------------------
         *  PooledDataSource: ConnectionPool 사용
         *  UnpooledDataSource: ConnectionPool 미사용
        * */

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password)
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession(false);    // 수동 커밋

        Mapper mapper = session.getMapper(Mapper.class);
        java.util.Date date = mapper.selectNow();
        System.out.println("date = " + date);

        session.close();
    }
}
