
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Examon3</title>
  <jsp:include page="/layouts/head.jsp"/>
</head>
<body style="background-color: #9de0f6">
<div class="container  mt-5 centrado align-items-stretch">
  <div class="col-4">
    <div class="card">
      <div class="card-header">
        <h5 > Registro </h5>
      </div>
      <div class="card-body">

        <form class="needs-validation" id="loginForm" action="${pageContext.request.contextPath}/user/registrar" novalidate method="post">
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
            <div class="d-grid">
              <button id="login" type="submit" class="btn btn-primary btn-block" value="login" >
                <i data-feather="log-in"></i> Registrarse
              </button>
            </div>
        </form>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
