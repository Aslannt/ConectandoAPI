import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ConsultaAPI consulta = new ConsultaAPI();

        Scanner Sc = new Scanner(System.in);
        System.out.println("Que pelicula quiere consultar: ");

        try {
            var numeroPelicula = Integer.valueOf(Sc.nextLine());
            Peliculas pelicula = consulta.buscarPelicula(numeroPelicula);
            System.out.println(pelicula);

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);

        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado "+e.getMessage());
        }
        catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicacion");

        }
    }
}

