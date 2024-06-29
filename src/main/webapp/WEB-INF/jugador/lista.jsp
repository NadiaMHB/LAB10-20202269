
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.lab10.entidad.Jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" scope="request" type="ArrayList<Jugador>" />
<html>
<head>
    <title>Lista Jugadores</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="clearfix mt-3 mt-2">
        <a href="<%=request.getContextPath()%>/jugador">
            <h1 class="float-start link-dark">Lista de Jugadores</h1>
        </a>
        <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/jugador/nuevo">Nuevo Jugador</a>
    </div>
    <hr/>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>#</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Posición</th>
            <th>Club</th>
            <th>Selección</th>
            <th></th>
        </tr>
        <% for (Jugador jugador : lista) { %>
        <tr>
            <td><%=jugador.getIdJugador()  %>
            </td>
            <td><%=jugador.getNombre()  %>
            </td>
            <td><%=jugador.getEdad()%>
            </td>
            <td><%=jugador.getPosicion()%>
            </td>
            <td><%=jugador.getClub()%>
            </td>
            <td><%=jugador.getSeleccion()%>
            </td>
            <td><a onclick="return confirm('¿Esta seguro de borrar?')" class="btn btn-danger" href="<%=request.getContextPath()%>/jugador/del?id=<%= jugador.getIdJugador() %>">Borrar</a></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
