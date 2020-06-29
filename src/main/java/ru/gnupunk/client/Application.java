package ru.gnupunk.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.gnupunk.client.core.Core;

@SpringBootApplication(scanBasePackages = {"ru.gnupunk.client.*"})
@ComponentScan({"ru.gnupunk.client.*"})
@EnableJpaRepositories(basePackages = "ru.gnupunk.client.repository")
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
        ctx.start();
    }
}
