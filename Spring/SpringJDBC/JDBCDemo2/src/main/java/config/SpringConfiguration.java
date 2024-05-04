package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 18:38
 * @Description: com.config
 * @version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com"}) //默认加载当前所在包的子包下的信息
/*@EnableTransactionManagement //开启事务注解*/
public class SpringConfiguration {

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //关联数据源
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        //关联数据源
        dataSourceTransactionManager.setDataSource(dataSource);
        return  dataSourceTransactionManager;
    }

}
