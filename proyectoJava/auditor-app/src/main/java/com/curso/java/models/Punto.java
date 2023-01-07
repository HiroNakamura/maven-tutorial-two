package com.curso.java.models;

import com.curso.java.exceptions.PuntoException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Punto {
    private int x;
    private int y;

    public Punto gePunto(int x, int y) throws PuntoException{
        if(x < 0 || y < 0){
            throw new PuntoException("No se pudo obtener el objeto Punto");
        }   
        return new Punto(x,y);     
    }
}
