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

        // --- PRUEBAS DEL ADAPTADOR ---
        MaquetadorAvanzado adaptador = new AdaptadorMaquetador(basico);

        System.out.println("Ejecutando operaciones avanzadas...");
        
        adaptador.unirFicheros(f1, f2);
        System.out.println("- Fichero 2 unido al final del Fichero 1.");

        List<int[]> extracciones = Arrays.asList(new int[]{1, 2}, new int[]{1, 2});
        adaptador.combinarFicheros(f1, f2, extracciones);
        System.out.println("- Ficheros combinados en 'combinado.txt'.");

        List<Integer> cortes = Arrays.asList(3);
        adaptador.separarFichero(f1, cortes);
        System.out.println("- Fichero 1 separado. Revisa los archivos generados en la carpeta 'semana2/archivos_prueba'.");
    }
}