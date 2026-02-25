
package productos;

import entidades.Plato;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Plato> platos;

    public Menu() {
        this.platos = new ArrayList<>();
    }

    public abstract double calcularPrecio();

    public List<Plato> obtenerPlatos() {
        return platos;
    }

    public void asignarPlato(Plato plato) {
        if (platos.size() < 3) { // Restricción de 1 a 3 platos según diagrama
            platos.add(plato);
        } else {
            System.out.println("El menú ya tiene el máximo de platos permitidos.");
        }
    }
}