package Modelo;

public class Venta {
    private int libCodigo;
    private String cliCodigo;
    private int codigo;
    private float precioFinal=0;
    
    public Venta()
    {
        
    }
    
    public Venta(int l, String c, int cod, float p)
    {
        libCodigo=l;
        cliCodigo=c;
        codigo=cod;
        precioFinal=p;
    }

    public int getLibCodigo() {
        return libCodigo;
    }

    public void setLibCodigo(int libCodigo) {
        this.libCodigo = libCodigo;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }
    
    
}
