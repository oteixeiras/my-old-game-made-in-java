/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogomodelado;

/**
 *
 * @author oteixeiras
 */

public class Mago extends Personagem{
    
    public Mago(){
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        
        
        this.saude = 55;
        this.forca = 1;
        this.escudoMax = 15;
        this.classe = "mago";   
        this.armaSecundaria = metodosAuxiliares.setArma("");
        this.armaPrincipal = metodosAuxiliares.setArma(this.classe);
        this.informacoesPersonagem =  metodosAuxiliares.informacoesPersonagem(this.armaPrincipal, this.saude, this.forca, this.escudoMax, this.classe, armaSecundaria);
    }
    
    @Override
    public void desenhar(){
        System.out.println("                       .&&%%&%%%%,           \n" +
                            "                     #%%%%%%%&&&%&%%%%%%/    \n" +
                            "                   %%%&&&&&&%%%&&#           \n" +
                            "                 %%&&&%%%%&&&&.              \n" +
                            "               (%%%%%%%%%%%&%%&(             \n" +
                            "             .&((#%%%%%%%%#####%             \n" +
                            "             ,&&&%%%#######%&&&,             \n" +
                            "             #%&&&&&&&&%&&&&&&%%             \n" +
                            "            #%%%&&&&&&&&&&&&&%%%%&           \n" +
                            "          .%%%%%%%%%%%%%%%%%%%%%%%           \n" +
                            "          %&&&&&&&&&&&&&&&&&&&&&&%%*         \n" +
                            "         &&&&&&&&&&&&&&&&&%&&&&&&&&%.        \n" +
                            "        #&&&&&&%%%%%%%%%%%%%%%%%%%%&&&%%%%%%%\n" +
                            "#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&\n" +
                            "(%%%#((((#######%%%%*..../#(/*##(/#((&&&#.   \n" +
                            "        ,((///#,#(//,....,//(#,(/((//        \n" +
                            "       (%(((//(//////////////(/#(/##/&(      \n" +
                            "     &&&(#/(/(#//////////////(/##///#%&&&    \n" +
                            "    #&&&&/#/%/#////////////////(/%/(/&&&&#   \n" +
                            "    &&&&&((//##//////(/////////(#/(#(&&&&&   \n" +
                            "    &&&&&&#//(%////////////////(#(/%&&&&&&   \n" +
                            "    &&&&&&#(##(////////////(///(###%&&&&&&.  \n" +
                            "   .&&&&@&&%(#(/////////(//////((/&&&&&&&&   \n" +
                            "   .&&&&@&&&(##//(/////////////###&&&@&&&&.  \n" +
                            "   .&&&&@&&&/(%#/////#&///((/&(&#(&&&@&&&&.  \n" +
                            "    &&&&@@&&&((((/&&/&&%/%&/&&(/%&&&&@&&&&,  \n" +
                            "   .&&&&@@&&&&&&&&&&&&&&&&&&&&&%&&&&&@&&&&,  \n" +
                            "   .&&&&&&&&&%%#(##%&&&&&&&%#(##%&&&&&&&&&.  \n" +
                            "           %%%##%%%###  /%#%%%%%#%%,         \n" +
                            "          #&&&&&&&&&&&#.%&&&&&&&&&&& ");
    }
    
    @Override
    public void falar(){
        System.out.println("Mago: '- Bazinga!'");      
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
