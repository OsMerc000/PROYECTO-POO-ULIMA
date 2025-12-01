/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.util.ArrayList;
import Servicios.Estadia;
import Servicios.Reservacion;
import Hotel.Habitacion;
import Hotel.ServicioAdicional;

public class GestionarEstadias {


    private ArrayList<Estadia> estadiasCheckIn = new ArrayList<>();
    private ArrayList<Estadia> estadiasCheckOut = new ArrayList<>();

    public GestionarEstadias() {}


    public Estadia checkIn (Estadia estadia,
                            ArrayList<Reservacion> reservaciones,
                            ArrayList<Habitacion> habitaciones) {
        if (estadia != null) {
            if (reservaciones.contains(estadia.getReservacion()) &&
                habitaciones.contains(estadia.getHabitacion())) {

                if (estadia.getHabitacion().isDisponible() &&
                    "Limpia".equals(estadia.getHabitacion().getEstadoHabitacion())) {

                    estadiasCheckIn.add(estadia);
                    estadia.getHabitacion().setDisponible(false);
                    return estadia;
                }
            }
        }
        return null;
    }


    public Estadia checkOut (Estadia estadia, String nuevoEstadoHabitacion) {
        if (estadiasCheckIn.contains(estadia)) {
            estadiasCheckIn.remove(estadia);


            estadia.getHabitacion().setDisponible(true);
            estadia.getHabitacion().setEstadoHabitacion(nuevoEstadoHabitacion);


            estadia.setCostoServicios(calcularFacturaServicio(estadia));
            estadia.setCostoHabitacion(calcularFacturaHabitacion(estadia));
            estadia.setCostoTotal(calcularFacturaTotal(estadia));


            estadiasCheckOut.add(estadia);

            return estadia;
        }
        return null;
    }

    public ServicioAdicional registrarConsumoServicioAdicional (
            Estadia estadia,
            GestionarServiciosAdicionales serviciosAdicionales,
            ServicioAdicional servicioAdicional) {

        if (estadia != null && servicioAdicional != null) {
            if (estadiasCheckIn.contains(estadia) &&
                serviciosAdicionales.getServiciosAdicionales().contains(servicioAdicional)) {

                int index = estadiasCheckIn.indexOf(estadia);
                estadia.getConsumoServiciosAdicionales().add(servicioAdicional);
                estadiasCheckIn.set(index, estadia);
                return servicioAdicional;
            }
        }
        return null;
    }

    private float calcularFacturaServicio(Estadia estadia) {
        float ingresosServicios = 0;
        for (ServicioAdicional servicio : estadia.getConsumoServiciosAdicionales()) {
            ingresosServicios += servicio.getPrecio();
        }
        return ingresosServicios;
    }

    private float calcularFacturaHabitacion(Estadia estadia) {
        return estadia.getHabitacion().getPrecioPorNoche()* estadia.getReservacion().getDuracion();
    }

    private float calcularFacturaTotal(Estadia estadia) {
        return estadia.getCostoServicios() + estadia.getCostoHabitacion();
    }

    public ArrayList<Estadia> getEstadiasCheckIn() {
        return estadiasCheckIn;
    }

    public ArrayList<Estadia> getEstadiasCheckOut() {
        return estadiasCheckOut;
    }

    public void setEstadiasCheckIn(ArrayList<Estadia> estadiasCheckIn) {
        this.estadiasCheckIn = estadiasCheckIn;
    }

    public void setEstadiasCheckOut(ArrayList<Estadia> estadiasCheckOut) {
        this.estadiasCheckOut = estadiasCheckOut;
    }
}

