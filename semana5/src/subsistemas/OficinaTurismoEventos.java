package subsistemas;
import models.Actividad;
import java.util.ArrayList;
import java.util.List;

public class OficinaTurismoEventos {
    private List<Actividad> catalogoActividades = new ArrayList<>();

    public OficinaTurismoEventos() {
        catalogoActividades.add(new Actividad("Concierto", "Musical"));
    }

    public List<Actividad> buscarPorTipoEvento(String tipo) {
        return catalogoActividades.stream().filter(a -> a.tipo().equalsIgnoreCase(tipo)).toList();
    }
}