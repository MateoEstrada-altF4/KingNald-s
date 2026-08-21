package main;

import java.awt.*;
import javax.swing.*;

public class UsuarioFormPanel extends RoundedPanel {

    private static final Color TEXT
            = new Color(235, 235, 238);

    private static final Color TEXT_SECONDARY
            = new Color(164, 165, 172);

    private static final Color BG_FIELD
            = new Color(13, 14, 18);

    private static final Color BORDER
            = new Color(55, 56, 63);

    private static final Color BURGUNDY
            = new Color(91, 12, 42);

    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtFecha;
    private JTextField txtID;

    private JComboBox<String> comboRol;

    private JButton btnGuardar;

    public UsuarioFormPanel() {

        super(12);

        setBackgroundColor(
                new Color(18, 19, 23)
        );

        setBorderColor(
                new Color(65, 66, 73)
        );

        construirFormulario();
    }

    private void construirFormulario() {

        // ========================================================
        // TÍTULO
        // ========================================================
        JLabel titulo = crearLabel(
                "EDIT USER",
                Color.WHITE,
                Font.BOLD,
                14
        );

        titulo.setBounds(
                15, 12, 250, 25
        );

        add(titulo);

        // ========================================================
        // NOMBRE
        // ========================================================
        JLabel lblNombre = crearLabel(
                "Nombre",
                TEXT_SECONDARY,
                Font.PLAIN,
                10
        );

        lblNombre.setBounds(
                15, 50, 230, 18
        );

        add(lblNombre);

        txtNombre = crearCampo(
                "Nombre del usuario"
        );

        txtNombre.setBounds(
                15, 68, 230, 30
        );

        add(txtNombre);

        // ========================================================
        // TELÉFONO
        // ========================================================
        JLabel lblTelefono = crearLabel(
                "Teléfono",
                TEXT_SECONDARY,
                Font.PLAIN,
                10
        );

        lblTelefono.setBounds(
                255, 50, 130, 18
        );

        add(lblTelefono);

        txtTelefono = crearCampo(
                "0000-0000"
        );

        txtTelefono.setBounds(
                255, 68, 130, 30
        );

        add(txtTelefono);

        // ========================================================
        // ROL
        // ========================================================
        JLabel lblRol = crearLabel(
                "Rol",
                TEXT_SECONDARY,
                Font.PLAIN,
                10
        );

        lblRol.setBounds(
                395, 50, 110, 18
        );

        add(lblRol);

        comboRol = new JComboBox<>(
                new String[]{
                    "Administrador",
                    "Cajero",
                    "Empleado"
                }
        );

        comboRol.setBounds(
                395, 68, 110, 30
        );

        comboRol.setBackground(BG_FIELD);
        comboRol.setForeground(TEXT);

        comboRol.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        comboRol.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        comboRol.setFocusable(false);

        add(comboRol);

        // ========================================================
        // DIRECCIÓN
        // ========================================================
        JLabel lblDireccion = crearLabel(
                "Dirección",
                TEXT_SECONDARY,
                Font.PLAIN,
                10
        );

        lblDireccion.setBounds(
                15, 105, 230, 18
        );

        add(lblDireccion);

        txtDireccion = crearCampo(
                "Dirección del usuario"
        );

        txtDireccion.setBounds(
                15, 123, 230, 30
        );

        add(txtDireccion);

        // ========================================================
        // FECHA
        // ========================================================
        JLabel lblFecha = crearLabel(
                "Fecha",
                TEXT_SECONDARY,
                Font.PLAIN,
                10
        );

        lblFecha.setBounds(
                255, 105, 130, 18
        );

        add(lblFecha);

        txtFecha = crearCampo(
                "dd/mm/aaaa"
        );

        txtFecha.setBounds(
                255, 123, 130, 30
        );

        add(txtFecha);

        // ========================================================
        // ID
        // ========================================================
        JLabel lblID = crearLabel(
                "ID Usuario",
                TEXT_SECONDARY,
                Font.PLAIN,
                10
        );

        lblID.setBounds(
                395, 105, 110, 18
        );

        add(lblID);

        txtID = crearCampo(
                "001"
        );

        txtID.setBounds(
                395, 123, 110, 30
        );

        txtID.setEditable(false);

        add(txtID);

        // ========================================================
        // BOTÓN
        // ========================================================
        btnGuardar = new JButton(
                "SAVE CHANGES"
        );

        btnGuardar.setBounds(
                15, 170, 490, 32
        );

        btnGuardar.setBackground(
                BURGUNDY
        );

        btnGuardar.setForeground(
                Color.WHITE
        );

        btnGuardar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );

        btnGuardar.setBorder(
                BorderFactory.createEmptyBorder()
        );

        btnGuardar.setFocusPainted(false);

        btnGuardar.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        add(btnGuardar);
    }

    // ============================================================
    // CREAR CAMPO
    // ============================================================
    private JTextField crearCampo(
            String valor
    ) {

        JTextField campo
                = new JTextField(valor);

        campo.setForeground(TEXT);

        campo.setBackground(BG_FIELD);

        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        campo.setCaretColor(Color.WHITE);

        campo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                0, 9, 0, 9
                        )
                )
        );

        return campo;
    }

    // ============================================================
    // CARGAR USUARIO
    // ============================================================
    public void cargarUsuario(
            UsuarioController.Usuario usuario
    ) {

        if (usuario == null) {
            return;
        }

        txtID.setText(
                usuario.getId()
        );

        txtNombre.setText(
                usuario.getNombre()
        );

        txtTelefono.setText(
                usuario.getTelefono()
        );

        txtDireccion.setText(
                usuario.getDireccion()
        );

        txtFecha.setText(
                usuario.getFecha()
        );

        comboRol.setSelectedItem(
                usuario.getRol()
        );
    }

    // ============================================================
    // GETTERS
    // ============================================================
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JComboBox<String> getComboRol() {
        return comboRol;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
// ============================================================
// CREAR LABEL
// ============================================================

    private JLabel crearLabel(
            String texto,
            Color color,
            int estilo,
            int tamaño
    ) {

        JLabel label
                = new JLabel(texto);

        label.setForeground(color);

        label.setFont(
                new Font(
                        "Segoe UI",
                        estilo,
                        tamaño
                )
        );

        return label;
    }
}
