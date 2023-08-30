
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body style="background-color: #9de0f6">
<h1>Actualizar Temario</h1>
<form  class="needs-validation" action="${pageContext.request.contextPath}/clase/actualizar-temario" novalidate method="post">
    <div class="form-floating">
        <textarea class="form-control"  id="temario" style="height: 100px" name="temario"></textarea>
        <label for="temario">Temario</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>


<br><br>
<div class="col-10">
    <div class="card">
        <div class="card-header" >
            <div class="row">
                <div class="col" >Listado de usuarios en Clase</div>
            </div>
        </div>
        <table class="table table-stripped" id="userTable">
            <thead>
            <tr>
                <th>Nombre </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="s">
                <tr>
                    <td>
                        <c:out value="${user.nombre}"/>
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
