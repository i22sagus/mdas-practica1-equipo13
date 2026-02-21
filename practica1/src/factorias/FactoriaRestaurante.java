public class FactoriaRestaurante implements FactoriaAbstracta {
    @Override
    public Menu crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        menu.asignarPlato(new Plato("Sopa", 5.0, TipoPlato.ENTRANTE, TipoAcompanamiento.NINGUNO));
        menu.asignarPlato(new Plato("Pollo asado", 10.0, TipoPlato.PRINCIPAL, acompanamiento));
        menu.asignarPlato(new Plato("Tarta", 4.0, TipoPlato.POSTRE, TipoAcompanamiento.NINGUNO)); // Incluye postre
        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();
        menu.asignarPlato(new Plato("Guiso de invierno", 15.0, TipoPlato.TEMPORADA, TipoAcompanamiento.NINGUNO));
        return menu;
    }
}