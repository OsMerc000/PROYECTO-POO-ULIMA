/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author 20240
 */
import Personas.Empleado;
import java.util.ArrayList;

public class Autenticacion {
    public Autenticacion() {}

    public Empleado login(ArrayList<Empleado> empleados, String usuario, String contrasena) {
        for (Empleado empleado : empleados) {
            if (empleado.getUsuario().equals(usuario) && empleado.getContrasena().equals(contrasena)) {
                return empleado;
            }
        }
        return null;
    }
}

