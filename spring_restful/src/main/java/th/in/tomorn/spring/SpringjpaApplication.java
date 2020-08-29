package th.in.tomorn.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjpaApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringjpaApplication.class);

    public static void main(String[] args) {
        LOG.info("main");
        SpringApplication.run(SpringjpaApplication.class, args);
    }
}
