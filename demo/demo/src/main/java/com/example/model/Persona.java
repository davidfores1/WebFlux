package com.example.model;

import lombok.Data;

@Data
public class Persona {

    private Integer idPersona;
    private String nombre;
    private Integer edad;

    public Persona(int i, String david, int i1) {
        super();
        this.idPersona = i;
        this.nombre = david;
        this.edad = i1;
    }

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
                + ", edad=" + edad + "]";
    }
}
