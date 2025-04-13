package gui.system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado implements KeyListener{

    private boolean cimaPressionado, baixoPressionado, esquerdaPressionado, direitaPressionado;

    public void keyTyped(KeyEvent e) {
    }

    public boolean isCimaPressionado(){
        return cimaPressionado;
    }
    public boolean isBaixoPressionado(){
        return baixoPressionado;
    }
    public boolean isEsquerdaPressionado(){
        return esquerdaPressionado;
    }
    public boolean isDireitaPressionado(){
        return direitaPressionado;
    }

    public void keyPressed(KeyEvent e) {

        int code=e.getKeyCode();

        if(code==KeyEvent.VK_W) {
            cimaPressionado=true;
        }

        if(code==KeyEvent.VK_S) {
            baixoPressionado=true;
        }
        if(code==KeyEvent.VK_A) {
            esquerdaPressionado=true;
        }
        if(code==KeyEvent.VK_D) {
            direitaPressionado=true;
        }

    }

    public void keyReleased(KeyEvent e) {

        int code=e.getKeyCode();

        if(code==KeyEvent.VK_W) {
            cimaPressionado=false;
        }
        if(code==KeyEvent.VK_S) {
            baixoPressionado=false;
        }
        if(code==KeyEvent.VK_A) {
            esquerdaPressionado=false;
        }
        if(code==KeyEvent.VK_D) {
            direitaPressionado=false;
        }
    }
}