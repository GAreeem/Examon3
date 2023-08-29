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

public class DaoClase {
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

    public boolean guardarClase(Clase clase) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO clases VALUES(0,?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,clase.getNombreClase());
            pstm.setString(2,clase.getDescripcion());
            pstm.setString(3,clase.getEstado());
            pstm.setLong(4,clase.getInstructorID());
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    public List<Instructor> findAllInstructors() {
        List<Instructor> instructor = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT UsuarioID, Nombre from usuarios where Rol='INSTRUCTOR_ROLE';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Instructor ins = new Instructor();
                ins.setId(rs.getLong("UsuarioID"));
                ins.setName(rs.getString("Nombre"));
                instructor.add(ins);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return instructor;
    }

    public List<Clase> findAllClases(Long usuarioID) {
        List<Clase> clases = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from clases where InstructorID= ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,usuarioID);
            rs = pstm.executeQuery();
            while (rs.next()){
                Clase clase = new Clase();
                clase.setClaseID(rs.getLong("ClaseID"));
                clase.setNombreClase(rs.getString("Nombre"));
                clase.setDescripcion(rs.getString("Descripcion"));
                clase.setEstado(rs.getString("Estado"));
                clases.add(clase);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return clases;

    }

    public List<Clase> findAllClasesA() {
        List<Clase> clases = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from clases;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Clase clase = new Clase();
                clase.setClaseID(rs.getLong("ClaseID"));
                clase.setNombreClase(rs.getString("Nombre"));
                clase.setDescripcion(rs.getString("Descripcion"));
                clase.setEstado(rs.getString("Estado"));
                clases.add(clase);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return clases;
    }

    public List<Usuario> findUsersClases(Long idClase) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT U.Nombre AS NombreUsuario FROM Usuarios U " +
                    "JOIN Inscripciones I ON U.UsuarioID = I.UsuarioID WHERE I.ClaseID = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,idClase);
            rs = pstm.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("NombreUsuario"));
                usuarios.add(usuario);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return usuarios;
    }

    public boolean actualizarTemario(String descripcion) {

        return false;
    }

    public boolean registrarse(Long idClase, Long usuarioID) {
        /*
        InscripcionID INT PRIMARY KEY auto_increment,
        UsuarioID INT REFERENCES Usuarios(UsuarioID),
        ClaseID INT REFERENCES Clases(ClaseID)
        */
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO usuarios VALUES (0,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,usuarioID);
            pstm.setLong(2,idClase);
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }
}
