package th.in.tomorn.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestfulApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringApplication.class);

    public static void main(String[] args) {
        LOG.info("main");
        SpringApplication.run(SpringApplication.class, args);
    }
}
