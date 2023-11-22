/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jogomodelado;

/**
 *
 * @author oteixeiras
 */
public interface Magia {
    default int usarArma(){
        MetodosAuxiliares ranger = new MetodosAuxiliares();
            System.out.println("Usando Magia...");
            return ranger.CalcularRanger(0, 10);
        }
}
