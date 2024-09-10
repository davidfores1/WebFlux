package com.example.model;

import lombok.Data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(idPersona, persona.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPersona);
    }
}
