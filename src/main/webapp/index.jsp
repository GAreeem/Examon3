<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Examon3</title>
    <jsp:include page="/layouts/head.jsp"/>
</head>
<body>

<div class="container  mt-5 centrado align-items-stretch">
    <div class="col-4">
        <div class="card">
            <div class="card-header">
                <h5 > Inicio de sesión </h5>
            </div>
            <div class="card-body">

                <form class="needs-validation" id="loginForm" action="${pageContext.request.contextPath}/user/inciar-sesion" novalidate method="post">
                    <tr >
                        <th>
                            <div class="form-outline">
                                <label class="form-label" for="correo">Usuario</label>
                                <input id="correo" name="correo" type="text" class="form-control"  required>
                                <div class="invalid-feedback">
                                    Campo obligatorio
                                </div>
                            </div>

                            <div class="form-outline">
                                <label class="form-label" for="contra">Contraseña</label>
                                <input id="contra" name="contra"  type="password" class="form-control"  required >
                                <div class="invalid-feedback">
                                    Campo obligatorio
                                </div>
                            </div>
                        </th>
                    </tr>
                    <div class="card-footer">
                        <div class="d-grid">
                            <button id="login" type="submit" class="btn btn-primary btn-block" value="login" >
                                <i data-feather="log-in"></i> Iniciar sesión
                            </button>
                        </div>
                    </div>
                </form>
                <a href="/user/vista-registrar"><h2>Registrarse</h2></a>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>