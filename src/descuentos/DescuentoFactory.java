/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descuentos;

/**
 *
 * @author Xavier
 */
public class DescuentoFactory {
    public static DescuentoStrategy obtenerStrategy(String tipoCliente) {

        switch (tipoCliente.toUpperCase()) {

            case "VIP":
                return new VipStrategy();

            case "FRECUENTE":
                return new FrecuenteStrategy();

            case "REGULAR":
                return new RegularStrategy();

            default:
                return new NuevoStrategy();

        }

    }
}
