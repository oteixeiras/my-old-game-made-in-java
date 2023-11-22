package jogomodelado;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import static jogomodelado.InOut.leInt;

/**
 *
 * @author oteixeiras
 */
    public class MetodosAuxiliares {
        Random valorAleatorio = new Random();

        //construindo informações para o arma
        public Map<String, Integer> informacoesArma(int codigo, int danoMinimo, int danoMaximo, int condicaoMinimaSaudeUso, int pesoArma) {
        Map<String, Integer> informacoesUsoArma = new HashMap<>();

        // Gerar dano aleatório
        int danoArma = CalcularRanger(danoMinimo, danoMaximo);

        // Construir mapa com as informações da arma
        informacoesUsoArma.put("danoArma", danoArma);
        informacoesUsoArma.put("pesoArma", pesoArma);
        informacoesUsoArma.put("condicaoMinimaSaudeUso", condicaoMinimaSaudeUso);

        return informacoesUsoArma;
    }

    public Map<String, Integer> informacoesArma(int codigo, int danoMinimo, int danoMaximo, int condicaoMinimaSaudeUso, int pesoArma, int quantidadeBalasMaximas) {
        Map<String, Integer> informacoesUsoArma = new HashMap<>();

        // Gerar dano aleatório
        int danoArma = CalcularRanger(danoMinimo, danoMaximo);

        // Construir mapa com as informações da arma
        informacoesUsoArma.put("danoArma", danoArma);
        informacoesUsoArma.put("pesoArma", pesoArma);
        informacoesUsoArma.put("condicaoMinimaSaudeUso", condicaoMinimaSaudeUso);
        informacoesUsoArma.put("quantidadeBalas", quantidadeBalasMaximas);

        return informacoesUsoArma;
    }
    
    public Map<String, Object> informacoesPersonagem(Arma_IF armaPrincipal, int saude, int forca, int escudoMax, String classe, Arma_IF armaSecundaria){
        Map<String, Object> informacoesPersonagem = new HashMap<>();
        
        int forcaEscudo = CalcularRanger(1, escudoMax);

        //Contruir array das informações do personagem
        informacoesPersonagem.put("armaPrincipal", armaPrincipal);
        informacoesPersonagem.put("armaSecundaria", armaSecundaria);
        informacoesPersonagem.put("saude", saude);
        informacoesPersonagem.put("forca", forca);
        informacoesPersonagem.put("escudo", forcaEscudo);
        informacoesPersonagem.put("classe", classe);

        return informacoesPersonagem;
    }
   
    public Map<String, Object> informacoesPersonagem(Arma_IF armaPrincipal, int saude, int forca, int escudoMax, String classe){
        Map<String, Object> informacoesPersonagem = new HashMap<>();
        
        int forcaEscudo = CalcularRanger(1, escudoMax);

        //Contruir array das informações do personagem
        informacoesPersonagem.put("armaPrincipal", armaPrincipal);
        informacoesPersonagem.put("saude", saude);
        informacoesPersonagem.put("forca", forca);
        informacoesPersonagem.put("escudo", forcaEscudo);
        informacoesPersonagem.put("classe", classe);

        return informacoesPersonagem;
    }
    
    public int CalcularRanger(int danoMinimo, int danoMaximo){
        return valorAleatorio.nextInt((danoMaximo - danoMinimo) + 1) + danoMinimo;
    }
        
    public Arma_IF setArma(String classe){
        List<Arma_IF> arsenal = ArmasPersonagem(classe);
        
        int tamanhoArsenal = arsenal.size()-1;
        int selecionarIndiceAleatorioArma = CalcularRanger(0, tamanhoArsenal);
                
        return arsenal.get(selecionarIndiceAleatorioArma);       
    }
    
    public List<Arma_IF> ArmasPersonagem(String classe) {
        List<Arma_IF> armasPossiveis = new ArrayList<>();

        switch (classe) {
            case "guerreiro":
                armasPossiveis.add(new Fuzil());
                armasPossiveis.add(new Faca());
                armasPossiveis.add(new Revolver());
                armasPossiveis.add(new Desarmado());
                break;

            case "lutador":
                armasPossiveis.add(new Faca());
                armasPossiveis.add(new Desarmado());
                break;

            case "mago":
                armasPossiveis.add(new Varinha());
                armasPossiveis.add(new Desarmado());
                break;

            case "dragao":
                armasPossiveis.add(new Fogo());
                break;

            default:
                armasPossiveis.add(new Desarmado());
                armasPossiveis.add(new Faca());
                break;
        }

        return armasPossiveis;
    }
    
    //Formar os times para os confrontos
    public List<Personagem> criarTimes(int quantidadePersonagem) {
        List<Personagem> competidores = new ArrayList<>();

        int indicePersonagem = 0;

        for (int posicaoJogador = 0; posicaoJogador < quantidadePersonagem; posicaoJogador++) {
            indicePersonagem = CalcularRanger(0, 4);

            switch (indicePersonagem) {
                case 0:
                    competidores.add(new Soldado());
                    break;
                case 1:
                    competidores.add(new General());
                    break;
                case 2:
                    competidores.add(new LutSUMO());
                    break;
                case 3:
                    competidores.add(new Mago());
                    break;
                case 4:
                    competidores.add(new DragaoAlado());
                    break;
                default:
                    System.out.println("Error: Algo de errado aconteceu na geração dos times");
                    break;
            }
        }
        return competidores;
    }
        public Personagem Oponente(String ordem) {
            int opcao = leInt(
                "Ta na hora do pau quebrar- ᕙ(⇀‸↼‶)ᕗ\n" +
                "Escolha o seu " + ordem + " OPONENTE\n" +
                "1 - Lutador de Sumô\n" +
                "2 - Dragão Alado\n" +
                "3 - Mago\n" +
                "4 - Soldado\n" +
                "5 - General\n"
            );

            switch (opcao) {
                case 1:
                    LutSUMO lutSumo = new LutSUMO();
                    return lutSumo;

                case 2:
                    DragaoAlado dragao = new DragaoAlado();
                    return dragao;

                case 3:
                    Mago mago = new Mago();
                    return mago;

                case 4:
                    Soldado soldado = new Soldado();
                    return soldado;

                case 5:
                    General general = new General();
                    return general;
            }

            return null;
        }
        
        public int vontadeDeJogar() {
            int desejo = leInt(
                "BEM VINDO\n" +
                "Deseja Jogar uma partida? \n" +
                "1 - Sim\n" +
                "2 - Não\n");
            
            return desejo;
        }
}
