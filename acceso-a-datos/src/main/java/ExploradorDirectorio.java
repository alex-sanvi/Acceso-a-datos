import java.io.File;

public class ExploradorDirectorio {

    private final File directorio;

    public ExploradorDirectorio(String rutaDirectorio) throws DirectorioNoValidoException {
        this.directorio = new File(rutaDirectorio);

        if (!directorio.exists()) {
            throw new DirectorioNoValidoException("El directorio '" + rutaDirectorio + "' no existe.");
        }

        if (!directorio.isDirectory()) {
            throw new DirectorioNoValidoException("La ruta indicada no es un directorio: '" + rutaDirectorio + "'");
        }
    }

    public void listarArchivos() {
        System.out.println("Contenido del directorio \"" + directorio.getPath() + "\":");
        listarContenidoRecursivo(directorio, "");
    }

    private void listarContenidoRecursivo(File dir, String prefijo) {
        File[] archivos = dir.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println(prefijo + "(vacío)");
            return;
        }

        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                System.out.println(prefijo + "📁 " + archivo.getName() + "/");
                listarContenidoRecursivo(archivo, prefijo + "    ");
            } else {
                System.out.println(prefijo + "📄 " + archivo.getName());
            }
        }
    }
}
