package com.whiskas68.booter.db;


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
@MapperScan(basePackages = "com.whiskas68.booter.mapper.shop", sqlSessionTemplateRef = "shopSqlSessionTemplate")
public class DataSourceOaConfig {

    @Bean(name = "shopDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.shop")
    @Primary
    public DataSource shopDataSource(){ return DataSourceBuilder.create().build(); }

    @Bean(name = "shopSqlSessionFactory")
    @Primary
    public SqlSessionFactory shopSessionFactory(@Qualifier("shopDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/shop/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "shopTransactionManager")
    @Primary
    public DataSourceTransactionManager shopTransactionManager(@Qualifier("shopDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "shopSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate shopSessionTemplate(@Qualifier("shopSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
