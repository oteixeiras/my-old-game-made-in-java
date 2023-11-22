package jogomodelado;

/**
 *
 * @author oteixeiras
 */

public class Fogo extends Arma_IF implements Elementar{

    public Fogo(){
        this.codigo = 2;
        this.danoMinimo = 2;
        this.danoMaximo = 4;
        this.pesoArma = 1;
        // Em percentual
        this.condicaoMinimaSaudeUso = 0;
        
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        
        this.informacoesUsoArma =  metodosAuxiliares.informacoesArma(this.codigo, danoMinimo, danoMaximo, condicaoMinimaSaudeUso, pesoArma);
    }
    
    @Override
    public int usarArma(){
        return this.informacoesUsoArma.get("danoArma");
    }
}
