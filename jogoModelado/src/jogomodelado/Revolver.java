package jogomodelado;

import java.util.Map;

/**
 *
 * @author oteixeiras
 */
public class Revolver extends Arma_IF{

    public Revolver(){
        this.codigo = 5;
        this.danoMinimo = 2;
        this.danoMaximo = 5;
        // Em kg
        int quantidadeBalasMaximas = 6;
        this.pesoArma = 3;
        // Em percentual
        this.condicaoMinimaSaudeUso = 10;
        
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        
        this.informacoesUsoArma =  metodosAuxiliares.informacoesArma(this.codigo, danoMinimo, danoMaximo, condicaoMinimaSaudeUso, pesoArma, quantidadeBalasMaximas);
    }
    
    @Override
    public int usarArma(){
        int quantidadeBalas = 6;
        /**
         * Método para avaliar se é possível evetuar os disparos, e aplica equilibração do consumo dos projéteis.
        */
        System.out.println("===== UTILIZANDO ARMA " + this.informacoesUsoArma.get("quantidadeBalas") +  "/" + quantidadeBalas + " =====");
                
        if (this.informacoesUsoArma.get("quantidadeBalas") > 0 ){
            if (this.informacoesUsoArma.get("danoArma") == danoMaximo){
                this.informacoesUsoArma.put("quantidadeBalas", this.informacoesUsoArma.get("quantidadeBalas")-2);
                return informacoesUsoArma.get("danoArma"); 
            }
            else{
                this.informacoesUsoArma.put("quantidadeBalas", this.informacoesUsoArma.get("quantidadeBalas")-1);
                return informacoesUsoArma.get("danoArma");
            }
         }
        else{   
            System.out.println("===== SEM MUNIÇÃO PARA ATIRAR NESSE TURNO " + this.informacoesUsoArma.get("quantidadeBalas") +  "/" + quantidadeBalas+ " =====");   
            System.out.println("===== ARMA RECARREGADA + ====="); 
            this.informacoesUsoArma.put("quantidadeBalas",quantidadeBalas );
            return 0;
        }
    }  
}