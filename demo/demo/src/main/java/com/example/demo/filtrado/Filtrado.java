package com.example.demo.filtrado;

import com.example.model.Persona;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {


    public void filter() {

        System.out.println("Filtrado");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .filter(persona -> persona.getNombre().equals("Caren"))
                .subscribe(System.out::println);
    }

    public void distinct() {

        System.out.println("distinct");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(1, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(System.out::println);
    }

    public void take() {

        System.out.println("take");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .take(1)
                .subscribe(System.out::println);
    }

    public void takeLast() {

        System.out.println("takeLast");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .takeLast(3)
                .subscribe(System.out::println);
    }

    public void skip() {

        System.out.println("skip");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(System.out::println);
    }

    public void skipLast() {

        System.out.println("skipLast");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Camilo", 10));
        personas.add(new Persona(2, "Cristian", 30));
        personas.add(new Persona(3, "Caren", 15));
        personas.add(new Persona(4, "Luisa", 20));

        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(System.out::println);
    }
}
