<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <jsp:include page="../../layouts/head.jsp"/>
</head>
<body style="background-color: #9de0f6">
<h1>Admin</h1>
<h2><a href="/user/cerrar-sesion"><h2>Cerrar Sesion</h2></a></h2>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <a href="/user/vista-crear-instructor" class="card-link">Registrar Instructor</a>
    </div>
</div>
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <a href="/user/vista-crear-clase" class="card-link">Registrar Clase</a>
    </div>
</div>

<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de usuarios</div>
            </div>
        </div>
        <table class="table table-stripped" id="userTable">
            <thead>
            <tr>
                <th>Nombre </th>
                <th>Acciones </th>
                <th>Rol</th>
                <th>Correo</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="s">
                <tr>
                    <td>
                        <c:out value="${user.nombre}"/>
                    </td>
                    <td>
                        <c:out value="${user.apellidos}"/>
                    </td>
                    <td>
                        <c:out value="${user.rol}"/>
                    </td>
                    <td>
                        <c:out value="${user.correo}"/>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/user/delete">
                            <input hidden value="${user.usuarioID}" name="id">
                            <button type="submit" class="btn btn-outline-danger btn-sm">
                                Eliminar
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de clases</div>
            </div>
        </div>
        <table class="table table-stripped" id="clasesTable">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="clase" items="${clases}" varStatus="a">
                <tr>
                    <td>
                        <c:out value="${clase.nombreClase}"/>
                    </td>
                    <td>
                        <c:out value="${clase.descripcion}"/>
                    </td>
                    <td>
                        <c:out value="${clase.estado}"/>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/user/delete">
                            <input hidden value="${clase.claseID}" name="id">
                            <button type="submit" class="btn btn-outline-danger btn-sm">
                                Eliminar
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
