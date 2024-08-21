package com.example.demo.creacion;

import com.example.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Creacion {

    private static final Logger log = Logger.getLogger(Creacion.class.getName());

    public void justFrom(){
        Mono.just(new Persona(1,"david",32));
        //Flux.just(coleccion);
    }

    public void empty(){
      Mono.empty();
      Flux.empty();
    }

    public void range(){
        System.out.println("range");
        Flux.range(0,3)
                .doOnNext(i -> log.info(""+ i)).subscribe();
    }

    public void repeat(){

        System.out.println("repeat");
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));

        Flux.fromIterable(personas)
                .repeat(2)
                .subscribe(persona -> {
                    log.info("personas");
                    log.info(""+ persona);
                });

//        Mono.just(personas)
//                .repeat(2)
//                .subscribe(persona -> {
//                    log.info("personas");
//                    log.info(""+ persona);
//                });
    }

}
