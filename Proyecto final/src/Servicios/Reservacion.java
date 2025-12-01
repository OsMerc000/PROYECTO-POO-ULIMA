/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

/**
 *
 * @author 20240
 */
import RecursosBase.Fecha;
import Personas.Huesped;

public class Reservacion {
    private static int idGlobal = 1;
    private int id;
    private Fecha fechaInicio;
    private Fecha fechaFinal;
    private int duracion;
    private String tipoHabitacion;
    private Huesped huespedResponsable;

    //Constructor
    public Reservacion(int id, Fecha fechaInicio, Fecha fechaFinal, String tipoHabitacion, Huesped huespedResponsable) {
        this(fechaInicio, fechaFinal, tipoHabitacion, huespedResponsable);
        this.id = id;
        idGlobal -= 1;
    }
    public Reservacion(Fecha fechaInicio, Fecha fechaFinal, String tipoHabitacion, Huesped huespedResponsable) {
        if (Fecha.esAntes(fechaInicio, fechaFinal)) {
            this.fechaInicio = fechaInicio;
            this.fechaFinal = fechaFinal;
            calucularDuracion();
        } else {
            System.out.println("ERROR: La fecha inicial no puede ser antes de la fecha final");
            this.fechaInicio = new Fecha();
            this.fechaFinal = new Fecha();
            duracion = 1;
        }
        this.id = idGlobal++;
        this.tipoHabitacion = tipoHabitacion;
        this.huespedResponsable = huespedResponsable;
    }

    //Getters
    public int getID(){
        return id;
    }
    public Fecha getFechaInicio() {
        return fechaInicio;
    }
    public Fecha getFechaFinal() {
        return fechaFinal;
    }
    public int getDuracion() {
        return duracion;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public Huesped getHuespedResponsable() {
        return huespedResponsable;
    }

    //Setters
    public void setFechaInicio(Fecha fechaInicio) {
        if (Fecha.esAntes(fechaInicio, fechaFinal)) {
            this.fechaInicio = fechaInicio;
            calucularDuracion();
        } else System.out.println("ERROR: La fecha inicial no puede ser despues de la fecha final.");
    }
    public void setFechaFinal(Fecha fechaFinal) {
        if (Fecha.esAntes(fechaInicio, fechaFinal)) {
            this.fechaFinal = fechaFinal;
            calucularDuracion();
        } else System.out.println("ERROR: La fecha final no puede ser anterior a la fecha inicial.");
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public void setHuespedResponsable(Huesped huespedResponsable) {
        this.huespedResponsable = huespedResponsable;
    }

    @Override
    public String toString() {
        return "ID de la reserva: " + id
        + "\nFecha inicial: " + fechaInicio
        + "\nFecha final: " + fechaFinal
        + "\nDuracion: " + duracion
        + "\nTipo de habitacion: " + tipoHabitacion
        + "\n\nHuesped responsable:\n" + huespedResponsable;
    }

    //Metodos
    private void calucularDuracion() {
        duracion = Fecha.calcularIntervaloEntreFechas(fechaInicio, fechaFinal) + 1;
    }
}

