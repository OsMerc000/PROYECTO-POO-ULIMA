/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author 20240
 * @param <T>
 */
public interface Recepcionista<T> {
    public T registrar(T objeto);
    public T modificar(T objeto);
    public void eliminar(T objeto);
}

