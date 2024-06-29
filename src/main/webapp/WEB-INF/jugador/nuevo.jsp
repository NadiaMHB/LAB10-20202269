<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.lab10.entidad.Seleccion" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Jugador</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1>Nuevo Jugador</h1>
    <form action="<%= request.getContextPath() %>/jugador/nuevo" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="mb-3">
            <label for="edad" class="form-label">Edad</label>
            <input type="number" class="form-control" id="edad" name="edad" min="0" max="150" required>
        </div>
        <div class="mb-3">
            <label for="posicion" class="form-label">Posición</label>
            <input type="text" class="form-control" id="posicion" name="posicion" required>
        </div>
        <div class="mb-3">
            <label for="club" class="form-label">Club</label>
            <input type="text" class="form-control" id="club" name="club" required>
        </div>
        <div class="mb-3">
            <label for="seleccion" class="form-label">Selección</label>
            <select class="form-control" id="seleccion" name="seleccion" required>
                <option value="">Seleccione una selección</option>
                <%
                    ArrayList<Seleccion> selecciones = (ArrayList<Seleccion>) request.getAttribute("selecciones");
                    for (Seleccion seleccion : selecciones) {
                %>
                <option value="<%= seleccion.getIdSeleccion() %>"><%= seleccion.getNombre() %></option>
                <%
                    }
                %>
            </select>
        </div>
        <a href="<%=request.getContextPath()%>/jugador" class="btn btn-danger">Regresar</a>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>
</body>
</html>
