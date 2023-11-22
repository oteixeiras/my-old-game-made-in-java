package jogomodelado;

/**
 *
 * @author oteixeiras
 */
public class LutSUMO extends Personagem{
    
    public LutSUMO(){
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
  
        this.saude = 60;
        this.forca = 20;
        this.escudoMax = 2;
        this.classe = "lutador";   
        this.armaSecundaria = metodosAuxiliares.setArma("");
        this.armaPrincipal = metodosAuxiliares.setArma(this.classe);
        this.informacoesPersonagem =  metodosAuxiliares.informacoesPersonagem(this.armaPrincipal, this.saude, this.forca, this.escudoMax, this.classe, this.armaSecundaria);
    }
    
    @Override
    public void desenhar(){
        System.out.println("                     #&&(                    \n" +
                            "                   .@@@@@@.                  \n" +
                            "                 ..(%.%#.%/..                \n" +
                            "                ..............               \n" +
                            "           ..........(../..........          \n" +
                            "      ..................................     \n" +
                            "    ......................................   \n" +
                            "   ......................................... \n" +
                            "  .......................................... \n" +
                            " .....   ............................   .....\n" +
                            "....... .###(,..................,(###* ... ..\n" +
                            " ...     ############################,    ...\n" +
                            "        .....,/################/,......      \n" +
                            "       ........../##########............     \n" +
                            "      .........  *##########   .........     \n" +
                            "       .......   *##########    ........  ");
    }
    
    @Override
    public void falar(){
        System.out.println("LutSUMO: '- Que que foi, que que foi, que que há? '");      
    }
    
    @Override
    public int arma(){
        int condicaoMinimaSaudeUsoArmaPrincipal = this.armaPrincipal.informacoesUsoArma.get("condicaoMinimaSaudeUso");
        int dano = 0;
        if ( this.saude >= condicaoMinimaSaudeUsoArmaPrincipal) {
            dano = this.armaPrincipal.usarArma();
        } 
        else {
            System.out.println("===== PEGANDO ARMA SECUNDARIA + =====");
            dano = this.armaSecundaria.usarArma();
        }  
        return dano;
    }
}
