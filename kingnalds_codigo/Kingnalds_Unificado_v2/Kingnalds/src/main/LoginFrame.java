package main;

import ConexionDB.ConexionDB;
import kingnalds.InicioFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Kingnald's - Inicio de Sesion");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel de fondo manteniendo GridBagLayout
        BackgroundPanel mainPanel = new BackgroundPanel("fondo.png");
        mainPanel.setLayout(new GridBagLayout());

        // JLayeredPane para superponer el logo superior izquierdo sin mover el centro
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1280, 720));

        mainPanel.setBounds(0, 0, 1280, 720);
        mainPanel.add(createCardPanel());
        layeredPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);

        // Logo flotante en la esquina superior izquierda
        try {
            ImageIcon rawIcon = new ImageIcon(getClass().getResource("logo.png"));
            Image scaledImg = rawIcon.getImage().getScaledInstance(65, 85, Image.SCALE_SMOOTH);
            JLabel lblLogo = new JLabel(new ImageIcon(scaledImg));
            lblLogo.setBounds(30, 25, 65, 85);
            layeredPane.add(lblLogo, JLayeredPane.PALETTE_LAYER);
        } catch (Exception e) {
            System.out.println("No se pudo cargar el logo: " + e.getMessage());
        }

        add(layeredPane);
    }

    private JPanel createCardPanel() {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = getWidth();
                int h = getHeight();

                // 1. Fondo semitransparente oscuro
                g2.setColor(new Color(18, 22, 25, 215));
                g2.fillRoundRect(12, 12, w - 24, h - 24, 12, 12);

                // Colores para el marco
                Color goldDark = new Color(110, 90, 45);
                Color goldBright = new Color(185, 150, 75);

                // 2. Borde exterior
                g2.setColor(goldDark);
                g2.drawRoundRect(12, 12, w - 25, h - 25, 12, 12);

                // 3. Borde interior
                g2.setColor(new Color(139, 115, 53, 160));
                g2.drawRoundRect(17, 17, w - 35, h - 35, 8, 8);

                // 4. Detalle decorativo en las 4 esquinas
                int cSize = 10;
                // Arriba Izquierda
                g2.drawLine(14, 14, 14 + cSize, 14);
                g2.drawLine(14, 14, 14, 14 + cSize);
                // Arriba Derecha
                g2.drawLine(w - 15, 14, w - 15 - cSize, 14);
                g2.drawLine(w - 15, 14, w - 15, 14 + cSize);
                // Abajo Izquierda
                g2.drawLine(14, h - 15, 14 + cSize, h - 15);
                g2.drawLine(14, h - 15, 14, h - 15 - cSize);
                // Abajo Derecha
                g2.drawLine(w - 15, h - 15, w - 15 - cSize, h - 15);
                g2.drawLine(w - 15, h - 15, w - 15, h - 15 - cSize);

                // 5. Medallas circulares integradas
                drawBadge(g2, w / 2, 12, goldBright, goldDark);
                drawBadge(g2, w / 2, h - 12, goldBright, goldDark);

                g2.dispose();
            }

            private void drawBadge(Graphics2D g2, int centerX, int centerY, Color goldBright, Color goldDark) {
                int radius = 13;

                // Fondo semitransparente de la medalla
                g2.setColor(new Color(18, 22, 25, 240));
                g2.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

                // Anillos dorados
                g2.setColor(goldBright);
                g2.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
                g2.setColor(goldDark);
                g2.drawOval(centerX - radius + 2, centerY - radius + 2, (radius - 2) * 2, (radius - 2) * 2);

                // Corona proporcionada al centro del círculo
                g2.setColor(goldBright);
                int[] xPoints = {centerX - 5, centerX - 7, centerX - 2, centerX, centerX + 2, centerX + 7, centerX + 5};
                int[] yPoints = {centerY + 3, centerY - 3, centerY, centerY - 5, centerY, centerY - 3, centerY + 3};
                g2.fillPolygon(xPoints, yPoints, 7);
                g2.fillRect(centerX - 5, centerY + 4, 10, 2);
            }
        };

        card.setOpaque(false);
        card.setPreferredSize(new Dimension(440, 480)); // Reducida la altura para adaptarse al contenido
        card.setLayout(null);

        // --- COMPONENTES AJUSTADOS VERTICALMENTE AL NUEVO TAMAÑO ---

        // Encabezados
        JLabel lblHeader = new JLabel("KINGNALD'S", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Serif", Font.BOLD, 18));
        lblHeader.setForeground(new Color(210, 210, 210));
        lblHeader.setBounds(0, 40, 440, 25);
        card.add(lblHeader);

        JLabel lblSubHeader = new JLabel("ÚNETE A LA CASA REAL", SwingConstants.CENTER);
        lblSubHeader.setFont(new Font("SansSerif", Font.PLAIN, 10));
        lblSubHeader.setForeground(new Color(140, 140, 140));
        lblSubHeader.setBounds(0, 70, 440, 15);
        card.add(lblSubHeader);

        JLabel lblTitle = new JLabel("Incia Seion", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(0, 90, 440, 30);
        card.add(lblTitle);

        JLabel lblSubtitle = new JLabel("Comienza tu viaje y reclama tu mesa.", SwingConstants.CENTER);
        lblSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblSubtitle.setForeground(new Color(160, 160, 160));
        lblSubtitle.setBounds(0, 120, 440, 20);
        card.add(lblSubtitle);

        // Campo 2: NOMBRE DE USUARIO
        JLabel lblUsername = new JLabel("Nombre de Usuario");
        lblUsername.setFont(new Font("SansSerif", Font.BOLD, 10));
        lblUsername.setForeground(new Color(180, 180, 180));
        lblUsername.setBounds(40, 170, 360, 15);
        card.add(lblUsername);

        JTextField txtUsername = new JTextField();
        styleTextField(txtUsername);
        txtUsername.setBounds(40, 195, 360, 33);
        card.add(txtUsername);

        // Campo 3: CONTRASEÑA
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 10));
        lblPassword.setForeground(new Color(180, 180, 180));
        lblPassword.setBounds(40, 245, 360, 15);
        card.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        styleTextField(txtPassword);
        txtPassword.setBounds(40, 265, 360, 33);
        card.add(txtPassword);

        // Botón Principal
        JButton btnRegister = new JButton("Iniciar Sesion");
        btnRegister.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnRegister.setBackground(new Color(200, 162, 81));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setFocusPainted(false);
        btnRegister.setBorder(null);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.setBounds(40, 340, 360, 40);
        btnRegister.addActionListener(e -> {

    String usuario = txtUsername.getText().trim();
    String contrasena = new String(txtPassword.getPassword());

    if (usuario.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(
                this,
                "Por favor, ingresa tu usuario y contraseña.",
                "Campos vacíos",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    String sql = "SELECT nombre FROM Usuario WHERE usuario = ? AND contrasena = ?";

    try {
        Connection conexion = ConexionDB.obtenerConexion();

        if (conexion == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo conectar con la base de datos.",
                    "Error de conexión",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try (PreparedStatement pst = conexion.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, contrasena);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    String nombre = rs.getString("nombre");

                    JOptionPane.showMessageDialog(
                            this,
                            "¡Bienvenido, " + nombre + "!",
                            "Inicio de sesión exitoso",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    // Abrir la pantalla principal de Kingnald's
                    InicioFrame inicio = new InicioFrame();
                    inicio.setVisible(true);
                    dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Usuario o contraseña incorrectos.",
                            "Error de inicio de sesión",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Error al consultar la base de datos:\n" + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
});
        card.add(btnRegister);

        return card;
    }

    private void styleTextField(JTextField field) {
        field.setBackground(new Color(25, 28, 32));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(60, 60, 60), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
}
