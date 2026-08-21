package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SidebarPanel extends JPanel {

    // ============================================================
    // COLORES
    // ============================================================

    private static final Color GOLD =
            new Color(215, 176, 82);

    private static final Color GOLD_LIGHT =
            new Color(239, 202, 107);

    private static final Color BURGUNDY =
            new Color(91, 12, 42);

    private static final Color TEXT_SECONDARY =
            new Color(164, 165, 172);

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public SidebarPanel() {

        setLayout(null);

        setPreferredSize(
                new Dimension(150, 0)
        );

        setBackground(
                new Color(12, 13, 17)
        );

        crearInterfaz();
    }

    // ============================================================
    // CONSTRUIR SIDEBAR
    // ============================================================

    private void crearInterfaz() {

        // --------------------------------------------------------
        // SEPARADOR
        // --------------------------------------------------------

        JPanel separador = new JPanel();

        separador.setBackground(
                new Color(32, 33, 38)
        );

        separador.setBounds(
                149,
                0,
                1,
                1000
        );

        add(separador);

        // --------------------------------------------------------
        // CORONA
        // --------------------------------------------------------

        JLabel corona = new JLabel("♛");

        corona.setForeground(GOLD);

        corona.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        26
                )
        );

        corona.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        corona.setBounds(
                35,
                17,
                80,
                30
        );

        add(corona);

        // --------------------------------------------------------
        // LOGO
        // --------------------------------------------------------

        JLabel logo = new JLabel(
                "<html><center>KINGNALD'S</center></html>"
        );

        logo.setForeground(
                new Color(218, 207, 184)
        );

        logo.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        11
                )
        );

        logo.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        logo.setBounds(
                15,
                45,
                120,
                25
        );

        add(logo);

        // --------------------------------------------------------
        // MENÚ
        // --------------------------------------------------------

        int y = 100;

        crearBotonMenu(
                "⌂",
                "Dashboard",
                y,
                false
        );

        y += 40;

        crearBotonMenu(
                "▦",
                "Usuarios",
                y,
                true
        );

        y += 40;

        crearBotonMenu(
                "▤",
                "Pedidos",
                y,
                false
        );

        y += 40;

        crearBotonMenu(
                "▥",
                "Inventario",
                y,
                false
        );

        y += 40;

        crearBotonMenu(
                "♙",
                "Clientes",
                y,
                false
        );

        y += 40;

        crearBotonMenu(
                "$",
                "Ventas",
                y,
                false
        );

        y += 40;

        crearBotonMenu(
                "▥",
                "Reportes",
                y,
                false
        );
    }

    // ============================================================
    // BOTÓN DEL MENÚ
    // ============================================================

    private void crearBotonMenu(
            String icono,
            String texto,
            int y,
            boolean activo
    ) {

        JPanel boton = new JPanel(null) {

            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2 =
                        (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                if (activo) {

                    g2.setColor(BURGUNDY);

                    g2.fillRoundRect(
                            7,
                            0,
                            getWidth() - 14,
                            getHeight(),
                            5,
                            5
                    );
                }

                g2.dispose();

                super.paintComponent(g);
            }
        };

        boton.setOpaque(false);

        boton.setBounds(
                0,
                y,
                145,
                34
        );

        // --------------------------------------------------------
        // ICONO
        // --------------------------------------------------------

        JLabel lblIcono =
                new JLabel(icono);

        lblIcono.setForeground(
                activo
                        ? GOLD_LIGHT
                        : TEXT_SECONDARY
        );

        lblIcono.setFont(
                new Font(
                        "Segoe UI Symbol",
                        Font.PLAIN,
                        14
                )
        );

        lblIcono.setBounds(
                17,
                3,
                25,
                28
        );

        boton.add(lblIcono);

        // --------------------------------------------------------
        // TEXTO
        // --------------------------------------------------------

        JLabel lblTexto =
                new JLabel(texto);

        lblTexto.setForeground(
                activo
                        ? Color.WHITE
                        : TEXT_SECONDARY
        );

        lblTexto.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        lblTexto.setBounds(
                39,
                3,
                100,
                28
        );

        boton.add(lblTexto);

        // --------------------------------------------------------
        // HOVER
        // --------------------------------------------------------

        MouseAdapter mouse =
                new MouseAdapter() {

            @Override
            public void mouseEntered(
                    MouseEvent e
            ) {

                if (!activo) {

                    boton.setBackground(
                            new Color(
                                    24,
                                    25,
                                    30
                            )
                    );
                }
            }

            @Override
            public void mouseExited(
                    MouseEvent e
            ) {

                boton.setBackground(
                        new Color(
                                0,
                                0,
                                0,
                                0
                        )
                );
            }
        };

        boton.addMouseListener(mouse);

        add(boton);
    }
}