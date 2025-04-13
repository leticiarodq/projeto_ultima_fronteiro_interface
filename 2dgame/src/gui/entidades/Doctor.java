package gui.entidades;

import gui.system.PainelJogo;
import gui.system.EventosTeclado;
import personagens.Medico;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Doctor extends Jogador {

    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public Doctor(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.medico = new Medico("Dr. Eduardo", 100, 100, 100, 100, 100, null, "Floresta");
        getPlayerImage();
        medico.exibirStatus(); // <-- Aqui a chamada!
    }


    @Override
    public void getPlayerImage() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/doctor/doctor_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
