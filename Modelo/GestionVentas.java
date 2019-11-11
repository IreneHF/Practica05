package Modelo;

import Controlador.Conexion;
import Controlador.Errores;
import Controlador.SentenciaVentas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionVentas {
    
    private static ResultSet consultaVentas;
    private SentenciaVentas sentencia;
    private static Conexion conexion;
    
    public GestionVentas()
    {
        conexion = new Conexion();
        sentencia = new SentenciaVentas();
    }
    
    public ArrayList sentenciaVentas(String cod) throws Errores
    {
        String consulta = "select * from ventas where libcodigo = ?";
        int c = Integer.parseInt(cod);
        
        return sentencia.sentenciaVentas(consulta, c);
    }
    
    
    public ArrayList sentenciaClientes() throws Errores
    {
        String consulta = "select nombre, nif, codigo from clientes";
        
        return sentencia.devolverClientes(consulta);
    }
    
    public void sentenciaNuevaVenta(int libcod, String clicod) throws Errores
    {
        String consulta = "select * from ventas where libcodigo = ?";
        int cont = sentencia.calcularCod(consulta,libcod);
        String contador = "" + cont;
        consulta = "insert into ventas values (?, ?, ?, 0)";
        sentencia.añadirVenta(consulta, libcod, clicod, contador);
        
    }
    
    
}
