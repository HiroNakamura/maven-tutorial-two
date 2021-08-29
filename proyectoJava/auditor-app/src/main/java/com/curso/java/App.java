package com.curso.java;

public class App {
    public static void main(String[] args){
        if(args.length > 0){
            for(String arg: args){
                System.out.println("Hola, "+arg);
            }
        }
    }
}
