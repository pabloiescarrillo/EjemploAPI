package es.iescarrillo.android.ejemploapi.apiServices;

import es.iescarrillo.android.ejemploapi.models.NamedAPIResourceList;
import es.iescarrillo.android.ejemploapi.models.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApiService {
        @GET("pokemon/?limit=30")
        Call<NamedAPIResourceList> getPokemons();

        @GET("pokemon/{pokemonId}")
        Call<Pokemon> getPokemonById(@Path("pokemonId") int pokemonId);
}
