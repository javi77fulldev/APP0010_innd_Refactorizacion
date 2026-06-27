/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Xavier
 */
public class LoggerService {
    public void registrarPedido(String cliente,
            double total) {

        System.out.println(
                "[LOG] Pedido procesado para "
                + cliente
                + " - Total: "
                + total);

    }

}
