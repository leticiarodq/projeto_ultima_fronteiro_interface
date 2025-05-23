package personagens; // Define que esta classe pertence ao pacote itens

import ambientes.Ambiente;
import itens.Item;

import java.util.ArrayList;

public class Personagem { // Declaração da classe Personagem

    // Atributos privados do personagem, acessíveis apenas pela própria classe
    private String nome;
    private int vida;
    private int fome;
    private int sede;
    private int energia;
    private int sanidade;
    private ArrayList<Item> inventario;
    private String localizacao;


    // Construtor
    public Personagem(String nome,int vida, int fome, int sede, int energia, int sanidade, ArrayList inventario, String localizacao){
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.inventario = new ArrayList<>();
        this.localizacao = localizacao;
    }

    public void exibirStatus() {
        System.out.println("Personagem: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Fome: " + getFome());
        System.out.println("Sede: " + getSede());
        System.out.println("Energia: " + getEnergia());
        System.out.println("Sanidade: " + getSanidade());
        System.out.println("Localização: " + getLocalizacao());

    }
    //metodos getters

    public String getLocalizacao() {
        return localizacao;
    }

    public String getNome(){
        return nome;
    }

    public int getVida(){
        return vida;
    }

    public int getFome(){
        return fome;
    }

    public int getSede(){
        return sede;
    }

    public int getEnergia(){
        return energia;
    }

    public int getSanidade(){
        return sanidade;
    }

    public ArrayList<Item> getInventario(){
        return inventario;
    }

   /* public String getLocalizacao() {
        return localizacao;
    }
    */

    // Métodos setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public void setFome(int fome){
        this.fome = fome;
    }

    public void setSede(int sede){
        this.sede = sede;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public void setSanidade(int sanidade){
        this.sanidade = sanidade;
    }

    public void setInventario(ArrayList inventario) {
        this.inventario = inventario;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    // métodos de vida, sede , fome e energia

    public void reducaodeVida(int quantidade){
        this.vida = Math.min(100, this.vida - quantidade);
    }

    public void reducaodeSede(int quantidade){
        this.sede = Math.min(100, this.sede - quantidade);
    }

    public void reducaodeFome(int quantidade){
        this.fome = Math.min(100, this.fome - quantidade);
    }

    public void reducaodeEnergia(int quantidade){
        this.energia = Math.min(100, this.energia - quantidade);
    }

    public void recuperacaodeVida(int quantidade){
        this.vida = Math.min(100, this.vida + quantidade);
    }

    public void recuperacaodeSede(int quantidade){
        this.sede = Math.min(100, this.sede + quantidade);
    }

    public void recuperacaodeFome(int quantidade){
        this.fome = Math.min(100, this.fome + quantidade);
    }

    public void recuperacaodeEnergia(int quantidade){
        this.energia = Math.min(100, this.energia + quantidade);
    }

}
