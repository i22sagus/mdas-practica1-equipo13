package productos;

import entidades.Plato;

public class MenuSemanal extends Menu {
    @Override
    public double calcularPrecio() {
        return platos.stream().mapToDouble(Plato::getPrecio).sum();
    }
}