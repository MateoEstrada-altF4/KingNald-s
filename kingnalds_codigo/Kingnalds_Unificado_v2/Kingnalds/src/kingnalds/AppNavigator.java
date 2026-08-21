package kingnalds;

import java.awt.*;
import javax.swing.*;

public class AppNavigator {
    private final Window parent;
    public AppNavigator(Window parent){this.parent=parent;}
    public void abrirInicio(){message("Estás en la página de inicio");}
    public void abrirMenu(){message("Aquí conectarás tu formulario MenuFrame");}
    public void abrirPromociones(){message("Aquí conectarás PromocionesFrame");}
    public void abrirPedidos(){message("Todavía no tienes pedidos registrados");}
    public void abrirMas(){message("Próximamente: perfil, sucursales y ayuda");}
    public void abrirCarrito(){new EmptyCartDialog(parent,this::abrirMenu).setVisible(true);}
    public void abrirDesayunos(){message("Abriendo desayunos — disponibles hasta las 11:00 AM");}
    public void ordenarAlmuerzo(){message("Abriendo almuerzos y cenas — disponibles desde las 12:00 PM");}
    public void abrirCombos(){message("Abriendo combos para compartir");}
    public void pedirAhora(){message("Entrega seleccionada: lo antes posible");}
    public void programarPedido(){String value=JOptionPane.showInputDialog(parent,"Ingresa fecha y hora (ejemplo: 22/08/2026 13:30):","Programar pedido",JOptionPane.PLAIN_MESSAGE);if(value!=null&&!value.trim().isEmpty())message("Pedido programado para "+value.trim());}
    private void message(String text){JOptionPane.showMessageDialog(parent,text,"KINGNALD'S",JOptionPane.INFORMATION_MESSAGE);}
}

class EmptyCartDialog extends JDialog {
    EmptyCartDialog(Window owner,Runnable goToMenu){super(owner,"Tu carrito",Dialog.ModalityType.APPLICATION_MODAL);setUndecorated(true);RoundedPanel card=new RoundedPanel(new Color(14,15,15),Theme.GOLD);card.setLayout(new BorderLayout(10,10));card.setBorder(BorderFactory.createEmptyBorder(28,38,28,38));card.add(new JLabel(new VectorIcon(VectorIcon.Type.CART,72,Theme.GOLD),SwingConstants.CENTER),BorderLayout.NORTH);JLabel text=new JLabel("<html><center><span style='font-size:20px'>Tu carrito está vacío</span><br><br><span style='color:#999999'>Agrega un producto del menú<br>para comenzar tu banquete.</span></center></html>",SwingConstants.CENTER);text.setFont(Theme.serif(Font.PLAIN,16));text.setForeground(Theme.IVORY);card.add(text,BorderLayout.CENTER);ModernButton menu=new ModernButton("EXPLORAR EL MENÚ",true);menu.setIcon(new VectorIcon(VectorIcon.Type.MENU,18,Theme.GOLD_LIGHT));menu.addActionListener(e->{dispose();goToMenu.run();});ModernButton close=new ModernButton("CERRAR",false);close.addActionListener(e->dispose());JPanel actions=new JPanel(new FlowLayout(FlowLayout.CENTER,8,0));actions.setOpaque(false);actions.add(close);actions.add(menu);card.add(actions,BorderLayout.SOUTH);setContentPane(card);setSize(410,350);setLocationRelativeTo(owner);}
}
