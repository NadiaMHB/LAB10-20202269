package org.example.lab10.dao;

import org.example.lab10.entidad.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionDao extends DaoBase {
    public ArrayList<Seleccion> listar() {
        ArrayList<Seleccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM seleccion";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt("idSeleccion"));
                seleccion.setNombre(rs.getString("nombre"));
                seleccion.setTecnico(rs.getString("tecnico"));
                seleccion.setEstadioIdEstadio(rs.getInt("estadio_idEstadio"));
                lista.add(seleccion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
