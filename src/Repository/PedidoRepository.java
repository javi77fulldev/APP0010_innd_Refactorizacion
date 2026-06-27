/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;

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
        
    }

    public void cancelarPedido(int idPedido) {       

    }
}
