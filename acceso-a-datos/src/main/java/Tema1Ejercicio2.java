import java.io.File;

public class Tema1Ejercicio2 {

	public static void main(String[] args) {
		try {
	        if (args.length != 1) {
	            throw new DirectorioNoValidoException("Uso: java Tema1Ejercicio1Recursivo <nombre_directorio>");
	        }
	
	        ExploradorDirectorio explorador = new ExploradorDirectorio(args[0]);
	        explorador.listarArchivos();
	
	    } catch (DirectorioNoValidoException e) {
	        System.err.println("Error: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
	    }
	}
}
