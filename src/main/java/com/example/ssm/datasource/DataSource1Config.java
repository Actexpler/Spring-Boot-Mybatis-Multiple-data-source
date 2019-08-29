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
@MapperScan(basePackages = "com.example.ssm.mapper.student.studentMapper",sqlSessionTemplateRef = "studentSqlSessionTemplate")
public class DataSource1Config {
    @Bean(name = "studentDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.student")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "studentSqlSessionFactory")
    @Primary
    public SqlSessionFactory studentSqlSessionFactory(@Qualifier("studentDataSource")DataSource dataSource) throws  Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/student/studentMapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "studentTransactionmanager")
    @Primary
    public DataSourceTransactionManager studentTransactionManager(@Qualifier("studentDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "studentSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate studentSqlSessionTemplate(@Qualifier("studentSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
