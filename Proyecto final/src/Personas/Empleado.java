/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author 20240
 */
public class Empleado extends Persona {
    
    private String usuario;
    private String contrasena;
    private boolean admin;
    private int id;
    private static int idGlobal = 0;

    //Constructor
    public Empleado(int id, String dni, String nombres, String apellidos, String usuario, String contrasena, boolean admin) {
        super(dni, nombres, apellidos);
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.admin = admin;
    }
    public Empleado(String dni, String nombres, String apellidos, String usuario, String contrasena, boolean admin) {
        super(dni, nombres, apellidos);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.admin = admin;
        this.id = ++idGlobal;
    }

    //Getters
    public String getUsuario() {
        return usuario;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public boolean isAdmin() {
        return admin;
    }
    
    public int getID() {
        return id;
    }

    //Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return super.toString()
        + "\nUsuario: " + usuario
        + "\nAdmin: " + admin
        + "\nID de empleado: " + id;
    }

    public static void reducirEmpleados() {
        idGlobal -= 1;
    }
}

