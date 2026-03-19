package catalogos;
import dominio.*;
import proveedores.IProveedor;
import java.util.*;
import java.util.stream.Collectors;

public abstract class CatalogoAbstracto {
    protected List<IProveedor> proveedores = new ArrayList<>();

    public void agregarProveedor(IProveedor p) {
        proveedores.add(p);
    }

    public List<Producto> buscarComun(String material, double minP, double maxP, String color) {
        return proveedores.stream()
                .flatMap(p -> p.buscarComun(material, minP, maxP, color).stream())
                .collect(Collectors.toList());
    }

    public List<Producto> buscarOrdenadoPorPrecio() {
        return proveedores.stream()
                .flatMap(p -> p.obtenerTodoElStock().stream())
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }

    public List<Producto> buscarOrdenadoPorStock() {
        // Agrupa por ID de producto, sumando las unidades de empresas distintas
        Map<String, Producto> consolidados = new HashMap<>();
        
        for (IProveedor prov : proveedores) {
            for (Producto prod : prov.obtenerTodoElStock()) {
                if (consolidados.containsKey(prod.getId())) {
                    Producto existente = consolidados.get(prod.getId());
                    existente.setUnidades(existente.getUnidades() + prod.getUnidades());
                } else {
                    consolidados.put(prod.getId(), prod);
                }
            }
        }
        
        // Ordenar de mayor a menor stock
        return consolidados.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()))
                .collect(Collectors.toList());
    }
}