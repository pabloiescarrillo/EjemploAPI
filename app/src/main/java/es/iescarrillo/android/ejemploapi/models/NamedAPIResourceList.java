package es.iescarrillo.android.ejemploapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NamedAPIResourceList {

    @SerializedName("count") // Permite transformar de JSON a objeto Java (Serializar)
    @Expose // Permite transfomrar de un objeto Java a JSON (Deserializar)
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("results")
    @Expose
    private List<Pokemon> results;

    public NamedAPIResourceList() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
