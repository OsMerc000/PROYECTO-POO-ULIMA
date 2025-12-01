/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Hotel.Habitacion;
import Hotel.ServicioAdicional;

import java.util.ArrayList;

public class Estadia {
    private static int idGlobal = 1;
    private int id;
    private Reservacion reservacion;
    private Habitacion habitacion;
    private ArrayList<ServicioAdicional> consumoServiciosAdicionales = new ArrayList<ServicioAdicional>();
    private float costoTotal = 0;

    //NUEVO
    private float costoHabitacion = 0;
    private float costoServicios = 0;

    //Constructor
    public Estadia(int id, Reservacion reservacion, Habitacion habitacion) {
        this.id = id;
        this.reservacion = reservacion;
        this.habitacion = habitacion;
    }
    public Estadia(Reservacion reservacion, Habitacion habitacion) {
        this.id = idGlobal++;
        this.reservacion = reservacion;
        this.habitacion = habitacion;
    }

    //Getters
    public int getId() {
        return id;
    }
    public Reservacion getReservacion() {
        return reservacion;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
    public ArrayList<ServicioAdicional> getConsumoServiciosAdicionales() {
        return consumoServiciosAdicionales;
    }
    public float getCostoTotal() {
        return costoTotal;
    }

    //NUEVO
    public float getCostoHabitacion() {
        return costoHabitacion;
    }
    public float getCostoServicios() {
        return costoServicios;
    }

    //Setters
    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    public void setConsumoServiciosAdicionales(ArrayList<ServicioAdicional> consumoServiciosAdicionales) {
        this.consumoServiciosAdicionales = consumoServiciosAdicionales;
    }
    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    //NUEVO
    public void setCostoHabitacion(float costoHabitacion) {
        this.costoHabitacion = costoHabitacion;
    }
    public void setCostoServicios(float costoServicios) {
        this.costoServicios = costoServicios;
    }

    @Override
    public String toString() {
        return "ID de la estadia: " + id
            + "\n\nReservacion asociada:\n" + reservacion
            + "\n\nHabitacion asociada:\n" + habitacion
            + "\n\nServicios adicionales consumidos:\n" + consumoServiciosAdicionales
            + "\n\nCosto habitación: " + costoHabitacion
            + "\nCosto servicios: " + costoServicios
            + "\nCosto total: " + costoTotal;
    }


}


