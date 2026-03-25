package models;
import java.util.List;
public record ViajeOpciones(List<Vuelo> vuelos, List<Autobus> buses, List<Hotel> hoteles, List<Apartamento> apartamentos, List<Actividad> actividades) {}