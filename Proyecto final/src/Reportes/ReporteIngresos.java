/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import Gestion.GestionarEstadias;
import RecursosBase.Fecha;
import Servicios.Estadia;

public class ReporteIngresos {
    private float ingresosTotales = 0;
    private float ingresosHabitaciones = 0;
    private float ingresosServicios = 0;
    
    public ReporteIngresos(GestionarEstadias gestion, Fecha fechaInicio, Fecha fechaFinal) {
        for (Estadia estadia : gestion.getEstadiasCheckOut()) {
            if (!(Fecha.esAntes(estadia.getReservacion().getFechaInicio(), fechaInicio)) &&
                !(Fecha.esDespues(estadia.getReservacion().getFechaFinal(), fechaFinal))) {
                    ingresosHabitaciones += estadia.getCostoHabitacion();
                    ingresosServicios += estadia.getCostoServicios();
            }
        }
        ingresosTotales = ingresosHabitaciones + ingresosServicios;
    }


    public String detallarIngresos() {
        return "Los ingresos generados por mi hotel fueron:\n"
        + "\nIngresos por habitaciones: " + ingresosHabitaciones
        + "\nIngresos por servicios: " + ingresosServicios
        + "\nIngresos totales: " + ingresosTotales;
    }
}
