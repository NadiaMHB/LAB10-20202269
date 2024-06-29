<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Inicio</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">

</head>
<body>
<div class="container mt-5">
  <div class="jumbotron">
    <h1 class="display-4">Bienvenido al portal de las Clasificatorias Sudamericanas Mundial 2026</h1>
    <p class="lead">Aquí gestionar la información de los jugadores y estadios.</p>
    <hr class="my-4">
    <p>Accede a las secciones de Jugadores y Estadios.</p>
    <a class="btn btn-primary btn-lg" href="<%= request.getContextPath() %>/jugador" role="button">Ir a Jugadores</a>
    <a class="btn btn-secondary btn-lg" href="<%= request.getContextPath() %>/estadio" role="button">Ir a Estadios</a>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qthANUFyzK+TcPfd+JkQQk3+8xIu14BB2CjZIG5R7HEGm5r51LFI1Az+Z2heQyzj" crossorigin="anonymous"></script>
</body>
</html>
