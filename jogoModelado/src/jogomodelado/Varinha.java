/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogomodelado;

/**
 *
 * @author oteixeiras
 */

public class Varinha extends Arma_IF implements Magia{

    public Varinha(){
        this.codigo = 6;
        this.danoMinimo = 4;
        this.danoMaximo = 5;
        // Em kg
        this.pesoArma = 0;
        // Em percentual
        this.condicaoMinimaSaudeUso = 20;
        
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        
        this.informacoesUsoArma =  metodosAuxiliares.informacoesArma(this.codigo, this.danoMinimo, this.danoMaximo, this.condicaoMinimaSaudeUso, this.pesoArma);
    }
    
    @Override
    public int usarArma(){
        System.out.println("aqui");
        return this.informacoesUsoArma.get("danoArma");      
    }
}
