package com.example.examon3.models;

public class Clase {
    /*ClaseID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Descripcion TEXT,
    Estado VARCHAR(20),
    InstructorID INT REFERENCES Usuarios(UsuarioID)*/

    private Long claseID;
    private String nombreClase;
    private String descripcion;
    private String estado;
    private Long instructorID;

    public Clase() {
    }

    public Clase(Long claseID, String nombre, String descripcion, String estado, Long instructorID) {
        this.claseID = claseID;
        this.nombreClase = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.instructorID = instructorID;
    }

    public Long getClaseID() {
        return claseID;
    }

    public void setClaseID(Long claseID) {
        this.claseID = claseID;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Long instructorID) {
        this.instructorID = instructorID;
    }
}
