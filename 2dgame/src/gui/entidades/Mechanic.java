package gui.entidades;



import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Mecanico;
import personagens.Rastreador;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mechanic extends Jogador {

    private Mecanico mecanico;

    public Mechanic(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.mecanico = new Mecanico("Laila", 100, 100, 100, 100, 100, null, "Floresta");
        getPlayerImage();
        mecanico.exibirStatus(); // <-- Aqui a chamada!
    }

    @Override
    public void getPlayerImage() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mechanic_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
