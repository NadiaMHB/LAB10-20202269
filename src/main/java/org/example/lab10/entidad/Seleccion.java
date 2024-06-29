package org.example.lab10.entidad;

public class Seleccion {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private int estadioIdEstadio;

    // Getters and setters
    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getEstadioIdEstadio() {
        return estadioIdEstadio;
    }

    public void setEstadioIdEstadio(int estadioIdEstadio) {
        this.estadioIdEstadio = estadioIdEstadio;
    }
}
