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
import Servicios.Reservacion;
import Hotel.Habitacion;
import Personas.Recepcionista;
import RecursosBase.Fecha;

public class GestionarReservaciones implements Recepcionista<Reservacion> {
    private ArrayList<Reservacion> reservaciones = new ArrayList<Reservacion>();

    public GestionarReservaciones() {}

    @Override
    public Reservacion registrar(Reservacion reservacion) {
        if (reservacion != null) {
            if (validarReservacion(reservacion)) {
                reservaciones.add(reservacion);
                return reservacion;
            }
        }
        return null;
    }

    @Override
    public Reservacion modificar(Reservacion reservacion) {
        if (!validarReservacion(reservacion)) {
            return null;
        }
        for (Reservacion rsrv : reservaciones) {
            if (rsrv.getID() == reservacion.getID()) {
                rsrv = reservacion;
                return reservacion;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Reservacion reservacion) {
        if (reservaciones.contains(reservacion)) {
            reservaciones.remove(reservacion);
        }
    }
    
    private boolean validarReservacion(Reservacion reservacion) {
        int numMismoTipoHabitacionOcupado = 0;

        for (Reservacion r : reservaciones) {
            if (!(Fecha.esAntes(r.getFechaFinal(), reservacion.getFechaInicio())
                || Fecha.esDespues(r.getFechaInicio(), reservacion.getFechaFinal()))) {

                if (r.getTipoHabitacion().equals(reservacion.getTipoHabitacion())) {
                    numMismoTipoHabitacionOcupado += 1;
                }
            }
        }

        if (reservacion.getTipoHabitacion().equals("Simple")) {
            return numMismoTipoHabitacionOcupado < Habitacion.getNumSimple();
        } else if (reservacion.getTipoHabitacion().equals("Doble")) {
            return numMismoTipoHabitacionOcupado < Habitacion.getNumDoble();
        } else if (reservacion.getTipoHabitacion().equals("Suite")) {
            return numMismoTipoHabitacionOcupado < Habitacion.getNumSuite();
        }
        return false;
    }

    public ArrayList<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(ArrayList<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
    }
}
