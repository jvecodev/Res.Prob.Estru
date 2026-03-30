package ui;

import model.Tabuleiro;

import javax.swing.*;

import algorithm.FloodFill;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelJogo extends JPanel {

    private Tabuleiro tabuleiro;
    private boolean usandoPilha;
    private Color corAtual = Color.RED;
    private FloodFill floodFill = new FloodFill();

    public PainelJogo(Tabuleiro tabuleiro, boolean usandoPilha) {
        this.tabuleiro = tabuleiro;
        this.usandoPilha = usandoPilha;

        setPreferredSize(new Dimension(tabuleiro.getLargura(), tabuleiro.getAltura()));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    Color escolhida = JColorChooser.showDialog(
                            PainelJogo.this, "Escolha a cor", corAtual);
                    if (escolhida != null)
                        corAtual = escolhida;
                    return;
                }
                iniciando(e.getX(), e.getY());
            }
        });
    }

    private void iniciando(int x, int y) {
        int corOriginal = tabuleiro.getRGB(x, y);
        if (corOriginal == corAtual.getRGB())
            return;

        Color cor = corAtual;
        boolean pilha = usandoPilha;

        Thread thread = new Thread(() -> {
            Runnable aoMudarPixel = () -> {
                repaint();
                try { Thread.sleep(2); } catch (InterruptedException ignored) {}
            };

            if (pilha)
                floodFill.executarComPilha(tabuleiro, x, y, cor, aoMudarPixel);
            else
                floodFill.executarComFila(tabuleiro, x, y, cor, aoMudarPixel);

            repaint();
        });

        thread.start();
    }

    public void setUsandoPilha(boolean usandoPilha) {
        this.usandoPilha = usandoPilha;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tabuleiro.getImagem(), 0, 0, null);
    }
}
