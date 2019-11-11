package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlErrores{
    private int cod;
    private static int cont=1;
    
    public ControlErrores(int c)
    {
        cod=c;
    }
    
    public void crearFichero()
    {
        String e = elegirError();
        String url = "errores/fichero" + cont + ".txt";
        
        System.out.println(e);
        
        File carpeta = new File("errores");
        
        if(! carpeta.exists())
            carpeta.mkdir();
        else
        {
            String[] c = carpeta.list();
            cont = c.length + 1;
        }
        
        
        try {
            BufferedWriter f = new BufferedWriter(new FileWriter(url));
            f.write(e);
            cont++;
            f.close();
        } catch (IOException ex) {
            
        } 
    }
    
    public String elegirError()
    {
        GregorianCalendar f = new GregorianCalendar();
        String error = f.get(Calendar.DATE) + "/" + f.get(Calendar.MONTH) +"/" + f.get(Calendar.YEAR) + " - " +
              f.get(Calendar.HOUR) + ":" + f.get(Calendar.MINUTE) +  "\n";
        
        switch(cod)
        {
            case 1:
            {
                error = error + "Error en la base de datos.";
                break;
            }
            case 2: 
            {
                error = error +  "Datos incorrectos.";
                break;
            }
            case 3: 
            {
                error = error +  "Fecha superior a la actual.";
                break;
            }
        }
                
        
        return error;
    }
}
