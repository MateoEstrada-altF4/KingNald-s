package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/kingnalds";
    private static final String USER = "root";
    private static final String PASS = "123456789";

    private static Connection con = null;

    /**
     * Método estático centralizado que solicita o reutiliza la conexión activa.
     */
    public static Connection obtenerConexion() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(URL, USER, PASS);

                System.out.println("[DB LOG] Conexión establecida con éxito.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("[DB ERROR] Driver MySQL no localizado: " + e.getMessage());

        } catch (SQLException e) {
            System.err.println("[DB ERROR] Error de conexión: " + e.getMessage());
        }

        return con;
    }

    /**
     * Ejecuta sentencias INSERT, UPDATE o DELETE.
     */
    public int ejecutarsentenciaSQL(String strSentenciaSQL) {
        try {
            Connection conexion = obtenerConexion();

            if (conexion != null) {
                try (PreparedStatement pstm =
                        conexion.prepareStatement(strSentenciaSQL)) {

                    pstm.execute();
                    return 1;
                }
            }

            return 0;

        } catch (SQLException e) {
            System.err.println(
                "[DB ERROR] Error al ejecutar sentencia: " + e.getMessage()
            );

            return 0;
        }
    }

    /**
     * Retorna los resultados de una consulta SELECT.
     */
    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {
            Connection conexion = obtenerConexion();

            if (conexion != null) {
                PreparedStatement pstm =
                        conexion.prepareStatement(strSentenciaSQL);

                return pstm.executeQuery();
            }

            return null;

        } catch (SQLException e) {
            System.err.println(
                "[DB ERROR] Error en consulta: " + e.getMessage()
            );

            return null;
        }
    }
}
