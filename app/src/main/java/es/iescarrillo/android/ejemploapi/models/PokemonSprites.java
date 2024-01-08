package es.iescarrillo.android.ejemploapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PokemonSprites implements Serializable {

    // The default depiction of this Pokémon from the front in battle.
    @SerializedName("front_default")
    @Expose
    private String frontDefault;

    // The default depiction of this Pokémon from the back in battle.
    @SerializedName("back_default")
    @Expose
    private String backDefault;

    public PokemonSprites() {
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    @Override
    public String toString() {
        return "PokemonSprites{" +
                "frontDefault='" + frontDefault + '\'' +
                ", backDefault='" + backDefault + '\'' +
                '}';
    }
}
