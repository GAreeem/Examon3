package com.example.examon3.controllers;

import com.example.examon3.models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "users", urlPatterns = {
        "/user/inicio",
        "/user/inciar-sesion",
        "/user/cerrar-sesion",
        "/user/admin",
        "/user/instructor",
        "/user/usuario",
        "/user/registrar-instructor",
        "/user/registrar-clase",
        "/user/vista-crear-instructor",
        "/user/vista-crear-clase",
        "/user/registrar",
        "/user/vista-registrar"
})
public class ServletUser extends HttpServlet {
    private String action;
    private String redirect = "/user/inicio";
    HttpSession session;
    private Usuario usuario;
    private Long usuarioID, instructorID;
    private String nombre, apellidos, curp, FechaNacimiento, correo, contrasena, estado, rol, descripcion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/inicio":
                redirect = "/index.jsp";
                break;
            case "/user/admin":
                List<Usuario> users = new DaoUser().findAll();
                req.setAttribute("users", users);
                List<Clase> clases2 = new DaoClase().findAllClasesA();
                req.setAttribute("clases", clases2);
                redirect = "/views/admin/index.jsp";
                break;
            case "/user/instructor":
                HttpSession session = req.getSession();
                Usuario user = (Usuario) session.getAttribute("user");
                List<Clase> clases1 = new DaoClase().findAllClases(user.getUsuarioID());
                req.setAttribute("clases", clases1);
                redirect = "/views/instructor/index.jsp";
                break;
            case "/user/usuario":
                List<Clase> clases3 = new DaoClase().findAllClasesA();
                req.setAttribute("clases", clases3);
                redirect = "/views/usuario/index.jsp";
                break;
            case "/user/vista-crear-instructor":
                redirect = "/views/admin/instructor.jsp";
                break;
            case "/user/vista-crear-clase":
                List<Instructor> instructors = new DaoClase().findAllInstructors();
                req.setAttribute("instructores", instructors);
                redirect = "/views/admin/clase.jsp";
                break;
            case "/user/vista-registrar":
                redirect = "/views/usuario/registrarse.jsp";
                break;
            default:
                System.out.println(action);
                break;
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/user/inciar-sesion":
                correo = req.getParameter("correo");
                contrasena = req.getParameter("contra");
                try {
                    usuario = new DaoUser().inicioSesion(correo, contrasena);
                    if (usuario != null) {
                        session = req.getSession();
                        session.setAttribute("user", usuario);
                        System.out.println(session);
                        switch (usuario.getRol()) {
                            case "ADMIN_ROLE":
                                redirect = "/user/admin";
                                break;
                            case "INSTRUCTOR_ROLE":
                                redirect = "/user/instructor";
                                break;
                            case "USER_ROLE":
                                redirect = "/user/usuario";
                                break;
                        }
                    } else {
                        redirect = "/user/inicio?result=false&message=" + URLEncoder
                                .encode("Credenciales inválidas. Intenta de nuevo",
                                        StandardCharsets.UTF_8);
                    }
                } catch (Exception e) {
                    redirect = "/user/inicio?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "/user/registrar-instructor":
                nombre = req.getParameter("nombres");
                apellidos = req.getParameter("apellidos");
                curp = req.getParameter("curp");
                FechaNacimiento = req.getParameter("fecha");
                correo = req.getParameter("correo");
                contrasena = req.getParameter("contraseña");
                Usuario usuario1 = new Usuario(null, nombre, apellidos, curp, FechaNacimiento, correo, contrasena, "Activo", "INSTRUCTOR_ROLE");
                boolean result = new DaoUser().guardarInstructor(usuario1);
                if (result) {
                    redirect = "/user/admin?result=" + result + "&message=" + URLEncoder.encode("¡Exito!.", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/admin?result=" + result + "&message=" + URLEncoder.encode("Error.", StandardCharsets.UTF_8);
                }
                break;
            case "/user/registrar-clase":
                nombre = req.getParameter("nombre");
                descripcion = req.getParameter("descripcion");
                estado = "Activo";
                instructorID = Long.valueOf(req.getParameter("instructorID"));

                Clase clase = new Clase(0L,nombre,descripcion,estado,instructorID);

                boolean resultC = new DaoClase().guardarClase(clase);
                if (resultC) {
                    redirect = "/user/admin?result=" + resultC + "&message=" + URLEncoder.encode("¡Exito!.", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/admin?result=" + resultC + "&message=" + URLEncoder.encode("Error.", StandardCharsets.UTF_8);
                }
                break;
            case "/user/registrar":
                nombre = req.getParameter("nombres");
                apellidos = req.getParameter("apellidos");
                curp = req.getParameter("curp");
                FechaNacimiento = req.getParameter("fecha");
                correo = req.getParameter("correo");
                contrasena = req.getParameter("contraseña");
                Usuario usuario3 = new Usuario(null, nombre, apellidos, curp, FechaNacimiento, correo, contrasena, "Activo", "USER_ROLE");
                boolean resulR = new DaoUser().registrarse(usuario3);
                if (resulR) {
                    redirect = "/user/inicio?result=" + resulR + "&message=" + URLEncoder.encode("¡Exito!. Inicia sesion", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/inicio?result=" + resulR + "&message=" + URLEncoder.encode("Error.", StandardCharsets.UTF_8);
                }
                break;
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }

}

