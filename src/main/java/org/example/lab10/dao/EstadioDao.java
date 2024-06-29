package org.example.lab10.dao;

import org.example.lab10.entidad.Estadio;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDao extends DaoBase {
    public ArrayList<Estadio> listar() {
        ArrayList<Estadio> lista = new ArrayList<>();
        String sql = "SELECT * FROM estadio";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("idEstadio"));
                estadio.setNombre(rs.getString("nombre"));
                estadio.setProvincia(rs.getString("provincia"));
                estadio.setClub(rs.getString("club"));
                lista.add(estadio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public Estadio buscarPorIdEstadio(String idEstadio) {
        Estadio estadio = null;
        String sql = "SELECT * FROM estadio WHERE idEstadio = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idEstadio);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    estadio = new Estadio();
                    estadio.setIdEstadio(rs.getInt("idEstadio"));
                    estadio.setNombre(rs.getString("nombre"));
                    estadio.setProvincia(rs.getString("provincia"));
                    estadio.setClub(rs.getString("club"));


                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estadio;
    }

    public void crearEstadio(String idEstadio, String nombre, String provincia, String club){

        String sql = "insert into estadio (nombre,provincia,club) values (?,?,?)";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,nombre);
            pstmt.setString(2,provincia);
            pstmt.setString(3,club);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarEstadio(String idEstadio) throws SQLException {

        String sql = "delete from estadio where idEstadio = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,idEstadio);
            pstmt.executeUpdate();

        }
    }
}
