package proveedores;
import dominio.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmpresaA_Sofas implements IProveedor {
    private List<Sofa> stockSofas = new ArrayList<>();
    public void agregarSofa(Sofa s) {
        this.stockSofas.add(s);
    }
    public EmpresaA_Sofas() {
        // Aquí se inicializaría el stock (ej. añadiendo sofás a la lista)
    }

    @Override
    public List<Producto> buscarComun(String material, double minPrecio, double maxPrecio, String color) {
        return stockSofas.stream()
            .filter(s -> s.getPrecio() >= minPrecio && s.getPrecio() <= maxPrecio)
            // Añadir más filtros aquí según sea necesario
            .collect(Collectors.toList());
    }

    @Override
    public List<Sofa> buscarSofaPorPlazas(int plazas) {
        return stockSofas.stream().filter(s -> s.getPlazas() == plazas).collect(Collectors.toList());
    }

    @Override
    public List<Mesa> buscarMesasPorDimensiones(String dimensiones) {
        return new ArrayList<>(); // No vende mesas
    }

    @Override
    public List<Producto> obtenerTodoElStock() {
        return new ArrayList<>(stockSofas);
    }
}