package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Rastreador;
import personagens.SobreviventeNato;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Survivor extends Jogador {

    private SobreviventeNato sobreviventeNato;

    public Survivor(PainelJogo gp, EventosTeclado keyH) {
        super(gp, keyH);
        this.sobreviventeNato = new SobreviventeNato("Elfa", 100, 100, 100, 100, 100, null, "Floresta");
        getPlayerImage();
        sobreviventeNato.exibirStatus(); // <-- Aqui a chamada!
    }

    @Override
    public void getPlayerImage() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/survivor/survivor_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
