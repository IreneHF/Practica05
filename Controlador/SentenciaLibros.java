package Controlador;

import Modelo.Libro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenciaLibros {
    
    private static ResultSet consultaLibros;
    private static Conexion conexion;
    private static Connection c;
    private static Statement sentencia;
    
    private static int cod;
    
    public SentenciaLibros()
    {
        conexion = new Conexion();
        c=conexion.devolverConexion();
    }
    
    public void sentenciaLibros(String consulta) throws Errores
    {
        boolean valido=false;
             
        try {
            sentencia = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            consultaLibros = sentencia.executeQuery(consulta);
            consultaLibros.next();
        } catch (SQLException | NullPointerException e) {
            throw new Errores(1);
        }
    }
    
    public String devolverDato(int columna) throws Errores
    {
        try {
           return consultaLibros.getString(columna);
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
        
    public void libroAnterior() throws Errores
    {
        try {
            consultaLibros.previous();
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
        
    public void libroSiguiente() throws Errores
    {
        try {
            consultaLibros.next();
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
    
    public boolean primerLibro() throws Errores
    {
        try {
            return consultaLibros.isFirst();
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
    
    public boolean ultimoLibro() throws Errores
    {
        try {
            return consultaLibros.isLast();
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
    
    public void sentenciaFecha(String consulta) throws Errores
    {
        boolean valido=false;
             
        try {
            sentencia = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sentencia.executeUpdate(consulta);
        } catch (SQLException | NullPointerException e) {
            throw new Errores(1);
        }
    }
}
