package sn.msae.sendmailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SendMailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendMailServiceApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfiguration() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://portail.msae.sn")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept");
                WebMvcConfigurer.super.addCorsMappings(registry);
            }
        };
    }
}
