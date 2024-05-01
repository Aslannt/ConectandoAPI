import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaAPI {


     public Peliculas buscarPelicula(int numeroPelicula) {


         URI direccion = URI.create("https://swapi.py4e.com/api/films/" + numeroPelicula + "/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

         try {
             HttpResponse<String> response = null;
             response = client
                     .send(request, HttpResponse.BodyHandlers.ofString());
             return new Gson().fromJson(response.body(),Peliculas.class);
         } catch (Exception e) {
             throw new RuntimeException("No encontre esa pelicula");
         }


     }
}
