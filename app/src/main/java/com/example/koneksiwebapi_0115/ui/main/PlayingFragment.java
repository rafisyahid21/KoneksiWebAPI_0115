package com.example.koneksiwebapi_0115.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.koneksiwebapi_0115.ApiClient;
import com.example.koneksiwebapi_0115.ApiService;
import com.example.koneksiwebapi_0115.Movie;
import com.example.koneksiwebapi_0115.MovieAdapter;
import com.example.koneksiwebapi_0115.MovieResponse;
import com.example.koneksiwebapi_0115.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlayingFragment extends Fragment {

    private ArrayList<Movie> listMovie;
    private RecyclerView rvMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playing, container, false);
        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<MovieResponse> call = service.getPlayingMovie("d58845c9d53da3e216a0a21300e1e90a");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                listMovie = response.body().getResults();

                MovieAdapter movieAdapter = new MovieAdapter(listMovie);
                rvMovie.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });



        return view;
    }
}

