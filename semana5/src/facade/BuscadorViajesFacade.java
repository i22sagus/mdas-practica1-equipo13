package facade;

import models.*;
import subsistemas.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BuscadorViajesFacade {
    private ServicioVuelos servicioVuelos = new ServicioVuelos();
    private ServicioAutobuses servicioAutobuses = new ServicioAutobuses();
    private ServicioHoteles servicioHoteles = new ServicioHoteles();
    private ServicioApartamento servicioApartamento = new ServicioApartamento();
    private OficinaTurismoFechas oficinaTurismoFechas = new OficinaTurismoFechas();
    private OficinaTurismoEventos oficinaTurismoEventos = new OficinaTurismoEventos();

    public ViajeOpciones buscarViajeGrupal(LocalDate fechaInicio, LocalDate fechaFin, String origen, String destino) {
        
        // 1. Buscar Transportes
        List<Vuelo> vuelos = servicioVuelos.buscarVuelo(origen, destino, fechaInicio);
        List<Autobus> buses = servicioAutobuses.buscarAutobus(origen, destino, fechaInicio);

        // 2. Buscar Alojamientos
        List<Hotel> hoteles = servicioHoteles.buscarHotel(destino, fechaInicio, fechaFin);
        List<Apartamento> apartamentos = servicioApartamento.buscarApartamento(destino, fechaInicio);

        // 3. Buscar Actividades
        List<Actividad> actividades = new ArrayList<>();
        actividades.addAll(oficinaTurismoFechas.buscarPorFecha(fechaInicio, fechaFin));
        actividades.addAll(oficinaTurismoEventos.buscarPorTipoEvento("Cultural")); // Decisión de la fachada: buscar por defecto eventos culturales

        // Retornar la consolidación
        return new ViajeOpciones(vuelos, buses, hoteles, apartamentos, actividades);
    }
}