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
import Personas.Administrador;
import Personas.Empleado;

public class GestionarEmpleados implements Administrador<Empleado> {
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    public GestionarEmpleados() {}

    @Override
    public Empleado agregar(Empleado empleado) {
        if (empleado != null) {
            empleados.add(empleado);
            return empleado;
        }
        return null;
    }

    @Override
    public Empleado modificar(Empleado empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getID() == empleado.getID()) {
            empleados.set(i, empleado);
            return empleado;
            }
        }
        return null;
    }

    @Override
    public void remover(Empleado empleado) {
        if (empleados.contains(empleado)) {
            empleados.remove(empleado);
            Empleado.reducirEmpleados();
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
