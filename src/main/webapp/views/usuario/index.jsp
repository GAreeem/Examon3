<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<br><br>
<h2><a href="/user/cerrar-sesion"><h2>Cerrar Sesion</h2></a></h2>
<br>
<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de Clases</div>
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
                        <form method="post" action="${pageContext.request.contextPath}/clase/registrarse">
                            <input hidden value="${clase.claseID}" name="id">
                            <button type="submit" class="btn btn-outline-danger btn-sm">
                                Registrarse
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<h1>Clases Registradas</h1>
<c:forEach var="clase2" items="${clases2}" varStatus="b">
     <h2>${b.count}><c:out value="${clase2.nombreClase}"/></h2>
</c:forEach>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
