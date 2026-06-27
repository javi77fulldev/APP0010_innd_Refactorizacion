/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descuentos;

/**
 *
 * @author Xavier
 */
public class FrecuenteStrategy implements DescuentoStrategy {

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.10;
    }

}
