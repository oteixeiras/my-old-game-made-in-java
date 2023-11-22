package jogomodelado;

/**
 *
 * @author oteixeiras
 */
public class Faca extends Arma_IF implements ArmaBranca{

    public Faca(){
        this.codigo = 3;
        this.danoMinimo = 2;
        this.danoMaximo = 4;
        
        // vezes de uso
        this.pesoArma = 1;
        // Em percentual
        this.condicaoMinimaSaudeUso = 0;
        
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        
        this.informacoesUsoArma =  metodosAuxiliares.informacoesArma(this.codigo, this.danoMinimo, this.danoMaximo, this.condicaoMinimaSaudeUso, this.pesoArma);
    }
    
    @Override
    public int usarArma(){
        return this.informacoesUsoArma.get("danoArma");
    }
}
