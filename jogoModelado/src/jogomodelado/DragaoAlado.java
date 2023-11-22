package jogomodelado;

/**
 *
 * @author oteixeiras
 */

public class DragaoAlado extends Personagem implements Dragao{
    
    public DragaoAlado(){
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
             
        this.saude = 90;
        this.forca = 50;
        this.escudoMax = 10;
        this.classe = "dragao";
        this.armaPrincipal = metodosAuxiliares.setArma(this.classe);
        this.armaSecundaria =  this.armaPrincipal;
        this.informacoesPersonagem =  metodosAuxiliares.informacoesPersonagem(this.armaPrincipal, this.saude, this.forca, this.escudoMax, this.classe, this.armaSecundaria);
    }
    
    @Override
    public void desenhar(){
        System.out.println("                                                      ,/#(%#          \n" +
                            "                                                     .##%%&%##%       \n" +
                            "                #(##*                                %%&%%%%%#%#      \n" +
                            "                ,(((((*    (  .*.                  &%%%###%#%%%#%.    \n" +
                            "                ./##((%%#%%%%(%.(%  (//.         &/(%%%###((#(####*   \n" +
                            "                  / #,%#/%%%%%%%%%#####/#.      %#%###(##(##/((/##/,  \n" +
                            "                 /#.%%%%%/%%%&###(#/%#(##(,  .%##%#(/(((/((/#(/((##// \n" +
                            "                #%%%#%%&&%##(%%((##((/#%%%%%%%&%#%%#*///(*((//(/(/(#(,\n" +
                            "            ,%%&%%(%%%%%%% ,%(#%(########%%&%%%###/((*,///**/**/*//(#/\n" +
                            "           %%%###%%#####((#/. /###%#%%(#%%%%&%%%##(*/(/,*/***/(/(**/((\n" +
                            "       (%#%#%###(#%%%(#(#(/(%#%###*(##%%%%%((#%%#(/////////***(///*/(*\n" +
                            "       .###(*//###/((*      .* (   /%(%/####((#%%%    ., ((/(**///*///\n" +
                            "            .#(#,*                 % #(//((/#%%%##(        /  (*(//*//\n" +
                            "           /##*                     *###//####%%%              ( (((//\n" +
                            "                                     #%%/#/(#%%%%.                #/(/\n" +
                            "                                           /((#&#                 (#,*\n" +
                            "                                            **/##.                # / \n" +
                            "                                            ,*/#% ,              /  , \n" +
                            "                                             /#%/(                    \n" +
                            "                                            *(%#(                     \n" +
                            "                                           //%(,                      \n" +
                            "                        *%####((,*      /(%#/.                        \n" +
                            "                     ,((#%%%#/%%%%%%%%&##                             \n" +
                            "                    (%%%#///#*                                        ");
    }
    
    @Override
    public void falar(){
        System.out.println("DragaoAlado: '- GRASHDWDEDCEFC'");      
    }
    
    public void voar(){
        MetodosAuxiliares metodosAuxiliares = new MetodosAuxiliares();
        int saudeAtual = (int)this.informacoesPersonagem.get("saude");
        int danoAtual = (int)this.informacoesPersonagem.get("saude");
        
        int saudeAposVoo = 0;
        int danoAposVoo = 0;
        
        if (metodosAuxiliares.CalcularRanger(1,10) == 2){
            saudeAposVoo = saudeAtual - (25 * saudeAtual/100);
            danoAposVoo = danoAtual + 1;
            
            this.informacoesPersonagem.put("saude",saudeAposVoo);         
            this.informacoesPersonagem.put("dano",danoAposVoo);
        }
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