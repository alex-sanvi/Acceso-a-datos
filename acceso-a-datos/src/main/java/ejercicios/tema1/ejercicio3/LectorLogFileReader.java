package ejercicios.tema1.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorLogFileReader {

    private final File fichero;

    public LectorLogFileReader(String rutaFichero) throws FicheroNoValidoException {
        this.fichero = new File(rutaFichero);

        if (!fichero.exists()) {
            throw new FicheroNoValidoException("El fichero '" + rutaFichero + "' no existe.");
        }

        if (!fichero.isFile()) {
            throw new FicheroNoValidoException("La ruta indicada no es un fichero válido: '" + rutaFichero + "'");
        }
    }

    public void mostrarContenido() {
        System.out.println("Contenido de \"" + fichero.getPath() + "\":");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                System.out.println(numeroLinea + ": " + linea);
                numeroLinea++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
