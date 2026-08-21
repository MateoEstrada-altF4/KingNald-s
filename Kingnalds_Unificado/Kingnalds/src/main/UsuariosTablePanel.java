package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class UsuariosTablePanel extends JPanel {

    // ============================================================
    // COLORES
    // ============================================================
    private static final Color BG_DARK
            = new Color(7, 8, 11);

    private static final Color BURGUNDY
            = new Color(91, 12, 42);

    private static final Color TEXT
            = new Color(235, 235, 238);

    // ============================================================
    // COMPONENTES
    // ============================================================
    private JTable tablaUsuarios;

    private DefaultTableModel modeloTabla;
    private UsuarioController controller;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================
    public UsuariosTablePanel(UsuarioController controller) {

        this.controller = controller;

        setLayout(new BorderLayout());

        setBackground(BG_DARK);

        construirTabla();

        cargarTabla();
    }

    // ============================================================
    // CONSTRUIR TABLA
    // ============================================================
    private void construirTabla() {

        // --------------------------------------------------------
        // MODELO
        // --------------------------------------------------------
        modeloTabla = new DefaultTableModel(
                new Object[]{
                    "",
                    "ID",
                    "NOMBRE",
                    "TELÉFONO",
                    "DIRECCIÓN",
                    "FECHA",
                    "ROL",
                    "ACCIONES"
                },
                0
        ) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {

                return false;
            }
        };

        // --------------------------------------------------------
        // TABLA
        // --------------------------------------------------------
        tablaUsuarios
                = new JTable(modeloTabla);

        configurarTabla();

        // --------------------------------------------------------
        // SCROLL
        // --------------------------------------------------------
        JScrollPane scroll
                = new JScrollPane(
                        tablaUsuarios
                );

        scroll.setBorder(null);

        scroll.getViewport().setBackground(
                BG_DARK
        );

        scroll.setBackground(
                BG_DARK
        );

        add(
                scroll,
                BorderLayout.CENTER
        );
    }

    // ============================================================
    // CONFIGURACIÓN
    // ============================================================
    private void configurarTabla() {

        tablaUsuarios.setBackground(
                new Color(14, 15, 19)
        );

        tablaUsuarios.setForeground(
                TEXT
        );

        tablaUsuarios.setSelectionBackground(
                BURGUNDY
        );

        tablaUsuarios.setSelectionForeground(
                Color.WHITE
        );

        tablaUsuarios.setRowHeight(38);

        tablaUsuarios.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        tablaUsuarios.setShowGrid(false);

        tablaUsuarios.setIntercellSpacing(
                new Dimension(0, 2)
        );

        tablaUsuarios.setFillsViewportHeight(true);

        tablaUsuarios.setAutoCreateRowSorter(true);

        // --------------------------------------------------------
        // HEADER
        // --------------------------------------------------------
        JTableHeader header
                = tablaUsuarios.getTableHeader();

        header.setPreferredSize(
                new Dimension(0, 34)
        );

        header.setBackground(
                new Color(24, 25, 30)
        );

        header.setForeground(
                new Color(185, 185, 190)
        );

        header.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );

        header.setReorderingAllowed(false);

        // --------------------------------------------------------
        // ANCHOS
        // --------------------------------------------------------
        tablaUsuarios.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(25);

        tablaUsuarios.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(45);

        tablaUsuarios.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(125);

        tablaUsuarios.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(100);

        tablaUsuarios.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(160);

        tablaUsuarios.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(90);

        tablaUsuarios.getColumnModel()
                .getColumn(6)
                .setPreferredWidth(100);

        tablaUsuarios.getColumnModel()
                .getColumn(7)
                .setPreferredWidth(80);

        // --------------------------------------------------------
        // RENDERER
        // --------------------------------------------------------
        TableCellRenderer renderer
                = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column
            ) {

                JLabel label
                        = (JLabel) super.getTableCellRendererComponent(
                                table,
                                value,
                                isSelected,
                                hasFocus,
                                row,
                                column
                        );

                label.setBorder(
                        new EmptyBorder(
                                0,
                                7,
                                0,
                                7
                        )
                );

                if (isSelected) {

                    label.setBackground(
                            BURGUNDY
                    );

                    label.setForeground(
                            Color.WHITE
                    );

                } else {

                    label.setBackground(
                            row % 2 == 0
                                    ? new Color(15, 16, 20)
                                    : new Color(19, 20, 24)
                    );

                    label.setForeground(
                            TEXT
                    );
                }

                return label;
            }
        };

        tablaUsuarios.setDefaultRenderer(
                Object.class,
                renderer
        );
    }

    private void cargarTabla() {

        modeloTabla.setRowCount(0);

        for (UsuarioController.Usuario usuario
                : controller.getUsuarios()) {

            modeloTabla.addRow(
                    new Object[]{
                        "□",
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getTelefono(),
                        usuario.getDireccion(),
                        usuario.getFecha(),
                        usuario.getRol(),
                        "✎   🗑"
                    }
            );
        }
    }

    // ============================================================
    // GETTERS
    // ============================================================
    public JTable getTablaUsuarios() {

        return tablaUsuarios;
    }

    public DefaultTableModel getModeloTabla() {

        return modeloTabla;
    }
}
