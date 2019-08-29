package com.example.ssm.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@Configuration
@MapperScan(basePackages = "com.example.ssm.mapper.teacher.teacherMapper",sqlSessionTemplateRef = "teacherSqlSessionTemplate")
public class DataSource2Config {
    @Bean(name = "teacherDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.teacher")
//    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "teacherSqlSessionFactory")
//    @Primary
    public SqlSessionFactory teacherSqlSessionFactory(@Qualifier("teacherDataSource")DataSource dataSource) throws  Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/teacher/teacherMapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "teacherTransactionmanager")
//    @Primary
    public DataSourceTransactionManager teacherTransactionManager(@Qualifier("teacherDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "teacherSqlSessionTemplate")
//    @Primary
    public SqlSessionTemplate teacherSqlSessionTemplate(@Qualifier("teacherSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
