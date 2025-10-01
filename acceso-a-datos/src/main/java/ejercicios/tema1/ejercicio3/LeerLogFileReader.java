package ejercicios.tema1.ejercicio3;

public class LeerLogFileReader {
    public static void main(String[] args) {
        try {
            // Creamos el lector con el fichero "log.txt"
            LectorLogFileReader lector = new LectorLogFileReader("C:\\Users\\Alex\\Downloads\\log.txt");
            lector.mostrarContenido();
        } catch (FicheroNoValidoException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}
