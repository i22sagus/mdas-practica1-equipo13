package factorias;

import entidades.TipoAcompanamiento;
import productos.Menu;

public interface FactoriaAbstracta {
    Menu crearMenuSemanal(TipoAcompanamiento acompanamiento);
    Menu crearMenuTemporada();
}