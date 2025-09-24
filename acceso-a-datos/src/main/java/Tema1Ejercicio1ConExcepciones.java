import java.io.File;

public class Tema1Ejercicio1ConExcepciones {

    public static void main(String[] args) {
        try {
            // Comprobar argumentos y listar archivos
            listarArchivos(args);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otro error inesperado
            System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }

    private static void listarArchivos(String[] args) throws IllegalArgumentException {
        // Comprobar que se ha pasado un argumento
        if (args.length != 1)
            throw new IllegalArgumentException("Uso: java Tema1Ejercicio1 <nombre_directorio>");

        File directorio = new File(args[0]);

        // Verificar existencia y que sea un directorio
        if (!directorio.exists())
            throw new IllegalArgumentException("El directorio '" + args[0] + "' no existe.");

        if (!directorio.isDirectory())
            throw new IllegalArgumentException("La ruta indicada no es un directorio: '" + args[0] + "'");

        // Obtener la lista de archivos
        File[] archivos = directorio.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio está vacío.");
            return;
        }

        System.out.println("Archivos en el directorio \"" + directorio.getPath() + "\":");
        for (File archivo : archivos) {
            if (archivo.isFile()) 
                System.out.println("📄 " + archivo.getName());
            else if (archivo.isDirectory())
                System.out.println("📁 " + archivo.getName() + "/");
        }
    }
}