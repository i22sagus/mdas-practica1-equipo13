package proveedores;
import dominio.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmpresaB_Mesas implements IProveedor {
    private List<Mesa> stockMesas = new ArrayList<>();

    // Método auxiliar para cargar datos desde el Main
   public void agregarMesa(Mesa m) {
        this.stockMesas.add(m);
    }

    @Override
    public List<Producto> buscarComun(String material, double minPrecio, double maxPrecio, String color) {
        return stockMesas.stream()
            .filter(m -> m.getPrecio() >= minPrecio && m.getPrecio() <= maxPrecio)
            // Aquí pueden añadir las validaciones de material y color si lo desean
            .collect(Collectors.toList());
    }

    @Override
    public List<Sofa> buscarSofaPorPlazas(int plazas) {
        // No vende sofás, devolvemos lista vacía
        return new ArrayList<>(); 
    }

    @Override
    public List<Mesa> buscarMesasPorDimensiones(String dimensiones) {
        return stockMesas.stream()
            .filter(m -> m.getDimensiones().equalsIgnoreCase(dimensiones))
            .collect(Collectors.toList());
    }

    @Override
    public List<Producto> obtenerTodoElStock() {
        return new ArrayList<>(stockMesas);
    }
}