import java.io.File;
import java.util.List;

public interface MaquetadorAvanzado {
    void unirFicheros(File fichero1, File fichero2);
    void combinarFicheros(File fichero1, File fichero2, List<int[]> lineasExtraccion);
    void separarFichero(File fichero, List<Integer> lineasInicio);
}