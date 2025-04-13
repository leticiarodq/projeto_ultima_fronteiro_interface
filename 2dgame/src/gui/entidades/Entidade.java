package gui.entidades;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entidade {

    private int mundoX, mundoY;
    private int velocidade;

    private BufferedImage up1,up2,down1,down2, left1,left2,right1,right2;
    private String direcao;

    private int contadorSprite=0;
    private int numSprite=1;

    private Rectangle areaSolida;

    private boolean colisaoOn=false;

    // Métodos get

    public Rectangle getAreaSolida(){
        return areaSolida;
    }
    public int getMundoX(){
        return mundoX;
    }
    public int getMundoY(){
        return mundoY;
    }
    public int getVelocidade(){
        return velocidade;
    }
    public int getContadorSprite(){
        return contadorSprite;
    }
    public int getNumSprite(){
        return numSprite;
    }
    public String getDirecao(){
        return direcao;
    }


    // Métodos get

    public void setAreaSolida(Rectangle areaSolida){
        this.areaSolida=areaSolida;
    }
    public void setMundoX(int mundoX){
        this.mundoX = mundoX;
    }
    public void setMundoY(int mundoY){
        this.mundoY = mundoY;
    }
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    public void setContadorSprite(int contadorSprite){
        this.contadorSprite = contadorSprite;
    }
    public void setNumSprite(int numSprite){
        this.numSprite = numSprite;
    }
    public void setDirecao(String direcao){
        this.direcao = direcao;
    }


    // Imagens com método get

    public BufferedImage getUp1(){
        return up1;
    }
    public BufferedImage getUp2(){
        return up2;
    }
    public BufferedImage getDown1() {
        return down1;
    }
    public BufferedImage getDown2() {
        return down2;
    }
    public BufferedImage getLeft1() {
        return left1;
    }

    public BufferedImage getLeft2() {
        return left2;
    }

    public BufferedImage getRight1() {
        return right1;
    }

    public BufferedImage getRight2() {
        return right2;
    }

    // Imagens com método set

    public void setUp1(BufferedImage up1){
        this.up1=up1;
    }
    public void setUp2(BufferedImage up2){
        this.up2=up2;
    }
    public void setDown1(BufferedImage down1) {
        this.down1=down1;
    }
    public void setDown2(BufferedImage down2) {
        this.down2=down2;
    }
    public void setLeft1(BufferedImage left1) {
        this.left1=left1;
    }

    public void setLeft2(BufferedImage left2) {
        this.left2=left2;
    }

    public void setRight1(BufferedImage right1) {
        this.right1=right1;
    }

    public void setRight2(BufferedImage right2) {
        this.right2=right2;
    }


    public boolean isColisaoOn() {
        return colisaoOn;
    }

    public void setColisaoOn(boolean colisaoOn){
        this.colisaoOn=colisaoOn;
    }
}