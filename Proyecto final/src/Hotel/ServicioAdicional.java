/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author 20240
 */
public class ServicioAdicional {
    private int id;
    private static int idGlobal;
    private String nombre;
    private float precio;

    //Constructor
    public ServicioAdicional(int id, String nombre, float precio) {
        this.nombre = nombre;
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("ERROR: El precio no puede ser negativo.");
            this.precio = 0;
        }
        this.id = id;
    }
    public ServicioAdicional(String nombre, float precio) {
        this.nombre = nombre;
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("ERROR: El precio no puede ser negativo.");
            this.precio = 0;
        }
        id = ++idGlobal;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }   
    public float getPrecio() {
        return precio;
    }
    public int getID() {
        return id;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(float precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id
        + "\nNombre: " + nombre
        + "\nPrecio: " + precio;
    }
}
