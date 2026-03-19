package dominio;

public abstract class Producto {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int unidades;
    protected String material;
    protected String color;

    public Producto(String id, String nombre, double precio, int unidades, String material, String color) {
        this.id = id; this.nombre = nombre; this.precio = precio;
        this.unidades = unidades; this.material = material; this.color = color;
    }

    public double getPrecio() { return precio; }
    public int getUnidades() { return unidades; }
    public String getId() { return id; }
    public void setUnidades(int unidades) { this.unidades = unidades; }
}