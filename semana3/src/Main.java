public class Main {
    public static void main(String[] args) {
        // Precio actual del kWh en España en euros
        double precioKWh = 0.1779; 

        // 1. Crear aparatos (Nodos Hoja)
        AparatoElectrico proyector = new AparatoElectrico("Proyector Aula 101", 0.3, 4);
        AparatoElectrico ordenadores = new AparatoElectrico("20 PCs Aula 101", 5.0, 6);
        AparatoElectrico maquinaVending = new AparatoElectrico("Máquina de Venta Pasillo", 1.2, 24);
        AparatoElectrico iluminacion = new AparatoElectrico("Iluminación Edificio", 2.0, 12);

        // 2. Crear espacios (Nodos Composite)
        Espacio aula101 = new Espacio("Aula 101", "Sala");
        Espacio edificioA = new Espacio("Edificio A (Aulario)", "Edificio");
        Espacio campus = new Espacio("Campus Universitario", "Campus");

        // 3. Ensamblar la estructura de árbol
        // Añadimos aparatos a la sala
        aula101.agregarComponente(proyector);
        aula101.agregarComponente(ordenadores);

        // Añadimos la sala al edificio, además de aparatos que están fuera de la sala
        edificioA.agregarComponente(aula101);
        edificioA.agregarComponente(maquinaVending); 
        edificioA.agregarComponente(iluminacion);

        // Añadimos el edificio al campus
        campus.agregarComponente(edificioA);

        // 4. Mostrar resultados probando la transparencia del patrón Composite
        System.out.println("=== SISTEMA DE CONTROL ENERGÉTICO ===\n");
        
        System.out.println("--- Consumo de una Sala ---");
        System.out.println("Consumo " + aula101.calcularConsumoEstimado() + " kWh");
        System.out.println("Coste: " + aula101.calcularCosteTotal(precioKWh) + " €\n");

        System.out.println("--- Consumo de un Edificio (incluye salas y aparatos sueltos) ---");
        System.out.println("Consumo: " + edificioA.calcularConsumoEstimado() + " kWh");
        System.out.println("Coste: " + edificioA.calcularCosteTotal(precioKWh) + " €\n");

        System.out.println("--- Consumo Global del Campus ---");
        System.out.println("Consumo Total: " + campus.calcularConsumoEstimado() + " kWh");
        System.out.println("Coste Total: " + campus.calcularCosteTotal(precioKWh) + " €");
    }
}