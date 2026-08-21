package main;

import java.awt.*;
import javax.swing.*;

/**
 * Panel personalizado utilizado para reproducir
 * los paneles oscuros y redondeados de KingNald's.
 */
public class RoundedPanel extends JPanel {

    private int radius = 12;
    private Color backgroundColor = new Color(17, 18, 22);
    private Color borderColor = new Color(55, 55, 62);

    public RoundedPanel() {
        setOpaque(false);
        setLayout(null);
    }

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false);
        setLayout(null);
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int width = getWidth();
        int height = getHeight();

        // Fondo
        g2.setColor(backgroundColor);

        g2.fillRoundRect(
                0,
                0,
                width - 1,
                height - 1,
                radius,
                radius
        );

        // Borde
        g2.setColor(borderColor);

        g2.setStroke(new BasicStroke(1f));

        g2.drawRoundRect(
                0,
                0,
                width - 1,
                height - 1,
                radius,
                radius
        );

        g2.dispose();

        super.paintComponent(g);
    }
}