package Modelo;

public class Cliente {
    private char codigo;
    private String nombre;
    private String NIF;
    private float descuento;
    
    public Cliente()
    {
        
    }
    
    public Cliente(char c, String n, String nif, float d)
    {
        codigo=c;
        nombre=n;
        NIF=nif;
        descuento=d;
    }

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    
}
