package braincohort.pku.edu.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "braincohort.pku.edu.website.services")
@EnableCaching
public class WebsiteApplication {

    @Bean
    public JsonParser getJsonParser(){
        return new JsonParser();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}

