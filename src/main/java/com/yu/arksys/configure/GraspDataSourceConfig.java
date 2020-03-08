package com.yu.arksys.configure;

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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.yu.arksys.grasp.dao", sqlSessionTemplateRef = "graspSqlSessionTemplate")
public class GraspDataSourceConfig {

    @Bean(name = "graspDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.grasp")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "graspSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("graspDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "graspTrasactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("graspDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "graspSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("graspSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
