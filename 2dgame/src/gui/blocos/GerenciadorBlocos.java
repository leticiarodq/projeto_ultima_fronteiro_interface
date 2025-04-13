package gui.blocos;

import gui.system.FerramentasUteis;
import gui.system.PainelJogo;
import gui.entidades.Entidade;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GerenciadorBlocos {

    PainelJogo gp;
    private Blocos[] blocos;
    private int numBlocosMapa[][];

    public int[][] getNumBlocosMapa() {
        return numBlocosMapa;
    }
    public Blocos[] getBlocos() {
        return blocos;
    }


    public GerenciadorBlocos(PainelJogo gp){ //Construtor

        this.gp=gp; //O this se refere ao atributo da instância da classe e não ao parâmetro do método

        blocos = new Blocos[100]; //Quantidade dos tipos de bloco

        numBlocosMapa= new int[gp.getColMundoMax()][gp.getLinhaMundoMax()];

        pegarImagemBloco(); //Chamando o método no construtor
        carregarMapa("/maps/world01.txt",0);
    }


    public void pegarImagemBloco(){//Construtor

        setup(0,"grass00", false);
        setup(1,"grass01", false);
        setup(2,"grass02", false);
        setup(3,"grass03", false);

        setup(4,"water00", true);
        setup(5,"water01", true);
        setup(6,"water02", true);
        setup(7,"water03", true);
        setup(8,"water04", true);
        setup(9,"water05", true);
        setup(10,"water06", true);
        setup(11,"water07", true);
        setup(12,"water08", true);
        setup(13,"water09", true);
        setup(14,"water10", true);
        setup(15,"water11", true);
        setup(16,"water12", true);
        setup(17,"water13", true);

        setup(18,"sand00", false);

        setup(19,"stone00" ,true);

        setup(20,"tree01", true);

        setup(21,"way01", false);
        setup(22,"way02", false);
        setup(23,"way03", false);
        setup(24,"way04", false);
        setup(25,"way05", false);
        setup(26,"way06", false);
        setup(27,"way07", false);
        setup(28,"way08", false);
        setup(29,"way09", false);
        setup(30,"way10", false);
        setup(31,"way11", false);
        setup(32,"way12", false);
        setup(33,"way13", false);
        setup(34,"way14", false);
        setup(35,"way15", false);
        setup(36,"way16", false);
        setup(37,"way17", false);
        setup(38,"way18", false);
        setup(39,"way19", false);
        setup(40,"way20", false);

        setup(41,"river00", true);
        setup(42,"river01", true);
        setup(43,"river02", true);

        setup(44,"shrub01", true);

        setup(45,"bwater00", true);
        setup(46,"bwater01", true);
        setup(47,"bwater02", true);
        setup(48,"bwater03", true);
        setup(49,"bwater04", true);
        setup(50,"bwater05", true);
        setup(51,"bwater06", true);
        setup(52,"bwater07", true);
        setup(53,"bwater08", true);

    }

    public void setup(int indice, String nomeImagem, boolean colisao) {

        FerramentasUteis ferramentasUteis = new FerramentasUteis();

        try {
            blocos[indice] = new Blocos();

            BufferedImage imagem = ImageIO.read(getClass().getResourceAsStream("/tiles/" + nomeImagem + ".png"));
            imagem = ferramentasUteis.escalar(imagem, gp.getTamanhoBloco(), gp.getTamanhoBloco());

            blocos[indice].setImagem(imagem);
            blocos[indice].setColisao(colisao);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarMapa (String caminhoArquivo, int map){

        try{
            InputStream is=getClass().getResourceAsStream(caminhoArquivo);
            BufferedReader br= new BufferedReader(new InputStreamReader(is));

            int coluna=0;
            int linha=0;

            while(coluna<gp.getColMundoMax() && linha< gp.getLinhaMundoMax()){

                String line= br.readLine();

                while(coluna<gp.getColMundoMax()){

                    String numeros[]=line.split(" ");

                    int num=Integer.parseInt(numeros[coluna]);

                    numBlocosMapa[coluna][linha]=num;
                    coluna++;
                }
                if(coluna==gp.getColMundoMax()){
                    coluna=0;
                    linha++;
                }
            }
            br.close();;

        } catch (Exception e) {

        }
    }
    public void draw(Graphics2D g2) {

        int mundoCol=0;
        int mundoLinha=0;

        while(mundoCol<gp.getColMundoMax() && mundoLinha<gp.getLinhaMundoMax()){

            int numBloco= numBlocosMapa[mundoCol][mundoLinha];

            int mundoX= mundoCol * gp.getTamanhoBloco();
            int mundoY= mundoLinha * gp.getTamanhoBloco();
            int telaX = mundoX - gp.jogador.getMundoX() + gp.jogador.getTelaX();
            int telaY= mundoY - gp.jogador.getMundoY() + gp.jogador.getTelaY();

            //Parar de mover câmera no final
            if(gp.jogador.getTelaX()>gp.jogador.getMundoX()){
                telaX = mundoX;
            }
            if(gp.jogador.getTelaY()>gp.jogador.getMundoY()){
                telaY = mundoY;
            }
            int deslocamentoDireito=gp.getTelaLargura()-gp.jogador.getTelaX();
            if(deslocamentoDireito>gp.getMundoLargura()-gp.jogador.getMundoX()){
                telaX = gp.getTelaLargura()-(gp.getMundoLargura()-mundoX);
            }
            int deslocamentoInferior=gp.getTelaAltura()-gp.jogador.getTelaY();
            if(deslocamentoInferior>gp.getMundoAltura()-gp.jogador.getMundoY()){
                telaY = gp.getTelaAltura()-(gp.getMundoAltura()-mundoY);
            }

            if (mundoX + gp.getTamanhoBloco() >gp.jogador.getMundoX() - gp.jogador.getTelaX() &&
                    mundoX - gp.getTamanhoBloco() < gp.jogador.getMundoX() + gp.jogador.getTelaX() &&
                    mundoY + gp.getTamanhoBloco() > gp.jogador.getMundoY() - gp.jogador.getTelaY()  &&
                    mundoY - gp.getTamanhoBloco() < gp.jogador.getMundoY() + gp.jogador.getTelaY() ) {

                g2.drawImage(blocos[numBloco].getImagem(), telaX, telaY, null); //add gp.tileSize
            }
            else if(gp.jogador.getTelaX()>gp.jogador.getMundoX() || gp.jogador.getTelaY() > gp.jogador.getMundoY() || deslocamentoDireito>gp.getMundoLargura()-gp.jogador.getMundoX() || deslocamentoInferior>gp.getMundoAltura()-gp.jogador.getMundoY()){
                g2.drawImage(blocos[numBloco].getImagem(), telaX, telaY, null);
            }
            mundoCol++;

            if (mundoCol == gp.getColMundoMax()) {
                mundoCol = 0;
                mundoLinha++;

            }

        }
    }
}
