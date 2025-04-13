package gui.blocos;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Blocos {

    private BufferedImage imagem;
    private boolean colisao = false;

    public BufferedImage getImagem() {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public boolean isColisao() {
        return colisao;
    }

    public void setColisao(boolean colisao) {
        this.colisao = colisao;
    }
}

