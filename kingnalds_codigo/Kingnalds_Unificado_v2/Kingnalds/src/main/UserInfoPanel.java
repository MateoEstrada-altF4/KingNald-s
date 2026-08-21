package main;

import java.awt.*;
import javax.swing.*;

public class UserInfoPanel extends JPanel {

    private static final Color BG_DARK =
            new Color(7, 8, 11);

    private static final Color BG_PANEL =
            new Color(18, 19, 23);

    private static final Color BORDER =
            new Color(55, 56, 63);

    private static final Color GOLD =
            new Color(215, 176, 82);

    private static final Color GOLD_LIGHT =
            new Color(239, 202, 107);

    private static final Color TEXT =
            new Color(235, 235, 238);

    private static final Color TEXT_SECONDARY =
            new Color(164, 165, 172);

    private JLabel lblUserName;
    private JLabel lblUserID;
    private JLabel lblUserPhone;
    private JLabel lblUserRole;
    private JLabel lblUserDate;
    private JLabel lblUserAddress;

    private JButton btnEditar;
    private JButton btnGuardar;

    public UserInfoPanel() {

        setLayout(null);

        setPreferredSize(
                new Dimension(190, 0)
        );

        setBackground(BG_DARK);

        construirInterfaz();
    }

    private void construirInterfaz() {

        // ========================================================
        // USER INFO
        // ========================================================

        RoundedPanel info =
                new RoundedPanel(11);

        info.setBackgroundColor(
                BG_PANEL
        );

        info.setBorderColor(
                BORDER
        );

        info.setBounds(
                8, 20, 174, 330
        );

        add(info);

        // --------------------------------------------------------
        // TÍTULO
        // --------------------------------------------------------

        JLabel titulo =
                crearLabel(
                        "User Info",
                        Color.WHITE,
                        Font.BOLD,
                        14
                );

        titulo.setBounds(
                12, 12, 120, 25
        );

        info.add(titulo);

        // --------------------------------------------------------
        // AVATAR
        // --------------------------------------------------------

        JLabel avatar =
                new JLabel("●");

        avatar.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        avatar.setForeground(GOLD);

        avatar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        38
                )
        );

        avatar.setBounds(
                55, 42, 65, 55
        );

        info.add(avatar);

        // --------------------------------------------------------
        // NOMBRE
        // --------------------------------------------------------

        lblUserName =
                crearLabel(
                        "Seleccione un usuario",
                        Color.WHITE,
                        Font.BOLD,
                        13
                );

        lblUserName.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        lblUserName.setBounds(
                10, 98, 154, 25
        );

        info.add(lblUserName);

        // --------------------------------------------------------
        // ID
        // --------------------------------------------------------

        lblUserID =
                crearLabel(
                        "ID: ---",
                        TEXT_SECONDARY,
                        Font.PLAIN,
                        10
                );

        lblUserID.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        lblUserID.setBounds(
                10, 122, 154, 20
        );

        info.add(lblUserID);

        // --------------------------------------------------------
        // SEPARADOR
        // --------------------------------------------------------

        JPanel linea =
                new JPanel();

        linea.setBackground(
                new Color(50, 51, 56)
        );

        linea.setBounds(
                12, 150, 150, 1
        );

        info.add(linea);

        // --------------------------------------------------------
        // TELÉFONO
        // --------------------------------------------------------

        crearDato(
                info,
                "Teléfono",
                160
        );

        lblUserPhone =
                crearLabel(
                        "---",
                        TEXT,
                        Font.PLAIN,
                        10
                );

        lblUserPhone.setBounds(
                85, 160, 70, 20
        );

        info.add(lblUserPhone);

        // --------------------------------------------------------
        // ROL
        // --------------------------------------------------------

        crearDato(
                info,
                "Rol",
                190
        );

        lblUserRole =
                crearLabel(
                        "---",
                        GOLD_LIGHT,
                        Font.BOLD,
                        10
                );

        lblUserRole.setBounds(
                85, 190, 70, 20
        );

        info.add(lblUserRole);

        // --------------------------------------------------------
        // FECHA
        // --------------------------------------------------------

        crearDato(
                info,
                "Fecha",
                220
        );

        lblUserDate =
                crearLabel(
                        "---",
                        TEXT,
                        Font.PLAIN,
                        10
                );

        lblUserDate.setBounds(
                85, 220, 70, 20
        );

        info.add(lblUserDate);

        // --------------------------------------------------------
        // DIRECCIÓN
        // --------------------------------------------------------

        crearDato(
                info,
                "Dirección",
                250
        );

        lblUserAddress =
                crearLabel(
                        "---",
                        TEXT,
                        Font.PLAIN,
                        9
                );

        lblUserAddress.setBounds(
                85, 250, 75, 40
        );

        info.add(lblUserAddress);

        // ========================================================
        // BOTÓN EDIT
        // ========================================================

        btnEditar =
                crearBoton(
                        "EDIT",
                        new Color(31, 32, 37),
                        TEXT
                );

        btnEditar.setBounds(
                12, 295, 70, 27
        );

        info.add(btnEditar);

        // ========================================================
        // BOTÓN SAVE
        // ========================================================

        btnGuardar =
                crearBoton(
                        "SAVE",
                        GOLD,
                        Color.BLACK
                );

        btnGuardar.setBounds(
                88, 295, 70, 27
        );

        info.add(btnGuardar);

        // ========================================================
        // USER DETAILS
        // ========================================================

        RoundedPanel detalles =
                new RoundedPanel(11);

        detalles.setBackgroundColor(
                BG_PANEL
        );

        detalles.setBorderColor(
                BORDER
        );

        detalles.setBounds(
                8, 365, 174, 175
        );

        add(detalles);

        // --------------------------------------------------------
        // TÍTULO
        // --------------------------------------------------------

        JLabel tituloDetalle =
                crearLabel(
                        "User Details",
                        Color.WHITE,
                        Font.BOLD,
                        13
                );

        tituloDetalle.setBounds(
                12, 12, 140, 25
        );

        detalles.add(tituloDetalle);

        // --------------------------------------------------------
        // ROL ASIGNADO
        // --------------------------------------------------------

        JLabel info1 =
                crearLabel(
                        "Rol asignado",
                        TEXT_SECONDARY,
                        Font.PLAIN,
                        10
                );

        info1.setBounds(
                12, 48, 140, 18
        );

        detalles.add(info1);

        JLabel info2 =
                crearLabel(
                        "Administrador",
                        TEXT,
                        Font.BOLD,
                        10
                );

        info2.setBounds(
                12, 67, 140, 20
        );

        detalles.add(info2);

        // --------------------------------------------------------
        // INFORMACIÓN
        // --------------------------------------------------------

        JLabel info3 =
                crearLabel(
                        "Información",
                        TEXT_SECONDARY,
                        Font.PLAIN,
                        10
                );

        info3.setBounds(
                12, 95, 140, 18
        );

        detalles.add(info3);

        JLabel info4 =
                crearLabel(
                        "<html>Usuario registrado<br>"
                        + "en KingNald's</html>",
                        TEXT,
                        Font.PLAIN,
                        10
                );

        info4.setBounds(
                12, 115, 145, 40
        );

        detalles.add(info4);
    }

    // ============================================================
    // DATO
    // ============================================================

    private void crearDato(
            JPanel parent,
            String texto,
            int y
    ) {

        JLabel label =
                crearLabel(
                        texto,
                        TEXT_SECONDARY,
                        Font.PLAIN,
                        10
                );

        label.setBounds(
                12, y, 70, 20
        );

        parent.add(label);
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
                new JButton(texto);

        boton.setForeground(
                textoColor
        );

        boton.setBackground(
                fondo
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

        boton.setFocusPainted(false);

        boton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return boton;
    }

    // ============================================================
    // LABEL
    // ============================================================

    private JLabel crearLabel(
            String texto,
            Color color,
            int estilo,
            int tamaño
    ) {

        JLabel label =
                new JLabel(texto);

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

    // ============================================================
    // GETTERS
    // ============================================================

    public JLabel getLblUserName() {
        return lblUserName;
    }

    public JLabel getLblUserID() {
        return lblUserID;
    }

    public JLabel getLblUserPhone() {
        return lblUserPhone;
    }

    public JLabel getLblUserRole() {
        return lblUserRole;
    }

    public JLabel getLblUserDate() {
        return lblUserDate;
    }

    public JLabel getLblUserAddress() {
        return lblUserAddress;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
}