package com.junior.ec04.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junior.ec04.R;
import com.junior.ec04.data.response.ShowResponse;
import com.junior.ec04.data.retrofit.RetrofitHelper;
import com.junior.ec04.databinding.FragmentHomeBinding;
import com.junior.ec04.model.Shows;
import com.junior.ec04.model.Temporada;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.rvMoviesResume.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvMoviesResume.setLayoutManager(layoutManager);
        RetrofitHelper.getService().getShows().enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                if (response.isSuccessful()){
                    assert response.body()!=null;
                    showMovies(response.body().getShowsList());
                }
            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {

            }
        });
    }

    private void showMovies(List<Shows> showsList) {
        RVShowAdapter adapter = new RVShowAdapter(showsList);
        binding.rvShows.setAdapter(adapter);
    }

    private List<Shows> getData() {
        List<Shows> shows = new ArrayList<>();
        shows.add(new Temporada("Capitulos 10","https://www.justwatch.com/images/backdrop/177292909/s640/temporada-1/temporada-1",1));
        shows.add(new Temporada("Capitulos 12","https://www.justwatch.com/images/backdrop/177292909/s640/temporada-1/temporada-1",2));
        shows.add(new Temporada("Capitulos 10","https://www.justwatch.com/images/backdrop/177292909/s640/temporada-1/temporada-1",3));
        shows.add(new Temporada("Capitulos 20","https://www.justwatch.com/images/backdrop/177292909/s640/temporada-1/temporada-1",4));
        return shows;
    }

}