package com.example.user.heroapps;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = new fragment_home();
    private RecyclerView recyclerView;
    private ArrayList<HeroesModel> listHero  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showRecyclerList();
        recyclerView = findViewById(R.id.rv_hero_list);
        recyclerView.setHasFixedSize(true);
        listHero.addAll(DataHero.getListHero());

        bottomNavigationView = findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HeroesAdapter heroesAdapter = new HeroesAdapter(this);
        heroesAdapter.setHeroesModels(listHero);
        recyclerView.setAdapter(heroesAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                selectedFragment = new fragment_home();
                break;
            case R.id.menu_person:
                selectedFragment = new person();
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment){
        if(selectedFragment!= null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_container, selectedFragment)
                    .commit();
            return true;

        }
        return false;
    }


}
