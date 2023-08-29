package com.example.examon3.models;

public class Usuario {
    /*
    * UsuarioID INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellidos VARCHAR(50),
    Curp VARCHAR(18),
    FechaNacimiento DATE,
    Correo VARCHAR(100),
    Contraseña VARCHAR(100),
    Estado VARCHAR(20),
    Rol varchar(20)
    * */
    private Long usuarioID;
    private String nombre;
    private String apellidos;
    private String curp;
    private String FechaNacimiento;
    private String correo;
    private String contrasena;
    private String estado;
    private String rol;

    public Usuario() {
    }

    public Usuario(Long usuarioID, String nombre, String apellidos, String curp, String fechaNacimiento, String correo, String contrasena, String estado, String rol) {
        this.usuarioID = usuarioID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        FechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estado = estado;
        this.rol = rol;
    }

    public Long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
        this.usuarioID = usuarioID;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }



}
