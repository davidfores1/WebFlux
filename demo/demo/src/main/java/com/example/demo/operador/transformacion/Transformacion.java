package com.example.demo.operador.transformacion;

import com.example.demo.operador.creacion.Creacion;
import com.example.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Transformacion {

    private static final Logger log = Logger.getLogger(Creacion.class.getName());

    public void map(){
        System.out.println("map");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .map(persona -> {
                    persona.setNombre(persona.getNombre().toUpperCase());
                    persona.setEdad(persona.getEdad() + 1);
                    return persona;
                }).subscribe(persona -> log.info(persona.toString()));

    }

    public void flatMap(){
        System.out.println("flatMap");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .flatMap(persona -> {
                    persona.setNombre(persona.getNombre().toUpperCase());
                    persona.setEdad(persona.getEdad() + 1);
                    return Mono.just(persona);
                }).subscribe(persona -> log.info(persona.toString()));
    }

    public void groupBy(){
        System.out.println("groupBy");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(1, "Cristian", 30));
        personas.add(new Persona(1, "Caren", 15));
        personas.add(new Persona(1, "Luisa", 20));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(persona -> persona.collectList())
                .subscribe(persona -> log.info(persona.toString()));
    }

}
