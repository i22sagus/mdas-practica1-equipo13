package catalogos;
import dominio.*;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoSofas extends CatalogoAbstracto {
    public List<Sofa> buscarPorPlazas(int plazas) {
        return proveedores.stream()
                .flatMap(p -> p.buscarSofaPorPlazas(plazas).stream())
                .collect(Collectors.toList());
    }
}