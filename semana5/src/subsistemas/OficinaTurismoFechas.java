package subsistemas;
import models.Actividad;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OficinaTurismoFechas {
    private List<Actividad> catalogoActividades = new ArrayList<>();

    public OficinaTurismoFechas() {
        catalogoActividades.add(new Actividad("Tour Alcázar", "Cultural"));
    }

    public List<Actividad> buscarPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return catalogoActividades; // Simplificado para devolver catálogo en esas fechas
    }
}