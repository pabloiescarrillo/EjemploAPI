package es.iescarrillo.android.ejemploapi.apiClients;

import com.google.gson.GsonBuilder;

import es.iescarrillo.android.ejemploapi.apiServices.PokemonApiService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonApiClient {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();
        }

        return retrofit;
    }

}
