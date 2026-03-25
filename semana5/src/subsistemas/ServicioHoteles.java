package subsistemas;
import models.Hotel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioHoteles {
    private List<Hotel> catalogoHoteles = new ArrayList<>();

    public ServicioHoteles() {
        catalogoHoteles.add(new Hotel("Cordoba", "Hotel Mezquita"));
    }

    public List<Hotel> buscarHotel(String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida) {
        // Lógica simplificada: devolvemos hoteles de la ciudad
        return catalogoHoteles.stream().filter(h -> h.ciudad().equalsIgnoreCase(ciudad)).toList();
    }
}