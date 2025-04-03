/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Huesped;

/**
 *
 * @author braya
 */
public class HuespedModelo {
  private int codigo;  // Nuevo atributo para el código del huésped
    private String nombre;
    private String correo;
    private String telefono;

    // Constructor
    public HuespedModelo(int codigo, String nombre, String correo, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Constructor sin código, para crear un huésped nuevo
    public HuespedModelo(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "HuespedModelo{" +
                "codigo=" + codigo +  // Ahora muestra el código
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
