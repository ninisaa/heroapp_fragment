package com.example.user.heroapps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class fragment_home extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<HeroesModel> listHero  = new ArrayList<>();
    public fragment_home() {
        // Required empty public constructor

    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HeroesAdapter heroesAdapter = new HeroesAdapter(getContext());
        heroesAdapter.setHeroesModels(listHero);
        recyclerView.setAdapter(heroesAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.rv_hero_list);
        recyclerView.setHasFixedSize(true);
        listHero.addAll(DataHero.getListHero());
        showRecyclerList();
        return view;
    }
}
