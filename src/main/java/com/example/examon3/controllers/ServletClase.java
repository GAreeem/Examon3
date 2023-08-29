package com.example.examon3.controllers;

import com.example.examon3.models.DaoClase;
import com.example.examon3.models.DaoUser;
import com.example.examon3.models.Usuario;
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


@WebServlet(name = "clase", urlPatterns = {
        "/clase/temario",
        "/clase/actualizar-temario",
        "/clase/registrarse"
})
public class ServletClase extends HttpServlet {

    private String action;
    private String redirect = "/user/instructor";
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/clase/temario":
                Long id_clase = Long.valueOf(req.getParameter("id"));
                List<Usuario> users = new DaoClase().findUsersClases(id_clase);
                req.setAttribute("users", users);
                redirect = "/views/instructor/temario.jsp";
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
            case "/clase/actualizar-temario":
                String descripcion = req.getParameter("temario");
                boolean resulT = new DaoClase().actualizarTemario(descripcion);
                if (resulT){
                    redirect = "/clase/temario";
                }else {
                    redirect = "/clase/temario";
                }
                break;
            case "/clase/registrarse":
                Long id_clase = Long.valueOf(req.getParameter("id"));
                HttpSession session = req.getSession();
                Usuario user = (Usuario) session.getAttribute("user");
                boolean resultR = new DaoClase().registrarse(id_clase,user.getUsuarioID());
                if (resultR){
                    redirect = "/user/usuario?result=false&message=" + URLEncoder
                            .encode("Registrado en clase",
                                    StandardCharsets.UTF_8);
                }else {
                    redirect = "/user/usuario?result=false&message=" + URLEncoder
                            .encode("Error en registrarse en clase",
                                    StandardCharsets.UTF_8);
                }
                break;
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }
}
