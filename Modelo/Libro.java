
package Modelo;

public class Libro {
    private int codigo;
    private int deptCodigo;
    private String titulo;
    private float precio;
    
    public Libro()
    {
        
    }
    
    public Libro(int c, int d, String t, float p)
    {
        codigo=c;
        deptCodigo=d;
        titulo=t;
        precio=p;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDeptCodigo() {
        return deptCodigo;
    }

    public void setDeptCodigo(int deptCodigo) {
        this.deptCodigo = deptCodigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
