package jogomodelado;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author oteixeiras
 */
public class JogoModelado {

    public static void main(String[] args) {

        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        int vontadeDeJogar;
        
        //Gerar lista de combatentes
//        int quantCampeoes = 8;
//        
//        List<Personagem> listaCampeoes = metodosAuxiliares.criarTimes(quantCampeoes);
//        System.out.println(listaCampeoes);

        do{
            vontadeDeJogar = metodosAuxiliares.vontadeDeJogar();
            
            switch(vontadeDeJogar) {
                case 1:
                    JogoModelado jogo = new JogoModelado();

                    Personagem oponente1 = metodosAuxiliares.Oponente("PRIMEIRO");
                    Personagem oponente2 = metodosAuxiliares.Oponente("SEGUNDO");

                    List<Personagem> lista = jogo.batalhaX1(oponente1, oponente2);
                    break;
                case 2:
                    InOut.MsgDeAviso("Sair",  "Programa encerrado" );
                    break;
            }
       }while (vontadeDeJogar != 2);
    }
    

    
    public List<Personagem> batalhaX1(Personagem participante1, Personagem participante2 ){
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        List<Personagem> campeaoX1 = new ArrayList<>();
        
        String classNameparticipante1 = participante1.getClass().getSimpleName();
        String classNameparticipante2 = participante2.getClass().getSimpleName();
        
        String classNameArmaPrincipalParticipante1 = participante1.armaPrincipal.getClass().getSimpleName();
        String classNameArmaPrincipalParticipante2 = participante2.armaPrincipal.getClass().getSimpleName();
        
        int roundFinal = 100;
        int tempo;
        
        System.out.println("\n====Arma principal do " + classNameparticipante1 + "[" + classNameArmaPrincipalParticipante1+ "]");
        System.out.println("\n====Arma principal do " + classNameparticipante2 + "[" + classNameArmaPrincipalParticipante2+ "]");
       
        for(tempo = 1; tempo <= roundFinal; tempo ++){
            
            if(participante1.saude > 0 && participante2.saude > 0){
                int caraCoroa = metodosAuxiliares.CalcularRanger(1,2);
                System.out.println("\n");
                if (caraCoroa == 1){
                    System.out.println("Quem vai atacar vai ser o "+classNameparticipante1 +"("+participante1.saude+")");               
                    System.out.println("Quem vai defender vai ser o "+classNameparticipante2 +"("+participante2.saude+")"); 

                    int ataque = participante1.arma();
                    if(defesa(participante2, ataque) == 0) {
                        campeaoX1.add(participante1);
                    }

                }
                else{
                    System.out.println("Quem vai atacar vai ser o "+classNameparticipante2 +"("+participante2.saude+")");                
                    System.out.println("Quem vai defender vai ser o "+classNameparticipante1 +"("+participante1.saude+")");  

                    int ataque = participante2.arma();
                    if(defesa(participante1, ataque) == 0){
                        campeaoX1.add(participante2);
                    }
                } 
            }
        }
        System.out.println("tempo"+tempo);
        if(tempo > roundFinal){
            System.out.println("ACABOU O CONFLITO");
            if(participante1.saude > participante2.saude){
                campeaoX1.add(participante1);
                System.out.println("\n====PERSONAGEM CAMPEÃO DO COMFRONTO ᕙ(•̀‸•́‶)ᕗ\n");
                participante1.falar();
                participante1.desenhar();
                System.out.println("\n====VOU ATÉ TENTAR COLECIONAR A SUA ARMA\n");
               participante1.setArma(participante2.armaPrincipal);
            }
            else{
                campeaoX1.add(participante2);
                System.out.println("\n====PERSONAGEM CAMPEÃO DO COMFRONTO ᕙ(•̀‸•́‶)ᕗ\n");
                participante2.falar();              
                participante2.desenhar();
                
                 System.out.println("\n====VOU ATÉ TENTAR COLECIONAR A SUA ARMA\n");
                participante2.setArma(participante1.armaPrincipal);
            }
        }
        
        return campeaoX1;
    }
    
    public int defesa(Personagem personagem, int ataque) {
        MetodosAuxiliares calcularSorte = new MetodosAuxiliares();
        
        int defesaPersonagem = (int) personagem.informacoesPersonagem.get("escudo");
        
        if (personagem.saude > 0){
            if (defesaPersonagem >= ataque){
                System.out.println("====SEGUROU 75% DO ATAQUE DO OPONENTE=====");
                if ( defesaPersonagem > 0)
                    personagem.informacoesPersonagem.put("escudo", defesaPersonagem -1);
                personagem.saude = (personagem.saude -(25 * ataque / 100));
            }
            else{
                personagem.informacoesPersonagem.put("escudo", 0);
                switch (calcularSorte.CalcularRanger(1, 4)) {
                    case 1:
                        System.out.println("====A SORTE APARECEU!!=====");
                        System.out.println("====OPONENTE ERROU O ATAQUE![0%]=====" + "ATAQUE: " + ataque);
                        break;
                    case 2:
                        System.out.println("====NÃO FOI EM CHEIO MAIS MACHUCOU[50%]===== " + "ATAQUE: " + ataque);
                        personagem.saude = (personagem.saude -(50 * ataque / 100));
                        break;
                    case 3:
                        System.out.println("====PODERIA SER PIOR..[75%]===== " + "ATAQUE: " + ataque);
                        personagem.saude = (personagem.saude -(75 * ataque / 100));
                        break;
                    case 4:
                        System.out.println("====ATAQUE SUPER EFETIVO[100%]===== " + "ATAQUE: " + ataque);
                        personagem.saude = (personagem.saude -ataque);
                        break;       
                }    
            }
        }
        if (personagem.saude < 0){
            System.out.println("====PERSONAGEM "+personagem.getClass().getSimpleName() +" ABATIDO EM CONFRONTO =====");
        }
        return personagem.saude;
    }
}

    
        








    
    
    

