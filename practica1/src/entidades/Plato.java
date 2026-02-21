// Archivo: Plato.java
public class Plato {
    private String nombre;
    private double precio;
    private TipoPlato tipo;
    private TipoAcompanamiento acompanamiento;

    public Plato(String nombre, double precio, TipoPlato tipo, TipoAcompanamiento acompanamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.acompanamiento = acompanamiento;
    }

    public void asignarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public double getPrecio() { return precio; }
    
    @Override
    public String toString() {
        return nombre + " (" + precio + "€)" + 
               (acompanamiento != TipoAcompanamiento.NINGUNO ? " con " + acompanamiento : "");
    }
}