package subsistemas;
import models.Autobus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioAutobuses {
    private List<Autobus> catalogoBuses = new ArrayList<>();

    public ServicioAutobuses() {
        catalogoBuses.add(new Autobus("Madrid", "Cordoba", LocalDate.now().plusDays(5)));
    }

    public List<Autobus> buscarAutobus(String origen, String destino, LocalDate fecha) {
        return catalogoBuses.stream()
                .filter(b -> b.origen().equalsIgnoreCase(origen) && b.destino().equalsIgnoreCase(destino) && b.fecha().equals(fecha))
                .collect(Collectors.toList());
    }
}