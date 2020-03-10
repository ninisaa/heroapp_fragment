package com.example.user.heroapps;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    public HeroesAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<HeroesModel> getHeroesModels() {
        return heroesModels;
    }

    public void setHeroesModels(ArrayList<HeroesModel> heroesModels) {
        this.heroesModels = heroesModels;
    }

    private ArrayList<HeroesModel> heroesModels;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_fragment_home, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getHeroesModels().get(i).getHeroPict()).into(viewHolder.iv_hero);
        viewHolder.tv_heroName.setText(getHeroesModels().get(i).getHeroName());
        viewHolder.tv_heroDetail.setText(getHeroesModels().get(i).getHeroDetail());
        viewHolder.hero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(context, TujuanActivity.class);
                move.putExtra("name",getHeroesModels().get(i).getHeroName());
                move.putExtra("detail", getHeroesModels().get(i).getHeroDetail());
                context.startActivity(move);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getHeroesModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_hero;
        private TextView tv_heroName, tv_heroDetail;
        private LinearLayout hero;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_hero = itemView.findViewById(R.id.iv_hero);
            tv_heroName = itemView.findViewById(R.id.tv_heroname);
            tv_heroDetail = itemView.findViewById(R.id.tv_herodetail);
            hero = itemView.findViewById(R.id.layout_hero);
        }
    }
}