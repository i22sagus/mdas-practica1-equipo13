package proveedores;
import dominio.*;
import java.util.List;

public interface IProveedor {
    List<Producto> buscarComun(String material, double minPrecio, double maxPrecio, String color);
    List<Sofa> buscarSofaPorPlazas(int plazas);
    List<Mesa> buscarMesasPorDimensiones(String dimensiones);
    List<Producto> obtenerTodoElStock();
}