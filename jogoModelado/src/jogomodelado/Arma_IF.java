package jogomodelado;
import java.util.Map;

/**
 *
 * @author oteixeiras
 */
public abstract class Arma_IF {
    int codigo;
    int danoMinimo;
    int danoMaximo;
    int pesoArma;
    // Em percentual
    int condicaoMinimaSaudeUso;
    
    Map<String, Integer> informacoesUsoArma;  
    
    abstract int usarArma();
}
