import java.io.File;
import java.util.List;

public class AdaptadorMaquetador implements MaquetadorAvanzado {
    
    private MaquetadorBasico maquetadorBasico;

    public AdaptadorMaquetador(MaquetadorBasico basico) {
        this.maquetadorBasico = basico;
    }

    @Override
    public void unirFicheros(File fichero1, File fichero2) {
        String contenidoF2 = maquetadorBasico.extraerParrafo(fichero2, 1, Integer.MAX_VALUE);
        maquetadorBasico.anadirTexto(fichero1, contenidoF2);
    }

    @Override
    public void combinarFicheros(File fichero1, File fichero2, List<int[]> lineasExtraccion) {
        File combinado = new File(fichero1.getParent(), "combinado.txt");
        if(combinado.exists()) combinado.delete();

        for (int i = 0; i < lineasExtraccion.size(); i++) {
            int inicio = lineasExtraccion.get(i)[0];
            int fin = lineasExtraccion.get(i)[1];
            
            if (i % 2 == 0) { 
                String parrafo = maquetadorBasico.extraerParrafo(fichero1, inicio, fin);
                maquetadorBasico.anadirTexto(combinado, parrafo);
            } else { 
                String parrafo = maquetadorBasico.extraerParrafo(fichero2, inicio, fin);
                maquetadorBasico.anadirTexto(combinado, parrafo);
            }
        }
    }

    @Override
    public void separarFichero(File fichero, List<Integer> lineasInicio) {
        File actual = fichero;
        int lineasAcumuladas = 0;

        for (int corte : lineasInicio) {
            int corteRelativo = corte - lineasAcumuladas;
            maquetadorBasico.dividirFichero(actual, corteRelativo);
            
            actual = new File(actual.getParent(), "parte2_" + actual.getName());
            lineasAcumuladas = corte - 1; 
        }
    }
}