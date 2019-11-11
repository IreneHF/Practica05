package Controlador;

import Modelo.Libro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private static Connection Conexion_Post;
    private static Connection Conexion_My;
    private static Statement libros;
    private static int cod;
        
        //IP CASA:192.168.20.128 --- IP CLASE: 192.168.8.9
        private static String DRIVER_Post = "org.postgresql.Driver";
        private static String URL_Post="jdbc:postgresql://192.168.20.128:5432/Practica05";
        
        private static String DRIVER_My = "com.mysql.jdbc.Driver";
        private static String URL_My="jdbc:mysql://192.168.20.128:3306/Practica05?useSSL=false";
    
    
        public static boolean crearConexion() throws Errores{
            
            String usuario = "irene";
            String contraseña = "pass";
            
            boolean correcto=true;
            
            try {
                Class.forName(DRIVER_Post); 
                Class.forName(DRIVER_My); 
            } catch (ClassNotFoundException e) {
                
                correcto=false;
            }
            
            try {
                Conexion_Post = DriverManager.getConnection(URL_Post,usuario,contraseña);
                Conexion_My = DriverManager.getConnection(URL_My,usuario,contraseña);
                
            } catch (SQLException ex) {
                correcto=false;
                throw new Errores(1);
            }
            
            return correcto;
        }
        
        public static boolean validarUsuario(String usu, int con) throws Errores
        {
            boolean valido=false;
            
            String consulta = "select * from DEPENDIENTES where nombre = ? and codigo = ?";
            
            
            try {
                PreparedStatement sentencia1= Conexion_Post.prepareStatement(consulta);
                sentencia1.setString(1, usu);
                sentencia1.setInt(2, con);
                ResultSet rs1 = sentencia1.executeQuery();
                
                PreparedStatement sentencia2= Conexion_My.prepareStatement(consulta);
                sentencia2.setString(1, usu);
                sentencia2.setInt(2, con);
                ResultSet rs2 = sentencia2.executeQuery();
                
               if(rs1.next())
               {
                   cod=rs1.getInt(1);
                    if(rs2.next())
                        valido=true;
               }
                
            } catch (SQLException | NullPointerException e) {
                throw new Errores(1);
            }
            
            
        
            return valido;
        }
        
        
        public int devolverCod()
        {
            return cod;
        }
        
        public Connection devolverConexion()
        {
            return Conexion_Post;
        }
}
