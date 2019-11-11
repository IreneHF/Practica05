package Controlador;

public class Errores extends Exception{
    private int cod;
    
    public Errores(int c)
    {
        cod=c;
    }
    
    public void lanzarError()
    {
        ControlErrores e = new ControlErrores(cod);
        e.crearFichero();
    }
    
    
}
