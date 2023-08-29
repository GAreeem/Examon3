package com.example.examon3.models;

import com.example.examon3.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;




    public void close(){
        try {
            if(conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        }catch (SQLException e){

        }

    }

    public Usuario inicioSesion(String correo, String contrasena) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM Usuarios " +
                    "WHERE Correo = ? AND Contraseña = ? AND Estado='Activo';";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, correo);
            pstm.setString(2,contrasena);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioID(rs.getLong("UsuarioID"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCurp(rs.getString("Curp"));
                usuario.setFechaNacimiento(rs.getString("FechaNacimiento"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setEstado(rs.getString("Estado"));
                usuario.setRol(rs.getString("Rol"));
                return usuario;
            }

        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,
                            "Credentials mismatch: " + e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public boolean guardarInstructor(Usuario usuario1) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO usuarios VALUES(0,?,?,?,?,?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,usuario1.getNombre());
            pstm.setString(2,usuario1.getApellidos());
            pstm.setString(3,usuario1.getCurp());
            pstm.setString(4,usuario1.getFechaNacimiento());
            pstm.setString(5,usuario1.getCorreo());
            pstm.setString(6,usuario1.getContrasena());
            pstm.setString(7,usuario1.getEstado());
            pstm.setString(8,usuario1.getRol());
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from usuarios;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setUsuarioID(rs.getLong("UsuarioID"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCurp(rs.getString("Curp"));
                usuario.setFechaNacimiento(rs.getString("FechaNacimiento"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setContrasena(rs.getString("Contraseña"));
                usuario.setEstado(rs.getString("Estado"));
                usuario.setRol(rs.getString("Rol"));
                usuarios.add(usuario);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return usuarios;
    }

    public boolean registrarse(Usuario usuario2) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO usuarios VALUES(0,?,?,?,?,?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,usuario2.getNombre());
            pstm.setString(2,usuario2.getApellidos());
            pstm.setString(3,usuario2.getCurp());
            pstm.setString(4,usuario2.getFechaNacimiento());
            pstm.setString(5,usuario2.getCorreo());
            pstm.setString(6,usuario2.getContrasena());
            pstm.setString(7,usuario2.getEstado());
            pstm.setString(8,usuario2.getRol());
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }


}
