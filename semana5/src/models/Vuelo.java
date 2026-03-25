package models;
import java.time.LocalDate;
public record Vuelo(String origen, String destino, LocalDate fecha) {}