/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author 20240
 */
import java.util.ArrayList;
import Hotel.Habitacion;
import Personas.Administrador;

public class GestionarHabitaciones implements Administrador<Habitacion> {
    private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();

    public GestionarHabitaciones() {}

    @Override
    public Habitacion agregar(Habitacion habitacion) {
        if (habitacion != null && validarNumHabitacion(habitacion)) {
            habitaciones.add(habitacion);
            return habitacion;
        }
        return null;
    }

    @Override
    public Habitacion modificar(Habitacion habitacion) {
        for (int i = 0; i < habitaciones.size(); i++) {
        if (habitaciones.get(i).getNumero() == habitacion.getNumero()) {
            habitaciones.set(i, habitacion);
            return habitacion;
        }
    }
    return null;
    }

    @Override
    public void remover(Habitacion habitacion) {
        if (habitaciones.contains(habitacion)) {
            habitaciones.remove(habitacion);
        }
    }
    
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    private boolean validarNumHabitacion(Habitacion habitacion) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero() == habitacion.getNumero()) {
                return false;
            }
        }
        return true;
    }
}

