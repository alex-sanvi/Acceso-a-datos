import java.io.File;

public class Tema1Ejercicio1 {
    public static void main(String[] args) {
        // Comprobar que se ha pasado un argumento
        if (args.length != 1) {
            System.out.println("Uso: java ListarArchivos <nombre_directorio>");
            return;
        }

        // Crear objeto File con la ruta proporcionada
        File directorio = new File(args[0]);

        // Verificar que existe y es un directorio
        if (!directorio.exists()) {
            System.out.println("El directorio no existe.");
            return;
        }

        if (!directorio.isDirectory()) {
            System.out.println("La ruta indicada no es un directorio.");
            return;
        }

        // Obtener la lista de archivos
        File[] archivos = directorio.listFiles();

        if (archivos != null && archivos.length > 0) {
            System.out.println("Archivos en el directorio \"" + directorio.getPath() + "\":");
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    System.out.println("📄 " + archivo.getName());
                } else if (archivo.isDirectory()) {
                    System.out.println("📁 " + archivo.getName() + "/");
                }
            }
        } else {
            System.out.println("El directorio está vacío.");
        }
    }
}