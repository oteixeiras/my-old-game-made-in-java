package jogomodelado;
import java.util.Map;
import java.util.List;

/**
 *
 * @author oteixeiras
 */
public abstract class Personagem {
    Arma_IF armaPrincipal;
    Arma_IF armaSecundaria;
    int saude;
    int forca;
    int escudoMax;
    String classe;
    
    Map<String, Object> informacoesPersonagem;
    
    abstract void desenhar();
    abstract void falar();
    abstract int arma();
    
    //Parametros para pegar a arma secundaria: Vida o suficiente, força e proeza
    public Map<String, Object> setArma(Arma_IF arma) {
        int forcaPersonagem = (int) informacoesPersonagem.get("forca");
        int saudePersonagem = (int) informacoesPersonagem.get("saude");
        String classNameArma = arma.getClass().getSimpleName();

        if (forcaPersonagem > arma.pesoArma) {
            if (saudePersonagem >= arma.condicaoMinimaSaudeUso) {
                if (permitePegarArma(arma) == true){
                   System.out.println("===== ARMA SEGUNDÁRIA ATUALIZADA [" + classNameArma +"] =====");
                   informacoesPersonagem.put("armaSecundaria", arma); 
                } 
                else {
                    System.out.println("===== PERSONAGEM NÃO SABE USAR ESSE TIPO DE ARMA[" + classNameArma +"]=====");
                }
            } else {
                System.out.println("===== VIDA MUITO BAIXA PARA USAR ESSA ARMA[" + classNameArma +"]=====");
            }
        } 
        else {
            System.out.println("A arma é muito pesada para carregar");
            System.out.println("===== " + informacoesPersonagem.get("classe") + " SOLTA A ARMA[" + classNameArma +"]=====");
        }

        return informacoesPersonagem;
    }
    private boolean permitePegarArma(Arma_IF arma) {
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        List<Arma_IF> arsenalArmas = metodosAuxiliares.ArmasPersonagem(this.classe);

        for (Arma_IF armaPersonagem : arsenalArmas) {
            if (armaPersonagem.getClass().equals(arma.getClass())) {
                return true;
            }
        }
        return false;
    }
}
    