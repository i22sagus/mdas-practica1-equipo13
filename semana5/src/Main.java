import facade.BuscadorViajesFacade;
import models.ViajeOpciones;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Búsqueda de Viajes Grupales ===");
        
        // El cliente solo interactúa con la Fachada
        BuscadorViajesFacade buscador = new BuscadorViajesFacade();
        
        LocalDate fechaInicio = LocalDate.now().plusDays(5);
        LocalDate fechaFin = LocalDate.now().plusDays(10);
        String origen = "Madrid";
        String destino = "Cordoba";

        System.out.println("Buscando viaje desde " + origen + " hasta " + destino + "...\n");
        
        ViajeOpciones opciones = buscador.buscarViajeGrupal(fechaInicio, fechaFin, origen, destino);

        System.out.println("--- Resultados Encontrados ---");
        System.out.println("Vuelos: " + opciones.vuelos().size());
        System.out.println("Autobuses: " + opciones.buses().size());
        System.out.println("Hoteles: " + opciones.hoteles().size());
        System.out.println("Apartamentos: " + opciones.apartamentos().size());
        System.out.println("Actividades: " + opciones.actividades().size());
        
        System.out.println("\nBúsqueda completada con éxito gracias al patrón Façade.");
    }
}