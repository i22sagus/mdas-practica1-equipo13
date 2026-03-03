import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MaquetadorBasico {

    public void anadirTexto(File archivo, String texto) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(texto);
        } catch (IOException e) {
            System.err.println("Error al añadir texto: " + e.getMessage());
        }
    }

    public String extraerParrafo(File archivo, int lineaInicio, int lineaFin) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int actual = 1;
            while ((linea = br.readLine()) != null) {
                if (actual >= lineaInicio && actual <= lineaFin) {
                    sb.append(linea).append("\n");
                }
                if (actual > lineaFin) break; 
                actual++;
            }
        } catch (IOException e) {
            System.err.println("Error al extraer párrafo: " + e.getMessage());
        }
        return sb.toString();
    }

    public void dividirFichero(File archivo, int lineaCorte) {
        File parte1 = new File(archivo.getParent(), "parte1_" + archivo.getName());
        File parte2 = new File(archivo.getParent(), "parte2_" + archivo.getName());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             PrintWriter pw1 = new PrintWriter(new FileWriter(parte1));
             PrintWriter pw2 = new PrintWriter(new FileWriter(parte2))) {
            
            String linea;
            int actual = 1;
            while ((linea = br.readLine()) != null) {
                if (actual < lineaCorte) {
                    pw1.println(linea);
                } else {
                    pw2.println(linea);
                }
                actual++;
            }
        } catch (IOException e) {
            System.err.println("Error al dividir fichero: " + e.getMessage());
        }
    }
}