<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<h1>Instructor</h1>
<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de usuarios</div>
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
                        <form method="get" action="${pageContext.request.contextPath}/clase/temario">
                            <input hidden value="${clase.claseID}" name="id">
                            <button type="submit" class="btn btn-outline-warning btn-sm">
                                Informacion
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
