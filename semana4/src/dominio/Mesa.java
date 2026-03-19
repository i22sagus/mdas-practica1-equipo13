package dominio;

public class Mesa extends Producto {
    private String dimensiones;

    public Mesa(String id, String nombre, double precio, int unidades, String material, String color, String dimensiones) {
        super(id, nombre, precio, unidades, material, color);
        this.dimensiones = dimensiones;
    }
    public String getDimensiones() { return dimensiones; }
}