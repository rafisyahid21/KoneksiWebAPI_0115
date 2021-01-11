package com.example.koneksiwebapi_0115;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {
    @SerializedName("results")
    private ArrayList<Movie> results;

    @SerializedName("total_pages")
    private int total_pages;

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int total_results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
