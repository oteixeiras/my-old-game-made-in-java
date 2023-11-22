package jogomodelado;

/**
 *
 * @author oteixeiras
 */
public interface Elementar {
     MetodosAuxiliares ranger = new MetodosAuxiliares();
  
    default int usarArma(){
        System.out.println("Usando arma Elementar..");
      return ranger.CalcularRanger(2, 17);
    }  
}
