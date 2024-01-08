package es.iescarrillo.android.ejemploapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.android.ejemploapi.R;
import es.iescarrillo.android.ejemploapi.apiClients.PokemonApiClient;
import es.iescarrillo.android.ejemploapi.apiServices.PokemonApiService;
import es.iescarrillo.android.ejemploapi.models.NamedAPIResourceList;
import es.iescarrillo.android.ejemploapi.models.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos la instancia del APIService y la inicializo
        PokemonApiService apiService = PokemonApiClient.getClient().create(PokemonApiService.class);

        // Creamos la llamada al método que nos devuelve todos los pokemons
        Call callPokemons = apiService.getPokemons();
        /* El método enqueue realiza una llamada asíncrona a la API y notifica mediante un
        callback la respuesta obtenida
        * */
        callPokemons.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                // Castemos la respuesta en la clase del Modelo
                NamedAPIResourceList namedAPIResourceList = (NamedAPIResourceList) response.body();

                // Para mostrar por el log la lista de objetos
                for(Pokemon p : namedAPIResourceList.getResults())
                    Log.i("Pokemon:", p.toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Error", "The request could not be made");
            }
        });

        int pokemonId = 4;

        Call callPokemon = apiService.getPokemonById(pokemonId);
        callPokemon.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Pokemon pokemon = (Pokemon) response.body();
                TextView tvPokemon = findViewById(R.id.tvPokemon);
                tvPokemon.setText(pokemon.getName());
                ImageView imgFront = findViewById(R.id.imgFront);
                ImageView imgBack = findViewById(R.id.imgBack);

                Picasso.get().load(pokemon.getSprites().getFrontDefault()).into(imgFront);
                Picasso.get().load(pokemon.getSprites().getBackDefault()).into(imgBack);
                Log.i("Pokemon by id", pokemon.toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}