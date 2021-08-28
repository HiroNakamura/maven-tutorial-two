package com.cursomaven;

import com.cursomaven.clases.Contacto;

public class App{
    public static void main( String[] args ){
        System.out.println( "\t======== [Guru Project] ======" );
        testA();
    }

    public static void testA(){
        Contacto contacto = new Contacto();
        contacto.setId(1);
        contacto.setNombre("Juana");
        contacto.setApellidos("Alvirde");
        contacto.setTelefono("7332114567");
        contacto.setCorreo("juana.alvirde@hotmail.com");
        System.out.println(contacto);
    }
}


