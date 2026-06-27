/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
/**
 *
 * @author Xavier
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin123";

    public static Connection obtenerConexion() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());

        }

        return conexion;

    }
}
