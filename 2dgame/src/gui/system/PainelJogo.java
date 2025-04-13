package gui.system;


//java.awt é um conjunto de classes do Java que permite criar interfaces gráficas
//java.swing

import ambientes.GerenciadorDeAmbientes;
import gui.blocos.GerenciadorBlocos;
import gui.entidades.*;
import personagens.Medico;
import personagens.Personagem;

import java.awt.Color; //Permite trabalhar com cores
import java.awt.Dimension; //Define dimensões para elementos gráficos
import java.awt.Graphics; //Usada para desenhar gráficos na tela
import java.awt.Graphics2D; //Usada para desenhar gráficos na tela
import javax.swing.JPanel; //Componente gráfico que representa a tela do jogo


public class PainelJogo extends JPanel implements Runnable { //GamePanel herda de JPanel, que é a área onde o jogo vai ser desenhado
    //implements Runnable indica que essa classe será executada em uma Thread separada, permitindo que o jogo rode continuamente sem travar a interface


    private final int tamanhoOriginalBloco = 16; //O tamanho de um bloco do jogo é 16 pixels
    private final int escala = 3; //O tamanho do bloco será escalada em 3 vezes, ficando com 48 pixels

    private final int tamanhoBloco = tamanhoOriginalBloco * escala;
    private final int tamanhoColuna = 16; //O jogo terá 16 colunas
    private final int tamanhoLinha = 12; //O jogo terá 12 linhas
    private final int telaLargura = tamanhoBloco * tamanhoColuna;
    private final int telaAltura = tamanhoBloco * tamanhoLinha;

    private final int linhaMundoMax=100;
    private final int colMundoMax=100;
    private final int mundoLargura=tamanhoBloco*linhaMundoMax;
    private final int mundoAltura=tamanhoBloco*colMundoMax;

    public final int getTamanhoBloco(){
        return tamanhoBloco;
    }
    public final int getTamanhoColuna(){
        return tamanhoColuna;
    }
    public final int getTamanhoLinha(){
        return tamanhoLinha;
    }
    public final int getTelaLargura(){
        return telaLargura;
    }
    public final int getTelaAltura(){
        return telaAltura;
    }
    public final int getLinhaMundoMax(){
        return linhaMundoMax;
    }
    public final int getColMundoMax(){
        return colMundoMax;
    }
    public final int getMundoLargura(){
        return mundoLargura;
    }
    public final int getMundoAltura(){
        return  mundoAltura;
    }

    int FPS=60;

    GerenciadorBlocos blocosG=new GerenciadorBlocos(this);
    EventosTeclado eventosTeclado= new EventosTeclado(); //Cria um objeto que lida com os eventos do teclado.
    Thread threadJogo; //Essa Thread permitirá que o jogo rode continuamente.

    private ChecadorColisoes cColisoes= new ChecadorColisoes(this);
    public Jogador jogador= new Jogador(this, eventosTeclado);


    public ChecadorColisoes getcColisoes(){
        return cColisoes;
    }


    MenuPersonagens telaMenuPersonagens;
    private String personagemSelecionado;
    private boolean jogoIniciado=false;

    public String getPersonagemSelecionado(){
        return personagemSelecionado;
    }
    public void setPersonagemSelecionado(String personagemSelecionado){
        this.personagemSelecionado=personagemSelecionado;
    }


    public boolean isJogoIniciado(){
        return jogoIniciado;
    }

    public PainelJogo() {
        this.setPreferredSize(new Dimension(telaLargura, telaAltura)); //Define o tamanho da tela
        this.setBackground(Color.black); //Define o fundo como preto
        this.setDoubleBuffered(true); //Ativa o "Double Buffering"(Isso ajuda a evitar que a tela fique piscando ao desenhar elementos)
        this.addKeyListener(eventosTeclado); //Adiciona o KeyListener para capturar teclas pressionadas
        this.setFocusable(true); //Permite que o painel capture eventos de teclado
        this.requestFocus(); //Garante que o painel receba o foco do teclado:

        telaMenuPersonagens = new MenuPersonagens(this);
        add(telaMenuPersonagens); //Adiciona a tela de seleção de personagem
        addKeyListener(telaMenuPersonagens); //Escuta os comandos para a seleção

    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void iniciarJogo() {

        //Criar o personagem baseado na escolha do jogador
        if (personagemSelecionado.equals("médico")) {
            jogador = new Doctor(this, eventosTeclado);
        } else if (personagemSelecionado.equals("mecânico")) {
            jogador = new Mechanic(this, eventosTeclado);
        } else if (personagemSelecionado.equals("rastreador")) {
            jogador = new Detective(this, eventosTeclado);
        } else {
            jogador = new Survivor(this, eventosTeclado);
        }

        //addKeyListener(eventosTeclado);
        requestFocusInWindow();
        jogoIniciado = true;
        iniciarThreadJogo();
    }


    public void iniciarThreadJogo() { //Cria e inicia a Thread do jogo, chamando o método run()
        threadJogo= new Thread(this);
        threadJogo.start();

    }

    @Override
    public void run() { // Loop principal do jogo (mantém o jogo rodando enquanto a threadJogo estiver ativa)

        double intervaloDesenho = 1000000000 / FPS; // Tempo ideal entre os quadros
        double delta = 0;
        long ultimoTempo = System.nanoTime();
        long tempoAtual;
        long cronometro = 0;
        int contadorQuadros = 0;

        while (threadJogo != null) {
            tempoAtual = System.nanoTime();

            delta += (tempoAtual - ultimoTempo) / intervaloDesenho;
            cronometro += (tempoAtual - ultimoTempo);

            ultimoTempo = tempoAtual;

            if (delta >= 1) { // Só atualiza o jogo quando delta ≥ 1
                update();    // Atualiza a lógica do jogo
                repaint();      // Requisição para redesenhar a tela
                delta--;        // Evita múltiplas atualizações por quadro
                contadorQuadros++;
            }

      /*      if (cronometro >= 1000000000) { // A cada 1 segundo...
                System.out.println("FPS: " + contadorQuadros);
                contadorQuadros = 0;
                cronometro = 0;
            }

       */

            try {
                Thread.sleep(1); // Pequena pausa para reduzir o uso da CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void update() {
        if (jogoIniciado) {
            jogador.update();
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2= (Graphics2D)g;


        blocosG.draw(g2); //Desenhar mapa antes do personagem

        //player.draw(g2);

        if (jogoIniciado) {
            jogador.draw(g2);
        } else {
            telaMenuPersonagens.paintComponent(g); // Desenha a seleção corretamente
        }

        g2.dispose();
    }

}