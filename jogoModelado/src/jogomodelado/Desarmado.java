package jogomodelado;

/**
 *
 * @author oteixeiras
 */
public class Desarmado extends Arma_IF implements ArmaBranca{

    public Desarmado(){
        this.codigo = 1;
        this.danoMinimo = 2;
        this.danoMaximo = 3;
        this.pesoArma = 0;
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
