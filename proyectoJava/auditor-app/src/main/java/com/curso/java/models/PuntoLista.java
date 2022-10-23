package com.curso.java.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PuntoLista {
    private Punto punto;
    private List<String> lista;
}
