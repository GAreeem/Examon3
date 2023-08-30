
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Crear Clase</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body style="background-color: #9de0f6">
<h1>Crear Clase</h1>
<form  class="needs-validation" action="${pageContext.request.contextPath}/user/registrar-clase" novalidate method="post">
    <div class="mb-3">
        <label for="nombreClase" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombreClase" name="nombreClase">
    </div>
    <div class="mb-3">
        <label for="descripcion" class="form-label">descripcion</label>
        <input type="text" class="form-control" id="descripcion" name="descripcion">
    </div>

    <div class="input-group mb-3">
        <label class="input-group-text" for="inputGroupSelect01">Instructores</label>
        <select class="form-select" id="inputGroupSelect01" name="instructorID">
            <c:forEach var="instructor" items="${instructores}" varStatus="s">
            <option value="<c:out value="${instructor.id}"/>"><c:out value="${instructor.name}"/></option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
