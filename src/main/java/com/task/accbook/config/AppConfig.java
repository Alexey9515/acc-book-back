package com.task.accbook.config;

import com.task.accbook.core.orika.mapper.Mapper;
import com.task.accbook.core.orika.mapper.MapperImpl;
import com.task.accbook.core.orika.mapper.MapperRegister;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {
        "com.task.accbook.core",
        "com.task.accbook.api",
        "com.task.accbook.model"})
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public MapperFactory mapperFactory(@Autowired(required = false) List<MapperRegister> mapperRegisters) {
        MapperFactory mapperFactory;
        mapperFactory = new DefaultMapperFactory.Builder().build();
        if (!CollectionUtils.isEmpty(mapperRegisters)) {
            for (MapperRegister mapperRegister : mapperRegisters) {
                mapperRegister.register(mapperFactory);
            }
        }
        return mapperFactory;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        dataSourceTransactionManager.setNestedTransactionAllowed(true);
        return dataSourceTransactionManager;
    }

    @Bean
    public MapperFacade mapperFacade(@Autowired MapperFactory mapperFactory) {
        return mapperFactory.getMapperFacade();
    }

    @Bean
    public Mapper mapper(@Autowired MapperFacade mapperFacade) {
        MapperImpl mapper = new MapperImpl();
        mapper.setMapperFacade(mapperFacade);
        return mapper;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
