package org.iesvdm.jsp_servlet_jdbc.model;

import java.util.Objects;

/**
 * POJO o BEAN QUE REPRESENTA LA TABLA socio
 */
public class Socio {

    private int socioId;
    private String nombre;
    private int estatura;
    private int edad;
    private String localidad;

    public Socio() {
    }

    public Socio(int socioId, String nombre, int estatura, int edad, String localidad) {
        this.socioId = socioId;
        this.nombre = nombre;
        this.estatura = estatura;
        this.edad = edad;
        this.localidad = localidad;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return socioId == socio.socioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socioId);
    }

    @Override
    public String toString() {
        return "Socio{" +
                "socioId=" + socioId +
                ", nombre='" + nombre + '\'' +
                ", estatura=" + estatura +
                ", edad=" + edad +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
