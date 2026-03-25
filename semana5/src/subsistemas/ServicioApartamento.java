package subsistemas;
import models.Apartamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioApartamento {
    private List<Apartamento> catalogoApartamentos = new ArrayList<>();

    public ServicioApartamento() {
        catalogoApartamentos.add(new Apartamento("Cordoba", "Apartamento Centro"));
    }

    public List<Apartamento> buscarApartamento(String ciudad, LocalDate fechaDisponible) {
        return catalogoApartamentos.stream().filter(a -> a.ciudad().equalsIgnoreCase(ciudad)).toList();
    }
}