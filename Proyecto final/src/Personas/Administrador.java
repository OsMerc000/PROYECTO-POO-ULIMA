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
public interface Administrador<T> {
    public T agregar(T objeto);
    public T modificar (T objeto);
    public void remover (T objeto);
}

