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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.yu.arksys.lastyear.dao", sqlSessionTemplateRef = "lastYearGraspSqlSessionTemplate")
public class LastYearGraspDataSourceConfig {
    @Bean(name = "lastYearGraspDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.lastyear")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "lastYearGraspSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("lastYearGraspDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "lastYearGraspTrasactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("lastYearGraspDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "lastYearGraspSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("lastYearGraspSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
