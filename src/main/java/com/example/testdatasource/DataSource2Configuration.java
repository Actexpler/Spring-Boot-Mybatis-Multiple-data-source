package com.example.testdatasource;

import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author wangzongcheng
 * @ClassName DataSource2Configuration.java
 * @Description TODO
 * @createTime 2019-10-12- 09:11:00
 */
@Configuration
@MapperScan(basePackages = "com.example.testdatasource.mapper.student",sqlSessionTemplateRef = "studentSqlSessionTemplate")
public class DataSource2Configuration {
    @Bean(name = "dataSource2")
//    @Primary
    @ConfigurationProperties(prefix = "stu")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }

    @Bean(name = "mybatis2")
    @ConfigurationProperties(prefix = "mybatis2")
    public org.apache.ibatis.session.Configuration globalConfiguration(){
        return new org.apache.ibatis.session.Configuration();
    }


    @Bean(name = "studentSqlSessionFactory")
//    @Primary
    public SqlSessionFactory studentSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource,
                                                      @Qualifier("mybatis2") org.apache.ibatis.session.Configuration config) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfiguration(config);
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/student/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "studentTransactionmanager")
//    @Primary
    public DataSourceTransactionManager studentTransactionManager(@Qualifier("dataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "studentSqlSessionTemplate")
//    @Primary
    public SqlSessionTemplate studentSqlSessionTemplate(@Qualifier("studentSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
