public class AparatoElectrico implements Contador {
    private String nombre;
    private double consumoPorHora;
    private double horasEnUso;

    public AparatoElectrico(String nombre, double consumoPorHora, double horasEnUso) {
        this.nombre = nombre;
        this.consumoPorHora = consumoPorHora;
        this.horasEnUso = horasEnUso;
    }

    @Override
    public double calcularConsumoEstimado() {
        return consumoPorHora * horasEnUso;
    }

    @Override
    public double calcularCosteTotal(double precioKWh) {
        return calcularConsumoEstimado() * precioKWh;
    }
}