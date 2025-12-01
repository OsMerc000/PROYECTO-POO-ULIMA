/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import Gestion.GestionarHabitaciones;
import java.util.ArrayList;
import Hotel.Habitacion;

public class ReporteOcupacionHabitaciones {
    private int numHabitacionesOcupadas = 0;
    private int numHabitacionesLibres = 0;
    private String detallesHabitacionesOcupadas = "";
    private String detallesHabitacionesLibres = "";

    public ReporteOcupacionHabitaciones(GestionarHabitaciones gestion) {
        obtenerDetallesHabitaciones(gestion.getHabitaciones());
    }
    
    private void obtenerDetallesHabitaciones(ArrayList<Habitacion> habitaciones) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                numHabitacionesLibres += 1;
                detallesHabitacionesLibres += "\n" + habitacion + "\n";
            } else {
                numHabitacionesOcupadas += 1;
                detallesHabitacionesOcupadas += "\n" + habitacion + "\n";
            }
        }
    }

    public String resumenOcupacion() {
        return "La disponibilidad de las habitaciones es:"
        + "\n\nHabitaciones disponibles: " + numHabitacionesLibres
        + "\nHabitaciones ocupadas: " + numHabitacionesOcupadas;
    }

    public String detallesOcupacion() {
        return "Las habitaciones disponibles son:\n" + detallesHabitacionesLibres
        + "\nLas habitaciones ocupadas son:\n" + detallesHabitacionesOcupadas;
    }
}

