package th.in.tomorn.spring.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WebConfig {

    @Bean(name = "jdbcConnectionDb1")
    public JdbcTemplate jdbcConnectionDb1(@Qualifier("db1") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.db1")
    public DataSource dataSourceDb1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcConnectionDb2")
    public JdbcTemplate jdbcConnectionDb2(@Qualifier("db2") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.db2")
    public DataSource dataSourceDb2() {
        return DataSourceBuilder.create().build();
    }
}
