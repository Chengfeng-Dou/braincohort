package braincohort.pku.edu.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsiteApplication {

    @Bean
    public JsonParser getJsonParser(){
        return new JsonParser();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}

