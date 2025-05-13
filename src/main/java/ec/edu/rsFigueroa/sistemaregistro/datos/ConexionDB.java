package ec.edu.rsFigueroa.sistemaregistro.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static Connection AbrirConexion() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/persona_database", "root", "");
        } catch (SQLException ex) {
            return null;
        }
    }

    public static void CerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex + "no se cerro la conexion");
            }
        }
    }
}
