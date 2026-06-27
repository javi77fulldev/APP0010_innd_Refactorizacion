/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.*;
import java.io.*;
import java.sql.*;
import Validator.ClienteValidator;
import descuentos.DescuentoStrategy;
import descuentos.VipStrategy;
import Calcular.CalculadoraPedido;
import Repository.PedidoRepository;
import Service.FacturaService;
import Service.EmailService;
import Service.LoggerService;
import Service.ConexionDB;
/**
 *
 * @author Xavier
 */
public class GestorPedidos 
{
    private Connection conexionBD;
    private ConexionDB ConexionBD;
    private ClienteValidator validator;
    private CalculadoraPedido calculadora;
    private PedidoRepository repository;
    private FacturaService facturaService;
    private EmailService emailService;
    private LoggerService loggerService;

    public GestorPedidos() {

        Connection conexion = ConexionBD.obtenerConexion();
        validator = new ClienteValidator();
        calculadora = new CalculadoraPedido();
        repository = new PedidoRepository(conexion);
        facturaService = new FacturaService();
        emailService = new EmailService();
        loggerService = new LoggerService();

    }            
    
    public void procesarPedido(String nombreCliente, String emailCliente,List<String> nombresProductos,List<Double> preciosProductos,List<Integer> cantidades,String tipoCliente) {
        ClienteValidator validator = new ClienteValidator();

        if (!validator.validarNombre(nombreCliente)) {
            System.out.println("Error: nombre de cliente invalido");
            return;
        }

        if (!validator.validarEmail(emailCliente)) {
            System.out.println("Error: email invalido");
            return;
        }
        double subtotal = 0;
        for (int i = 0; i < nombresProductos.size(); i++) {
        subtotal += preciosProductos.get(i) * cantidades.get(i);
        }
        double descuento = 0;
        DescuentoStrategy estrategia = new VipStrategy();

        descuento = estrategia.calcularDescuento(subtotal);
        
        double impuesto = (subtotal - descuento) * 0.12;
        double total = subtotal - descuento + impuesto;
        try {
            Statement stmt = conexionBD.createStatement();
            String sql = "INSERT INTO pedidos (cliente, total) VALUES ('"
            + nombreCliente + "', " + total + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido: " + e.getMessage());
        }
        try {
            FileWriter writer = new FileWriter("factura_" + nombreCliente + ".txt");
            writer.write("FACTURA\n");
            writer.write("Cliente: " + nombreCliente + "\n");
            for (int i = 0; i < nombresProductos.size(); i++) {
            writer.write(nombresProductos.get(i) + " x" + cantidades.get(i)
            + " = $" + (preciosProductos.get(i) * cantidades.get(i)) + "\n");
            }
            writer.write("Subtotal: $" + subtotal + "\n");
            writer.write("Descuento: $" + descuento + "\n");
            writer.write("Impuesto: $" + impuesto + "\n");
            writer.write("TOTAL: $" + total + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al generar la factura: " + e.getMessage());
        }
        System.out.println("Enviando correo a " + emailCliente + "...");
        System.out.println("Asunto: Confirmacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombreCliente + ", su pedido por $"
        + total + " ha sido procesado.");
        System.out.println("[LOG] Pedido procesado para " + nombreCliente
        + " - Total: " + total);
    }
    
    public void cancelarPedido(String nombreCliente, String emailCliente, int idPedido) {
        ClienteValidator validator = new ClienteValidator();

        if (!validator.validarNombre(nombreCliente)) {
            System.out.println("Error: nombre de cliente invalido");
            return;
        }

        if (!validator.validarEmail(emailCliente)) {
            System.out.println("Error: email invalido");
            return;
        }
        try {
        Statement stmt = conexionBD.createStatement();
        String sql = "DELETE FROM pedidos WHERE id = " + idPedido;
        stmt.executeUpdate(sql);
        } catch (SQLException e) {
        System.out.println("Error al cancelar el pedido: " + e.getMessage());
        }
        System.out.println("Enviando correo a " + emailCliente + "...");
        System.out.println("Asunto: Cancelacion de pedido");
        System.out.println("Cuerpo: Estimado " + nombreCliente + ", su pedido #"
        + idPedido + " ha sido cancelado.");
    }
}
