/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Xavier
 */
public class EmailService {
    public void enviarConfirmacion(String cliente,
            String correo,
            double total) {

        System.out.println("Enviando correo a " + correo + "...");

        System.out.println("Asunto: Confirmacion de pedido");

        System.out.println("Cuerpo: Estimado "
                + cliente
                + ", su pedido por $"
                + total
                + " ha sido procesado.");

    }

    public void enviarCancelacion(String cliente,
            String correo,
            int idPedido) {

        System.out.println("Enviando correo a " + correo + "...");

        System.out.println("Asunto: Cancelacion de pedido");

        System.out.println("Cuerpo: Estimado "
                + cliente
                + ", su pedido #"
                + idPedido
                + " ha sido cancelado.");

    }
}
