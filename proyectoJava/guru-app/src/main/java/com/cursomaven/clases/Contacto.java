package com.cursomaven.clases;

import java.io.Serializable;

public class Contacto implements Serializable{

    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contacto{");
        sb.append("id: ");
        sb.append(id);
        sb.append(", nombre: ");
        sb.append(", apellidos: ");
        sb.append(apellidos);
        sb.append(", telefono: ");
        sb.append(telefono);
        sb.append(", correo: ");
        sb.append(correo);
        sb.append("}");
        return sb.toString();
    }

}