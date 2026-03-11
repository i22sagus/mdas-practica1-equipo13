import java.util.ArrayList;
import java.util.List;

public class Espacio implements Contador {
    private String nombre;
    private String tipoEspacio; 
    private List<Contador> componentes;

    public Espacio(String nombre, String tipoEspacio) {
        this.nombre = nombre;
        this.tipoEspacio = tipoEspacio;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(Contador c) {
        componentes.add(c);
    }

    public void eliminarComponente(Contador c) {
        componentes.remove(c);
    }

    @Override
    public double calcularConsumoEstimado() {
        double totalConsumo = 0;
        // Delega la petición a cada componente hijo
        for (Contador c : componentes) {
            totalConsumo += c.calcularConsumoEstimado();
        }
        return totalConsumo;
    }

    @Override
    public double calcularCosteTotal(double precioKWh) {
        double totalCoste = 0;
        // Delega la petición a cada componente hijo
        for (Contador c : componentes) {
            totalCoste += c.calcularCosteTotal(precioKWh);
        }
        return totalCoste;
    }
}