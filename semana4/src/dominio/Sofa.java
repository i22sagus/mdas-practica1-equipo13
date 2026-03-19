package dominio;

public class Sofa extends Producto {
    private int plazas;

    public Sofa(String id, String nombre, double precio, int unidades, String material, String color, int plazas) {
        super(id, nombre, precio, unidades, material, color);
        this.plazas = plazas;
    }
    public int getPlazas() { return plazas; }
}