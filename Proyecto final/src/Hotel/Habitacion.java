/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

/**
 *
 * @author 20240
 */
public class Habitacion {
    private static int numSimple = 0;
    private static int numDoble = 0;
    private static int numSuite = 0;
    private int numero;
    private int capacidadMAX;
    private float precioPorNoche;
    private String tipoHabitacion;
    private String estadoHabitacion;
    private boolean disponible;

    //Constructor
    public Habitacion(int numero, int capacidadMAX, float precioPorNoche, String tipoHabitacion,
            String estadoHabitacion) {
        this.numero = numero;
        if (capacidadMAX > 0) {
            this.capacidadMAX = capacidadMAX;
        } else {
            System.out.println("ERROR: La capacidad maxima debe ser positiva.");
            this.capacidadMAX = 1;
        }
        if (precioPorNoche >= 0) {
            this.precioPorNoche = precioPorNoche;
        } else {
            System.out.println("ERROR: El precio por noche no puede ser negativo.");
            this.precioPorNoche = 0;
        }
        this.tipoHabitacion = tipoHabitacion;
        if (tipoHabitacion.equals("Simple")) {
            numSimple += 1;
        } else if (tipoHabitacion.equals("Doble")) {
            numDoble += 1;
        } else if (tipoHabitacion.equals("Suite")) {
            numSuite += 1;
        } else {
            System.out.println("ERROR: Dicho tipo de habitacion no existe.");
            this.tipoHabitacion = "Simple";
        }
        this.estadoHabitacion = estadoHabitacion;
        disponible = true;
    }

    //Getters
    public int getNumero() {
        return numero;
    }
    public int getCapacidadMAX() {
        return capacidadMAX;
    }
    public float getPrecioPorNoche() {
        return precioPorNoche;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }
    public static int getNumSimple() {
        return numSimple;
    }
    public static int getNumDoble() {
        return numDoble;
    }
    public static int getNumSuite() {
        return numSuite;
    }
    public boolean isDisponible() {
        return disponible;
    }

    //Setters
    public void setCapacidadMAX(int capacidadMAX) {
        if (capacidadMAX > 0) {
            this.capacidadMAX = capacidadMAX;
        }
    }
    public void setPrecioPorNoche(float precioPorNoche) {
        if (precioPorNoche >= 0) {
            this.precioPorNoche = precioPorNoche;
        }
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Numero de habitacion: " + numero
        + "\nCapacidad maxima: " + capacidadMAX
        + "\nPrecio por noche: " + precioPorNoche
        + "\nTipo de habitacion: " + tipoHabitacion
        + "\nEstado de la habitacion: " + estadoHabitacion
        + "\nDisponibilidad: " + disponible;
    }

    //Metodos
    public static void reducirNumeroDeTipoHabitacion(String tipoHabitacion) {
        if (tipoHabitacion.equals("Simple")) {
            numSimple -= 1;
        } else if (tipoHabitacion.equals("Doble")) {
            numDoble -= 1;
        } else if (tipoHabitacion.equals("Suite")) {
            numSuite -= 1;
        } else {
            System.out.println("ERROR: Dicho tipo de habitacion no existe.");
        }
    }
}

