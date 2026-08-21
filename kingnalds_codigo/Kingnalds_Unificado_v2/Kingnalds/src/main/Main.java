package main;

import ConexionDB.ConexionDB;
import java.sql.Connection;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Probar conexión con MySQL
        Connection conexion = ConexionDB.obtenerConexion();

        if (conexion != null) {
            System.out.println("=================================");
            System.out.println(" CONEXIÓN A MYSQL EXITOSA");
            System.out.println(" Base de datos: kingnalds");
            System.out.println("=================================");
        } else {
            System.out.println("=================================");
            System.out.println(" ERROR: NO SE PUDO CONECTAR A MYSQL");
            System.out.println("=================================");
        }

        // Crear la ventana en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginWindow = new LoginFrame();
            loginWindow.setVisible(true);
        });
    }
}