package catalogos;
import dominio.*;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoMesas extends CatalogoAbstracto {
    public List<Mesa> buscarPorDimensiones(String dimensiones) {
        return proveedores.stream()
                .flatMap(p -> p.buscarMesasPorDimensiones(dimensiones).stream())
                .collect(Collectors.toList());
    }
}