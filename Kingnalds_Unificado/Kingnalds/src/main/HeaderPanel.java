package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HeaderPanel extends JPanel {

    // ============================================================
    // COLORES
    // ============================================================

    private static final Color BG_DARK =
            new Color(7, 8, 11);

    private static final Color BG_FIELD =
            new Color(13, 14, 18);

    private static final Color BORDER =
            new Color(55, 56, 63);

    private static final Color GOLD =
            new Color(215, 176, 82);

    private static final Color GOLD_LIGHT =
            new Color(239, 202, 107);

    private static final Color BURGUNDY =
            new Color(91, 12, 42);

    private static final Color BURGUNDY_HOVER =
            new Color(116, 18, 53);

    private static final Color TEXT =
            new Color(235, 235, 238);

    private static final Color TEXT_SECONDARY =
            new Color(164, 165, 172);

    // ============================================================
    // COMPONENTES
    // ============================================================

    private JTextField txtBuscar;

    private JComboBox<String> comboFiltroRol;

    private JComboBox<String> comboEstado;

    private JButton btnNuevo;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public HeaderPanel() {

        setLayout(null);

        setPreferredSize(
                new Dimension(0, 105)
        );

        setBackground(BG_DARK);

        construirInterfaz();
    }

    // ============================================================
    // CONSTRUIR INTERFAZ
    // ============================================================

    private void construirInterfaz() {

        // --------------------------------------------------------
        // TÍTULO
        // --------------------------------------------------------

        JLabel titulo = new JLabel(
                "GESTIÓN DE USUARIOS"
        );

        titulo.setForeground(Color.WHITE);

        titulo.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        27
                )
        );

        titulo.setBounds(
                0,
                0,
                400,
                40
        );

        add(titulo);

        // --------------------------------------------------------
        // BUSCADOR
        // --------------------------------------------------------

        txtBuscar = crearTextField(
                "Buscar usuario..."
        );

        txtBuscar.setBounds(
                0,
                55,
                205,
                32
        );

        add(txtBuscar);

        // --------------------------------------------------------
        // FILTRO DE ROL
        // --------------------------------------------------------

        comboFiltroRol = crearComboBox(
                new String[]{
                    "Todos los roles",
                    "Administrador",
                    "Cajero",
                    "Empleado"
                }
        );

        comboFiltroRol.setBounds(
                215,
                55,
                125,
                32
        );

        add(comboFiltroRol);

        // --------------------------------------------------------
        // FILTRO DE ESTADO
        // --------------------------------------------------------

        comboEstado = crearComboBox(
                new String[]{
                    "Todos los usuarios",
                    "Activos",
                    "Inactivos"
                }
        );

        comboEstado.setBounds(
                350,
                55,
                135,
                32
        );

        add(comboEstado);

        // --------------------------------------------------------
        // BOTÓN NUEVO USUARIO
        // --------------------------------------------------------

        btnNuevo = crearBoton(
                "+  NUEVO USUARIO",
                GOLD,
                Color.BLACK
        );

        btnNuevo.setBounds(
                495,
                55,
                145,
                32
        );

        add(btnNuevo);
    }

    // ============================================================
    // TEXTFIELD
    // ============================================================

    private JTextField crearTextField(
            String placeholder
    ) {

        JTextField campo =
                new JTextField();

        campo.setText(placeholder);

        campo.setForeground(
                TEXT_SECONDARY
        );

        campo.setBackground(
                BG_FIELD
        );

        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        campo.setCaretColor(
                Color.WHITE
        );

        campo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                0,
                                9,
                                0,
                                9
                        )
                )
        );

        campo.addFocusListener(
                new FocusAdapter() {

            @Override
            public void focusGained(
                    FocusEvent e
            ) {

                if (campo.getText().equals(
                        placeholder
                )) {

                    campo.setText("");
                }

                campo.setForeground(Color.WHITE);

                campo.setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(
                                        GOLD
                                ),
                                BorderFactory.createEmptyBorder(
                                        0,
                                        9,
                                        0,
                                        9
                                )
                        )
                );
            }

            @Override
            public void focusLost(
                    FocusEvent e
            ) {

                if (campo.getText().trim().isEmpty()) {

                    campo.setText(
                            placeholder
                    );

                    campo.setForeground(
                            TEXT_SECONDARY
                    );
                }

                campo.setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(
                                        BORDER
                                ),
                                BorderFactory.createEmptyBorder(
                                        0,
                                        9,
                                        0,
                                        9
                                )
                        )
                );
            }
        });

        return campo;
    }

    // ============================================================
    // COMBOBOX
    // ============================================================

    private JComboBox<String> crearComboBox(
            String[] elementos
    ) {

        JComboBox<String> combo =
                new JComboBox<>(elementos);

        combo.setBackground(
                BG_FIELD
        );

        combo.setForeground(
                TEXT
        );

        combo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        combo.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        combo.setFocusable(false);

        return combo;
    }

    // ============================================================
    // BOTÓN
    // ============================================================

    private JButton crearBoton(
            String texto,
            Color fondo,
            Color textoColor
    ) {

        JButton boton =
                new JButton(texto) {

            private boolean hover = false;

            private boolean pressed = false;

            {
                addMouseListener(
                        new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        hover = true;

                        repaint();
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        hover = false;

                        repaint();
                    }

                    @Override
                    public void mousePressed(
                            MouseEvent e
                    ) {

                        pressed = true;

                        repaint();
                    }

                    @Override
                    public void mouseReleased(
                            MouseEvent e
                    ) {

                        pressed = false;

                        repaint();
                    }
                });
            }

            @Override
            protected void paintComponent(
                    Graphics g
            ) {

                Graphics2D g2 =
                        (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                Color actual = fondo;

                if (hover) {

                    if (fondo.equals(GOLD)) {

                        actual = GOLD_LIGHT;

                    } else {

                        actual = BURGUNDY_HOVER;
                    }
                }

                if (pressed) {

                    actual = fondo.darker();
                }

                g2.setColor(actual);

                g2.fillRoundRect(
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        7,
                        7
                );

                g2.dispose();

                super.paintComponent(g);
            }
        };

        boton.setForeground(
                textoColor
        );

        boton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );

        boton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        boton.setContentAreaFilled(false);

        boton.setFocusPainted(false);

        boton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        boton.setOpaque(false);

        return boton;
    }

    // ============================================================
    // GETTERS
    // ============================================================

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public JComboBox<String> getComboFiltroRol() {
        return comboFiltroRol;
    }

    public JComboBox<String> getComboEstado() {
        return comboEstado;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }
}