<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
