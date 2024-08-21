package com.example.demo;

import com.example.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mono();
        flux();
        fluxMono();
    }

    public void mono() {
        System.out.println("mono");
        Mono.just(new Persona(1, "David", 25))
                .doOnNext(persona -> {
                    persona.setEdad(persona.getEdad() + 6);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void flux(){
        System.out.println("flux");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
    }

    public void fluxMono(){
        System.out.println("fluxMono");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas).collectList().subscribe(p -> log.info(p.toString()));
    }
   }
