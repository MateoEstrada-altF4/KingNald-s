package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            this.backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(new Color(15, 18, 22));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}