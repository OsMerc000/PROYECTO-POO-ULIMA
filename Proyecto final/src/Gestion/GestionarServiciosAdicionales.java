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
import Hotel.ServicioAdicional;
import Personas.Administrador;

public class GestionarServiciosAdicionales implements Administrador<ServicioAdicional> {
    ArrayList<ServicioAdicional> serviciosAdicionales = new ArrayList<ServicioAdicional>();

    public GestionarServiciosAdicionales() {}

    @Override
    public ServicioAdicional agregar(ServicioAdicional servicioAdicional) {
        if (servicioAdicional != null) {
            serviciosAdicionales.add(servicioAdicional);
            return servicioAdicional;
        }
        return null;
    }

    @Override
    public ServicioAdicional modificar(ServicioAdicional servicioAdicional) {
        for (int i = 0; i < serviciosAdicionales.size(); i++) {
        if (serviciosAdicionales.get(i).getID() == servicioAdicional.getID()) {
            serviciosAdicionales.set(i, servicioAdicional);
            return servicioAdicional;
        }
    }
    return null;
    }

    @Override
    public void remover(ServicioAdicional servicioAdicional) {
        if (serviciosAdicionales.contains(servicioAdicional)) {
            serviciosAdicionales.remove(servicioAdicional);
        }
    }

    public ArrayList<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(ArrayList<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
}

