package by.resliv.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@ComponentScan({"by.resliv.telegrambot.bot", "by.resliv.telegrambot.controllers",
        "by.resliv.telegrambot.repository", "by.resliv.telegrambot.services.implementations",
        "by.resliv.telegrambot.dto.converters"})
@EnableJpaRepositories("by.resliv.telegrambot.repository")
@EntityScan("by.resliv.telegrambot.entities")
public class Application {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Application.class, args);
    }
}