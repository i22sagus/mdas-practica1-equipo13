package subsistemas;
import models.Vuelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioVuelos {
    private List<Vuelo> catalogoVuelos = new ArrayList<>();

    public ServicioVuelos() {
        catalogoVuelos.add(new Vuelo("Madrid", "Cordoba", LocalDate.now().plusDays(5)));
        catalogoVuelos.add(new Vuelo("Barcelona", "Cordoba", LocalDate.now().plusDays(5)));
    }

    public List<Vuelo> buscarVuelo(String origen, String destino, LocalDate fecha) {
        return catalogoVuelos.stream()
                .filter(v -> v.origen().equalsIgnoreCase(origen) && v.destino().equalsIgnoreCase(destino) && v.fecha().equals(fecha))
                .collect(Collectors.toList());
    }
}