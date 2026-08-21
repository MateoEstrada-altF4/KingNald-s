package main;

import java.awt.*;
import javax.swing.*;

public class GestionUsuariosFrame extends JFrame {

    private UsuariosTablePanel tabla;
    private UsuarioFormPanel formulario;
    private UsuarioController controller;

    public GestionUsuariosFrame() {

        controller = new UsuarioController();

        configurarVentana();

        construirInterfaz();
    }

    // ============================================================
    // CONFIGURACIÓN
    // ============================================================
    private void configurarVentana() {

        setTitle(
                "KingNald's - Gestión de Usuarios"
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setMinimumSize(
                new Dimension(1000, 600)
        );

        setSize(
                1280, 720
        );

        setLocationRelativeTo(null);

        setBackground(
                new Color(7, 8, 11)
        );
    }

    // ============================================================
    // INTERFAZ
    // ============================================================
    private void construirInterfaz() {

        JPanel root
                = new JPanel(
                        new BorderLayout()
                );

        root.setBackground(
                new Color(7, 8, 11)
        );

        // ========================================================
        // SIDEBAR
        // ========================================================
        SidebarPanel sidebar
                = new SidebarPanel();

        root.add(
                sidebar,
                BorderLayout.WEST
        );

        // ========================================================
        // PANEL DERECHO
        // ========================================================
        UserInfoPanel userInfo
                = new UserInfoPanel();

        root.add(
                userInfo,
                BorderLayout.EAST
        );

        // ========================================================
        // CENTRO
        // ========================================================
        JPanel centro
                = new JPanel(
                        new BorderLayout(0, 12)
                );

        centro.setBackground(
                new Color(7, 8, 11)
        );

        centro.setBorder(
                BorderFactory.createEmptyBorder(
                        26,
                        26,
                        20,
                        22
                )
        );

        // --------------------------------------------------------
        // HEADER
        // --------------------------------------------------------
        HeaderPanel header
                = new HeaderPanel();

        centro.add(
                header,
                BorderLayout.NORTH
        );

        // --------------------------------------------------------
        // TABLA
        // --------------------------------------------------------
        tabla
                = new UsuariosTablePanel(controller);

        centro.add(
                tabla,
                BorderLayout.CENTER
        );

        // --------------------------------------------------------
        // INFORMACIÓN DEL USUARIO
        // --------------------------------------------------------
        formulario
                = new UsuarioFormPanel();
        formulario.setPreferredSize(
                new Dimension(
                        520,
                        220
                )
        );

        centro.add(
                formulario,
                BorderLayout.SOUTH
        );
        tabla.getTablaUsuarios()
        .getSelectionModel()
        .addListSelectionListener(e -> {

            if (e.getValueIsAdjusting()) {
                return;
            }

            int fila =
                    tabla.getTablaUsuarios()
                    .getSelectedRow();

            if (fila < 0) {
                return;
            }

            int filaModelo =
                    tabla.getTablaUsuarios()
                    .convertRowIndexToModel(fila);

            UsuarioController.Usuario usuario =
                    controller.obtenerUsuario(filaModelo);

            formulario.cargarUsuario(usuario);
        });
        
        

        // ========================================================
        // AGREGAR CENTRO
        // ========================================================
        root.add(
                centro,
                BorderLayout.CENTER
        );

        // ========================================================
        // MOSTRAR
        // ========================================================
        setContentPane(root);
    }
}
