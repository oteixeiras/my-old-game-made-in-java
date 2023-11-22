package jogomodelado;

/**
 *
 * @author oteixeiras
 */

//dano fixo para faca e mãos
public interface ArmaBranca {   
    MetodosAuxiliares ranger = new MetodosAuxiliares();
    
        default int usarArma(){
            System.out.println("Usando a arma branca...");
            return ranger.CalcularRanger(0, 10);
        }
}
