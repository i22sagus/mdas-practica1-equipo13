import entidades.Plato;
import entidades.TipoAcompanamiento;
import factorias.FactoriaAbstracta;
import factorias.FactoriaLlevar;
import factorias.FactoriaRestaurante;
import productos.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- PEDIDO EN RESTAURANTE ---");
        FactoriaAbstracta factoriaLocal = new FactoriaRestaurante();
        Menu menuLocal = factoriaLocal.crearMenuSemanal(TipoAcompanamiento.PATATAS);
        imprimirTicket(menuLocal);

        System.out.println("\n--- PEDIDO PARA LLEVAR ---");
        FactoriaAbstracta factoriaLlevar = new FactoriaLlevar();
        Menu menuLlevar = factoriaLlevar.crearMenuSemanal(TipoAcompanamiento.ENSALADA);
        imprimirTicket(menuLlevar);
    }

    private static void imprimirTicket(Menu menu) {
        for (Plato p : menu.obtenerPlatos()) {
            System.out.println("- " + p.toString());
        }
        System.out.printf("TOTAL: %.2f€\n", menu.calcularPrecio());
    }
}