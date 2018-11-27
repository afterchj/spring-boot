package com.tp.demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hongjian.chen on 2018/11/27.
 */
@Configuration
//加上这个注解，使得支持事务
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfig implements TransactionManagementConfigurer {

    private static String driverClassName;
    private static String jdbc_url;
    private static String username;
    private static String password;
    private static int maxActive;
    private static int maxIdle;
    private static long maxWait;

    static {
        InputStream inputStream = DBConfig.class.getClassLoader().getResourceAsStream("application.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            driverClassName = (String) p.get("driverClassName");
            jdbc_url = (String) p.get("jdbc_url");
            username = (String) p.get("username");
            password = (String) p.get("password");
            maxActive = Integer.parseInt((String) p.get("maxActive"));
            maxIdle = Integer.parseInt((String) p.get("maxIdle"));
            maxWait = Long.parseLong((String) p.get("maxWait"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "myDateSource")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbc_url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setDataSource(dataSource());
        bean.setTypeAliasesPackage("com.tp.demo.model");
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "mySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "myMapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //获取之前注入的beanName为sqlSessionFactory的对象
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mySqlSessionFactory");
        //指定xml配置文件的路径
        mapperScannerConfigurer.setBasePackage("com.tp.demo.dao");
        return mapperScannerConfigurer;
    }

}
