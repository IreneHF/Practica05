package Controlador;

import Modelo.Libro;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenciaVentas {
    
    private static ResultSet consultaVentas;
    private static Conexion conexion;
    private static Connection c;
    private static PreparedStatement sentencia;
    
    public SentenciaVentas()
    {
        conexion = new Conexion();
        c=conexion.devolverConexion();
    }
    
    public ArrayList sentenciaVentas(String consulta, int cod) throws Errores
    {
        try {
            sentencia = c.prepareStatement(consulta);
            sentencia.setInt(1, cod);
            consultaVentas = sentencia.executeQuery();
            
            return prepararArray();
        } catch (SQLException | NullPointerException e) {
            throw new Errores(1);
        }
    }
    
    public ArrayList prepararArray() throws Errores
    {
        try {
            ArrayList <Venta> ventas = new ArrayList();
            Venta v;
            float precio;
            
            while(consultaVentas.next())
            {
                precio = calcularPrecio(consultaVentas.getInt(1), consultaVentas.getString(2));
                v = new Venta(consultaVentas.getInt(1), consultaVentas.getString(2), consultaVentas.getInt(1), precio);
                ventas.add(v);
            }
            
            return ventas;
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    
    }
    
    public float calcularPrecio(int codLib, String codCli) throws Errores
    {
        String consulta1 = "select precio from libros where codigo = ?";
        String consulta2 = "select descuento from clientes where codigo = ?";
        float precio, descuento, precioFinal;
        
        try {
                PreparedStatement sentencia1= c.prepareStatement(consulta1);
                sentencia1.setInt(1, codLib);
                ResultSet rs1 = sentencia1.executeQuery();
                rs1.next();
                
                precio = rs1.getFloat(1);
                
                PreparedStatement sentencia2= c.prepareStatement(consulta2);
                sentencia2.setString(1, codCli);
                ResultSet rs2 = sentencia2.executeQuery();
                rs2.next();
                
                descuento = rs2.getFloat(1);
            } catch (SQLException | NullPointerException e) {
                throw new Errores(1);
            }
        
            precioFinal = precio - precio*descuento/100;
            return precioFinal;
    }
    
    public ArrayList devolverClientes(String consulta) throws Errores
    {
        try {
            Statement sentencia = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = sentencia.executeQuery(consulta);
            
            return ArrayClientes(rs);
        } catch (SQLException | NullPointerException e) {
            throw new Errores(1);
        }
    }
    
    public ArrayList ArrayClientes(ResultSet rs) throws Errores
    {
        try {
            ArrayList <String> clientes = new ArrayList();
            String cliente;
            
            while(rs.next())
            {
                cliente = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3);
                clientes.add(cliente);
            }
            
            return clientes;
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
    
    public int calcularCod(String consulta,int cod) throws Errores
    {
        try {
                PreparedStatement sentencia= c.prepareStatement(consulta);
                sentencia.setInt(1, cod);
                ResultSet rs = sentencia.executeQuery();
                
                return contar(rs);
                
            } catch (SQLException | NullPointerException e) {
                throw new Errores(1);
            }
    }
    
    public int contar(ResultSet rs) throws Errores
    {
        try {
            int cont=0;
            while(rs.next())
            {
                cont++;
            }
            
            return cont;
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
    
    public void añadirVenta(String consulta,int libCod, String cliCod, String cod) throws Errores
    {
        try {
                PreparedStatement sentencia= c.prepareStatement(consulta);
                sentencia.setInt(1, libCod);
                sentencia.setString(2, cliCod);
                sentencia.setString(3, cod);
                sentencia.executeUpdate();
            } catch (SQLException e) {
                throw new Errores(1);
            }
    }
}