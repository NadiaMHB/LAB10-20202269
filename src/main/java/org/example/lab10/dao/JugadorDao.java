package org.example.lab10.dao;

import org.example.lab10.entidad.Jugador;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDao extends DaoBase {
    public ArrayList<Jugador> listar() {
        ArrayList<Jugador> lista = new ArrayList<>();
        String sql = "SELECT * FROM jugador";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugador jugadorP = new Jugador();
                jugadorP.setIdJugador(rs.getInt("idJugador"));
                jugadorP.setNombre(rs.getString("nombre"));
                jugadorP.setEdad(rs.getInt("edad"));
                jugadorP.setPosicion(rs.getString("posicion"));
                jugadorP.setClub(rs.getString("club"));
                jugadorP.setSeleccion(rs.getInt("sn_idSeleccion"));
                lista.add(jugadorP);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Jugador buscarPorId(String idJugador) {
        Jugador jugador = null;
        String sql = "SELECT * FROM jugador WHERE idJugador = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idJugador);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    jugador = new Jugador();
                    jugador.setIdJugador(rs.getInt("idJugador"));
                    jugador.setNombre(rs.getString("nombre"));
                    jugador.setEdad(rs.getInt("edad"));
                    jugador.setPosicion(rs.getString("posicion"));
                    jugador.setClub(rs.getString("club"));
                    jugador.setSeleccion(rs.getInt("sn_idSeleccion"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jugador;
    }
    public void crear(String idJugador, String nombre, int edad, String posicion, String club, int sn_idSeleccion){

        String sql = "insert into jugador (nombre, edad,posicion, club, sn_idSeleccion) values (?,?,?,?,?)";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,nombre);
            pstmt.setInt(2,edad);
            pstmt.setString(3,posicion);
            pstmt.setString(4,club);
            pstmt.setInt(5,sn_idSeleccion);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrar(String idJugador) throws SQLException {

        String sql = "delete from jugador where idJugador = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,idJugador);
            pstmt.executeUpdate();

        }
    }

}
