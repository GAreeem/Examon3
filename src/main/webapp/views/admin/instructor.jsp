
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Instructor</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<h1>Crear instructor</h1>
<form  class="needs-validation" action="${pageContext.request.contextPath}/user/registrar-instructor" novalidate method="post">
    <div class="mb-3">
        <label for="nombres" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombres" name="nombres">
    </div>
    <div class="mb-3">
        <label for="apellidos" class="form-label">apellidos</label>
        <input type="text" class="form-control" id="apellidos" name="apellidos">
    </div>
    <div class="mb-3">
        <label for="curp" class="form-label">Curp</label>
        <input type="text" class="form-control" id="curp" name="curp">
    </div>
    <div class="mb-3">
        <label for="fecha" class="form-label">Fecha Nacimiento</label>
        <input type="date" class="form-control" id="fecha" name="fecha">
    </div>
    <div class="mb-3">
        <label for="correo" class="form-label">Correo</label>
        <input type="text" class="form-control" id="correo" name="correo">
    </div>
    <div class="mb-3">
        <label for="contraseña" class="form-label">contraseña</label>
        <input type="text" class="form-control" id="contraseña" name="contraseña">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
