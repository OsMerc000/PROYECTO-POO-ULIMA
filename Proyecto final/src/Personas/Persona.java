/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author 20240
 */
public abstract class Persona {
    protected String dni;
    protected String nombres;
    protected String apellidos;

    //Constructor
    public Persona(String dni, String nombres, String apellidos) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    //Getters
    public String getDNI() {
        return dni;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    
    //Setters
    public void setDNI(String dni) {
        this.dni = dni;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "DNI: " + dni
        + "\nNombres: " + nombres
        + "\nApellidos: " + apellidos;
    }
}

