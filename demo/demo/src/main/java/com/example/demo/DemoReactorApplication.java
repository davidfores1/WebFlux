package com.example.demo;

import com.example.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        reactor();
    }

    public void reactor() {
        Mono.just(new Persona(1, "David", 25))
                .doOnNext(persona -> {
                    persona.setEdad(persona.getEdad() + 6);
                })
                .subscribe(p -> log.info(p.toString()));
    }
   }
