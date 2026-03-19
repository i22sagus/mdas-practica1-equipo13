package proveedores;
import dominio.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmpresaC_Multiproducto implements IProveedor {
    // Almacena una mezcla de mesas y sofás
    private List<Producto> stockProductos = new ArrayList<>();

    // Métodos auxiliares para cargar datos desde el Main
    public void agregarSofa(Sofa s) { stockProductos.add(s); }
    public void agregarMesa(Mesa m) { stockProductos.add(m); }

    @Override
    public List<Producto> buscarComun(String material, double minPrecio, double maxPrecio, String color) {
        return stockProductos.stream()
            .filter(p -> p.getPrecio() >= minPrecio && p.getPrecio() <= maxPrecio)
            .collect(Collectors.toList());
    }

    @Override
    public List<Sofa> buscarSofaPorPlazas(int plazas) {
        return stockProductos.stream()
            .filter(p -> p instanceof Sofa)       // 1. Nos quedamos solo con los que son Sofás
            .map(p -> (Sofa) p)                   // 2. Los transformamos (casteo) a tipo Sofa
            .filter(s -> s.getPlazas() == plazas) // 3. Filtramos por el número de plazas
            .collect(Collectors.toList());
    }

    @Override
    public List<Mesa> buscarMesasPorDimensiones(String dimensiones) {
        return stockProductos.stream()
            .filter(p -> p instanceof Mesa)       // 1. Nos quedamos solo con las que son Mesas
            .map(p -> (Mesa) p)                   // 2. Las transformamos (casteo) a tipo Mesa
            .filter(m -> m.getDimensiones().equalsIgnoreCase(dimensiones))
            .collect(Collectors.toList());
    }

    @Override
    public List<Producto> obtenerTodoElStock() {
        return new ArrayList<>(stockProductos);
    }
}