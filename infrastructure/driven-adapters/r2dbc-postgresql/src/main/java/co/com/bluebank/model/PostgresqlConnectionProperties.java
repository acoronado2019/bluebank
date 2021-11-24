package co.com.bluebank.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PostgresqlConnectionProperties {

    private String dbname;
    private String schema;
    private String username;
    private String password;
    private String host;
    private Integer port;

}
