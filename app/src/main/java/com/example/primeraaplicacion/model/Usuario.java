package com.example.primeraaplicacion.model;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    public Usuario(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
