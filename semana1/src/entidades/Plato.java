package entidades;

public class Plato {
    private final String nombre;
    private double precio;
    private final TipoPlato tipo;
    private final TipoAcompanamiento acompanamiento;

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
        return nombre + " [" + tipo + "] (" + precio + "€)" +
               (acompanamiento != TipoAcompanamiento.NINGUNO ? " con " + acompanamiento : "");
    }
}