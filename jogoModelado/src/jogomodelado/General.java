package jogomodelado;

/**
 *
 * @author oteixeiras
 */

public class General extends Personagem{
    
    public General(){
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        
        
        this.saude = 55;
        this.forca = 11;
        this.escudoMax = 10;
        this.classe = "guerreiro";   
        this.armaSecundaria = metodosAuxiliares.setArma("");
        this.armaPrincipal = metodosAuxiliares.setArma(this.classe);
        this.informacoesPersonagem =  metodosAuxiliares.informacoesPersonagem(this.armaPrincipal, this.saude, this.forca, this.escudoMax, this.classe, this.armaSecundaria);
    }
    
    @Override
    public void desenhar(){
        System.out.println("                     %////////#              \n" +
                            "                   ,(((((,*(((((.            \n" +
                            "          .((      %##((((((((##%            \n" +
                            "        /*,/,..(  %&@***.##.**,@&&           \n" +
                            "       #../,*(...   (.,#*..%(..#             \n" +
                            "    #((/*,...,,.*#(#/*.#*..*/.**///          \n" +
                            " .((((((**#(((((&%%(.**,,/(/*(*.(%/*,*((((   \n" +
                            " #((((((/**#((////#(((//%###%%&(((((***(#((% \n" +
                            "  %##(((***#((((((((*(*((,,#((%%/%&##**(((((.\n" +
                            "      ./***.,(((((((/**#%#%%#((#((((/*/((((((\n" +
                            "               &##(((***/(((((((((#(( (######\n" +
                            "                %#####////#######(//  #...../\n" +
                            "                  /%@@@@&/######(,  *,,((...,\n" +
                            "                   #************#      ,,*., \n" +
                            "                   .((/((  (((((         /(  \n" +
                            "                     @@@    @@@              \n" +
                            "             .&@@@@@@%@@....@@%@@@@@@&.   ");
    }
    
    @Override
    public void falar(){
        System.out.println("General: '- Eu sou de Tangamandápio!'");      
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

