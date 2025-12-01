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
import Personas.Huesped;
import Personas.Recepcionista;

public class GestionarHuespedes implements Recepcionista<Huesped> {
    private ArrayList<Huesped> huespedes = new ArrayList<Huesped>();

    public GestionarHuespedes() {}

    @Override
    public Huesped registrar(Huesped huesped) {
        if (huesped != null) {
            huespedes.add(huesped);
            return huesped;
        }
        return null;
    }

    @Override
    public Huesped modificar(Huesped huesped) {
        for (int i = 0; i < huespedes.size(); i++) {
                if (huespedes.get(i).getID() == huesped.getID()) {
                huespedes.set(i, huesped);  // aquí SÍ reemplazas en la lista
                return huesped;
            }
        }
        return null;
}

    @Override
    public void eliminar(Huesped huesped) {
        if (huespedes.contains(huesped)) {
            huespedes.remove(huesped);
        }
    }
    
    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(ArrayList<Huesped> huespedes) {
        this.huespedes = huespedes;
    }
}

