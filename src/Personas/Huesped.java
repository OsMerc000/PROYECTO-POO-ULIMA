/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author 20240
 */
public class Huesped extends Persona {
    private String contacto;
    private int id;
    private static int idGlobal = 0;

    //Constructor
    public Huesped(int id, String dni, String nombres, String apellidos, String contacto) {
        super(dni, nombres, apellidos);
        this.contacto = contacto;
        this.id = id;
    }
    public Huesped(String dni, String nombres, String apellidos, String contacto) {
        super(dni, nombres, apellidos);
        this.contacto = contacto;
        this.id = ++idGlobal;
    }

    //Getters
    public String getContacto() {
        return contacto;
    }

    public int getID() {
        return id;
    }

    //Setters
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return super.toString()
        + "\nContacto: " + contacto
        + "\nID de huesped: " + id;
    }

    public static void reducirHuespedes() {
        idGlobal -= 1;
    }
}
