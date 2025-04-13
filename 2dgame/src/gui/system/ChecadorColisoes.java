package gui.system;

import gui.entidades.Entidade;

public class ChecadorColisoes {

    PainelJogo gp;

    public ChecadorColisoes(PainelJogo gp){
        this.gp=gp;
    }

    public void checkTile(Entidade characters){

        int personagemMundoXesquerda = characters.getMundoX() + characters.getAreaSolida().x;
        int personagemMundoXdireita = characters.getMundoX() + characters.getAreaSolida().x + characters.getAreaSolida().width;
        int personagemMundoYcima = characters.getMundoY() + characters.getAreaSolida().y;
        int personagemMundoYbaixo = characters.getMundoY() + characters.getAreaSolida().y + characters.getAreaSolida().height;


        int personagemColunaEsquerda=personagemMundoXesquerda/gp.getTamanhoBloco();
        int personagemColunaDireita=personagemMundoXdireita/gp.getTamanhoBloco();
        int personagemLinhaCima=personagemMundoYcima/gp.getTamanhoBloco();
        int personagemLinhaBaixo=personagemMundoYbaixo/gp.getTamanhoBloco();

        int blocoNum1, blocoNum2;

        switch(characters.getDirecao()) {
            case "up":
                personagemLinhaCima = (personagemMundoYcima - characters.getVelocidade()) / gp.getTamanhoBloco();
                blocoNum1 = gp.blocosG.getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaCima];
                blocoNum2 = gp.blocosG.getNumBlocosMapa()[personagemColunaDireita][personagemLinhaCima];
                if(gp.blocosG.getBlocos()[blocoNum1].isColisao() || gp.blocosG.getBlocos()[blocoNum2].isColisao()) {
                    characters.setColisaoOn(true);
                }
                break;

            case "down":
                personagemLinhaBaixo = (personagemMundoYbaixo + characters.getVelocidade()) / gp.getTamanhoBloco();
                blocoNum1 = gp.blocosG.getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaBaixo];
                blocoNum2 = gp.blocosG.getNumBlocosMapa()[personagemColunaDireita][personagemLinhaBaixo];
                if(gp.blocosG.getBlocos()[blocoNum1].isColisao() || gp.blocosG.getBlocos()[blocoNum2].isColisao()) {
                    characters.setColisaoOn(true);
                }
                break;

            case "left":
                personagemColunaEsquerda = (personagemMundoXesquerda - characters.getVelocidade()) / gp.getTamanhoBloco();
                blocoNum1 = gp.blocosG.getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaCima];
                blocoNum2 = gp.blocosG.getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaBaixo];
                if(gp.blocosG.getBlocos()[blocoNum1].isColisao() || gp.blocosG.getBlocos()[blocoNum2].isColisao()) {
                    characters.setColisaoOn(true);
                }
                break;

            case "right":
                personagemColunaDireita = (personagemMundoXdireita + characters.getVelocidade()) / gp.getTamanhoBloco();
                blocoNum1 = gp.blocosG.getNumBlocosMapa()[personagemColunaDireita][personagemLinhaCima];
                blocoNum2 = gp.blocosG.getNumBlocosMapa()[personagemColunaDireita][personagemLinhaBaixo];
                if(gp.blocosG.getBlocos()[blocoNum1].isColisao() || gp.blocosG.getBlocos()[blocoNum2].isColisao()) {
                    characters.setColisaoOn(true);
                }
                break;
        }

    }
}
