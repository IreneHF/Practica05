package Modelo;

import Controlador.Conexion;
import Controlador.Errores;
import Controlador.SentenciaLibros;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionLibros {
    
    private static ResultSet consultaLibros;
    private SentenciaLibros sentencia;
    private static Conexion conexion;
    
    public GestionLibros()
    {
        conexion = new Conexion();
        sentencia = new SentenciaLibros();
    }
    
    public void sentenciaLibros() throws Errores
    {
        String consulta = "select * from libros where depcodigo = " + conexion.devolverCod();
        
        sentencia.sentenciaLibros(consulta);
    }
    
    public String cogerLibro(int columna) throws Errores
    {
       return sentencia.devolverDato(columna);
    }
        
    public void libroAnterior() throws Errores
    {
        sentencia.libroAnterior();
    }
        
    public void libroSiguiente() throws Errores
    {
        sentencia.libroSiguiente();
    }
    
    public boolean primerLibro() throws Errores
    {
        return sentencia.primerLibro();
    }
    
    public boolean ultimoLibro() throws Errores
    {
        return sentencia.ultimoLibro();
    }
    
    public void sentenciaFecha(String fecha, String codLibro) throws Errores
    {
        String consulta = "update libros set fecha = '" + fecha + "' where codigo = " + codLibro;
        sentencia.sentenciaFecha(consulta);
    }
    
}
