package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Rastreador;

import javax.imageio.ImageIO;
import java.io.IOException;

import ambientes.*;

public class Detective extends Jogador { //

    private Rastreador rastreador;

    public Detective(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.rastreador = new Rastreador("Luiz", 100, 100, 100, 100, 100, null, "Floresta");
        getPlayerImage();
        rastreador.exibirStatus(); // <-- Aqui a chamada!
    }

    @Override
    public void getPlayerImage() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/detective/detective_up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/detective/detective_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/detective/detective_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/detective/detective_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/detective/detective_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/detective/detective_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/detective/detective_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/detective/detective_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}