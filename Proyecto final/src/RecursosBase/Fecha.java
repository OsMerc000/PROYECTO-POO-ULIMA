/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecursosBase;

/**
 *
 * @author 20240
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    //Constructores
    public Fecha() {
        dia = 1;
        mes = 1;
        anio = 1;
    }
    public Fecha(int dia, int mes, int anio) {
        if (verificarFecha(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.anio = 1;
        }
    }

    //Metodos para verificar la fecha
    private boolean verificarFecha(int dia, int mes, int anio) {
        return verificarAnio(anio) && verificarMes(mes) && verificarDia(dia, mes, anio);
    }
    private boolean verificarAnio(int anio) {
        return anio > 0;
    }
    private boolean verificarMes(int mes) {
        return mes > 0 && mes <= 12;
    }
    private boolean verificarDia(int dia, int mes, int anio) {
        if (dia <= 0) {
            return false;
        }
        if (mes == 2) {
            return verificarFebrero(dia, anio);
        }
        if (mes <= 7) {
            if (mes % 2 == 1) {
                return dia <= 31;
            } else return dia <= 30;
        } else {
            if (mes % 2 == 1) {
                return dia <= 30;
            } else return dia <= 31;
        }
    }
    private boolean verificarFebrero(int dia, int anio) {
        if (anio % 4 == 0) {
            return dia <= 29;
        } else {
            return dia <= 28;
        }
    }

    //Getters
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }

    //Setters
    public void setDia(int dia) {
        if (verificarDia(dia, this.mes, this.anio)) {
            this.dia = dia;
        }
    }
    public void setMes(int mes) {
        if (verificarMes(mes)) {
            this.mes = mes;
        }
    }
    public void setAnio(int anio) {
        if (verificarAnio(anio)) {
            this.anio = anio;
        }
    }

    //Metodos

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    //Metodos booleanos
    public static boolean esAntes(Fecha primeraFecha, Fecha segundaFecha) {
        if (primeraFecha.getAnio() < segundaFecha.getAnio()) {
            return true;
        } else if (primeraFecha.getAnio() > segundaFecha.getAnio()) {
            return false;
        } else {
            if (primeraFecha.getMes() < segundaFecha.getMes()) {
                return true;
            } else if (primeraFecha.getMes() > segundaFecha.getMes()) {
                return false;
            } else {
                return primeraFecha.getDia() < segundaFecha.getDia();
            }
        }
    }
    public static boolean esDespues(Fecha primeraFecha, Fecha segundaFecha) {
        if (primeraFecha.getAnio() > segundaFecha.getAnio()) {
            return true;
        } else if (primeraFecha.getAnio() < segundaFecha.getAnio()) {
            return false;
        } else {
            if (primeraFecha.getMes() > segundaFecha.getMes()) {
                return true;
            } else if (primeraFecha.getMes() < segundaFecha.getMes()) {
                return false;
            } else {
                return primeraFecha.getDia() > segundaFecha.getDia();
            }
        }
    }
    public static boolean esIgual(Fecha primeraFecha, Fecha segundaFecha) {
        return primeraFecha.getAnio() == segundaFecha.getAnio()
        && primeraFecha.getMes() == segundaFecha.getMes()
        && primeraFecha.getDia() == segundaFecha.getDia();
    }
    public static boolean esAnioBisiesto(int anio) {
        return anio % 4 == 0;
    }

    //Metodos de conversion

    //De fecha a dias
    public int convertirFechaADias() {
        int diasTotales = dia;
        diasTotales += obtenerDiasPorAnio(anio);
        diasTotales += obtenerDiasPorMes(mes, anio);
        return diasTotales;
    }
    private static int saberDiasPorMes(int mes, int anio) {
        if (mes == 2) {
            if (anio % 4 == 0) {
                return 29;
            } else return 28;
        }
        if (mes <= 7) {
            if (mes % 2 == 1) {
                return 31;
            } else return 30;
        } else {
            if (mes % 2 == 1) {
                return 30;
            } else return 31;
        }
    }
    private static int obtenerDiasPorMes(int mes, int anio) {
        int dias = 0;
        if (mes > 1) {
            for (int i = mes - 1; i > 0; i--) {
                dias += saberDiasPorMes(i, anio);
            }
        }
        return dias;
    }
    private static int obtenerDiasPorAnio(int anios) {
        anios = anios - 1; //Anios anteriores al presente
        int aniosBisiestos = (int) (anios / 4);
        return 365 * anios + aniosBisiestos;
    }
    
    //De dias a fecha
    public static Fecha convertirDiasAFecha(int dias) {
        int anio = convertirDiasAAnio(dias);
        dias = dias - obtenerDiasPorAnio(anio);
        int mes = convertirDiasAMes(dias, anio);
        dias = dias - obtenerDiasPorMes(mes, anio);
        int dia = dias;
        return new Fecha(dia, mes, anio);

    }
    private static int convertirDiasAAnio(int dias) {
        int anios = (int) (dias * 4 / 1461);
        if (dias % 1461 == 0) {
            return anios;
        } else return anios + 1;
    }
    private static int convertirDiasAMes(int dias, int anio) {
        if (dias <= 31) {
            return 1;
        }
        if (anio % 4 == 0) {
            if (dias <= 60) {
                return 2;
            } else dias = dias - 60;
        } else {
            if (dias <= 59) {
                return 2;
            } else dias = dias - 59;
        }
        if (dias <= 153) {
            return calcularMes(dias) + 2;
        } else dias = dias - 153;
        return calcularMes(dias) + 7;

    }
    private static int calcularMes(int dias) {
        return (int) ((dias - 1) * 2 / 61) + 1;
    }
    
    //Metodos operativos

    //Con dias
    public static Fecha adicionarDias(Fecha fecha, int dias) {
        int diasEnFecha = fecha.convertirFechaADias();
        diasEnFecha = diasEnFecha + dias;
        fecha = convertirDiasAFecha(diasEnFecha);
        return fecha;
    }

    //Con fechas
    public static int calcularIntervaloEntreFechas(Fecha fechaInicial, Fecha fechaFinal) {
        int diasEnFechaFinal = fechaFinal.convertirFechaADias();
        int diasEnFechaInicial = fechaInicial.convertirFechaADias();
        return diasEnFechaFinal - diasEnFechaInicial;
    }
}
