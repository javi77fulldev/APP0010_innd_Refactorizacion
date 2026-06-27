/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;

import java.sql.*;
/**
 *
 * @author Xavier
 */
public class PedidoRepository {
    private Connection conexion;

    public PedidoRepository(Connection conexion) {

        this.conexion = conexion;

    }

    public void guardarPedido(String cliente, double total) {

        String sql =
                "INSERT INTO pedidos(cliente,total) VALUES(?,?)";

        try {

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, cliente);
            ps.setDouble(2, total);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error al guardar pedido: "
                    + e.getMessage());

        }

    }

    public void cancelarPedido(int idPedido) {

        String sql =
                "DELETE FROM pedidos WHERE id=?";

        try {

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setInt(1, idPedido);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error al cancelar pedido: "
                    + e.getMessage());

        }

    }
}
