package model;

import algorithm.FloodFill;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tabuleiro {

    private BufferedImage imagem;
    private int largura;
    private int altura;
    private int frameCount = 0;
    private String pastaFrames = "resources/frames/";



    public Tabuleiro(int largura, int altura) {
        this.largura = largura;
        this.altura  = altura;
        this.imagem  = gerarImagem(largura, altura);
        new File(pastaFrames).mkdirs();
        // new File("resources/output/").mkdirs();
    }


    private BufferedImage gerarImagem(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        int esp = 3;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, esp);
        g.fillRect(0, h - esp, w, esp);
        g.fillRect(0, 0, esp, h);
        g.fillRect(w - esp, 0, esp, h);

        int carroX = 60;
        int carroY = 180;
        int carroW = 480;
        int carroH = 100;
        desenharRetangulo(g, carroX, carroY, carroW, carroH, esp);

        int cabX1  = carroX + 80;
        int cabX2  = carroX + carroW - 80;
        int cabTX1 = carroX + 140;
        int cabTX2 = carroX + carroW - 140;
        int cabBaseY = carroY;
        int cabTopoY = carroY - 90;

        int[] cabXs = {cabX1, cabX2, cabTX2, cabTX1};
        int[] cabYs = {cabBaseY, cabBaseY, cabTopoY, cabTopoY};
        desenharPoligono(g, cabXs, cabYs, esp + 1);

        int janelaY = cabTopoY + 12;
        int janelaH = cabBaseY - cabTopoY - 24;
        desenharRetangulo(g, cabTX1 + 10,  janelaY, 95, janelaH, esp);
        desenharRetangulo(g, cabTX1 + 120, janelaY, 95, janelaH, esp);

        // ── Rodas ───────────────────────────────────────────────────
        int rodaRaio = 45;
        int rodaY    = carroY + carroH - esp;
        desenharCirculo(g, carroX + 110,          rodaY, rodaRaio, esp);
        desenharCirculo(g, carroX + carroW - 110, rodaY, rodaRaio, esp);

        // ── Faróis ──────────────────────────────────────────────────
        desenharRetangulo(g, carroX + carroW - esp, carroY + 20, 18, 28, esp); // dianteiro
        desenharRetangulo(g, carroX - 18,           carroY + 20, 18, 28, esp); // traseiro

        // ── Chão ────────────────────────────────────────────────────
        g.setColor(Color.BLACK);
        g.fillRect(0, h - 40, w, esp);

        g.dispose();
        return img;
    }

    private void desenharRetangulo(Graphics2D g, int x, int y, int w, int h, int esp) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, w, h);
        g.setColor(Color.WHITE);
        g.fillRect(x + esp, y + esp, w - esp * 2, h - esp * 2);
    }

    private void desenharPoligono(Graphics2D g, int[] xs, int[] ys, int recuo) {
        g.setColor(Color.BLACK);
        g.fillPolygon(xs, ys, xs.length);

        int[] xsInt = xs.clone();
        int[] ysInt = ys.clone();
        xsInt[0] += recuo; xsInt[1] -= recuo;
        xsInt[2] -= recuo; xsInt[3] += recuo;
        ysInt[0] -= recuo; ysInt[1] -= recuo;
        ysInt[2] += recuo; ysInt[3] += recuo;
        g.setColor(Color.WHITE);
        g.fillPolygon(xsInt, ysInt, xsInt.length);
    }

    private void desenharCirculo(Graphics2D g, int cx, int cy, int raio, int esp) {
        g.setColor(Color.BLACK);
        g.fillOval(cx - raio, cy - raio, raio * 2, raio * 2);

        int inner = raio - esp * 2;
        g.setColor(Color.WHITE);
        g.fillOval(cx - inner, cy - inner, inner * 2, inner * 2);

        int calota = inner / 3;
        g.setColor(Color.BLACK);
        g.fillOval(cx - calota, cy - calota, calota * 2, calota * 2);
    }

    // ── Controle de frames ──────────────────────────────────────────────────

    public void reiniciar() {
        this.imagem = gerarImagem(largura, altura);
        this.frameCount = 0;
    }


    public void salvarImagemInicial() {
        salvarArquivo("resources/input/carro_original.png");
    }

    public void salvarFrame() {
        frameCount++;
        salvarArquivo(String.format(pastaFrames + "frame_%05d.png", frameCount));
    }


    private void salvarArquivo(String caminho) {
        try {
            ImageIO.write(imagem, "PNG", new File(caminho));
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
        }
    }

    // ── Getters ─────────────────────────────────────────────────────────────

    public int getRGB(int x, int y)           { return imagem.getRGB(x, y); }
    public void setRGB(int x, int y, int rgb) { imagem.setRGB(x, y, rgb); }
    public int getLargura()                   { return largura; }
    public int getAltura()                    { return altura; }
    public BufferedImage getImagem()          { return imagem; }
}
