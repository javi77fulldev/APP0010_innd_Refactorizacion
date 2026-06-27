/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validator;

/**
 *
 * @author Xavier
 */
public class ClienteValidator {
    public boolean validarNombre(String nombreCliente) {
        return nombreCliente != null && !nombreCliente.trim().isEmpty();
    }

    public boolean validarEmail(String emailCliente) {
        return emailCliente != null && emailCliente.contains("@");
    }
}
