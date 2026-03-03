import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        File dir = new File("semana2/archivos_prueba");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File f1 = new File(dir, "fichero1.txt");
        File f2 = new File(dir, "fichero2.txt");

        MaquetadorBasico basico = new MaquetadorBasico();

        if(f1.exists()) f1.delete();
        if(f2.exists()) f2.delete();

        basico.anadirTexto(f1, "Linea 1 de Fichero 1");
        basico.anadirTexto(f1, "Linea 2 de Fichero 1");
        basico.anadirTexto(f1, "Linea 3 de Fichero 1");

        basico.anadirTexto(f2, "Linea 1 de Fichero 2");
        basico.anadirTexto(f2, "Linea 2 de Fichero 2");
        basico.anadirTexto(f2, "Linea 3 de Fichero 2");

        System.out.println("Archivos de prueba creados. Esperando al Adaptador...\n");
    }
}