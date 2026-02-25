package factorias;

import entidades.Plato;
import entidades.TipoAcompanamiento;
import entidades.TipoPlato;
import productos.Menu;
import productos.MenuSemanal;
import productos.MenuTemporada;

public class FactoriaLlevar implements FactoriaAbstracta {
    private Plato aplicarRecargoLlevar(Plato plato) {
        plato.asignarPrecio(plato.getPrecio() * 1.02); // Incremento del 2%
        return plato;
    }

    @Override
    public Menu crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        menu.asignarPlato(aplicarRecargoLlevar(new Plato("Sopa", 5.0, TipoPlato.ENTRANTE, TipoAcompanamiento.NINGUNO)));
        menu.asignarPlato(aplicarRecargoLlevar(new Plato("Pollo asado", 10.0, TipoPlato.PRINCIPAL, acompanamiento)));
        // NO incluye postre
        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();
        menu.asignarPlato(aplicarRecargoLlevar(new Plato("Guiso de invierno", 15.0, TipoPlato.TEMPORADA, TipoAcompanamiento.NINGUNO)));
        return menu;
    }
}