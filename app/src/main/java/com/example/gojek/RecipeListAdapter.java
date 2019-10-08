package com.example.gojek;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {
    private Context context;
    private List<Recipe> cartList;
    private Animation animationUp;
    private Animation animationDown;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, url, chef, timestamp,forks,stars,languageColor,language;
        public ImageView thumbnail,lang,starcolor,forking;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            forks = view.findViewById(R.id.fork);
            description = view.findViewById(R.id.description);
            url = view.findViewById(R.id.url);
            thumbnail = view.findViewById(R.id.thumbnail);
            stars = view.findViewById(R.id.star);
            lang = view.findViewById(R.id.langcolor);
            language= view.findViewById(R.id.language);
            starcolor=view.findViewById(R.id.starcolor);
            forking = view.findViewById(R.id.forkimg);
        }
    }


    public RecipeListAdapter(Context context, List<Recipe> cartList) {
        this.context = context;
        this.cartList = cartList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Recipe recipe = cartList.get(position);
        holder.name.setText(recipe.getName());
         holder.stars.setText(recipe.getStars());
        holder.description.setText(recipe.getDescription());
       holder.url.setText(recipe.getUrl());
       holder.forks.setText(recipe.getForks());
        holder.language.setText(recipe.getLanguage());
//       String color=recipe.getLanguageColor().trim();
       /* if (recipe.languageColor!= null) {
            holder.lang.setBackgroundColor(Color.parseColor(color));
        }*/
       /* try{
           // color = Color.parseColor(RemoteConfigSingleton.getInstance().getEventColor());
            holder.lang.setBackgroundColor(Color.parseColor(color));
        }catch (IllegalArgumentException e){
            //color = Color.parseColor("#E53935");
            holder.lang.setBackgroundColor(Color.parseColor("FFFFFF"));
        }*/
        Glide.with(context)
                .load(recipe.getAvatar())
                .into(holder.thumbnail);
        holder.url.setVisibility(View.GONE);
        holder.lang.setVisibility(View.GONE);
        holder.language.setVisibility(View.GONE);
        holder.forks.setVisibility(View.GONE);
        holder.forking.setVisibility(View.GONE);
        holder.stars.setVisibility(View.GONE);
        holder.starcolor.setVisibility(View.GONE);

        animationUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        animationDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( holder.url.isShown()){
                    holder.url.setVisibility(View.GONE);
                    holder.lang.setVisibility(View.GONE);
                    holder.language.setVisibility(View.GONE);
                    holder.forks.setVisibility(View.GONE);
                    holder.forking.setVisibility(View.GONE);
                    holder.stars.setVisibility(View.GONE);
                    holder.starcolor.setVisibility(View.GONE);
                    holder.url.startAnimation(animationUp);
                }
                else{
                    holder.url.setVisibility(View.VISIBLE);
                    holder.lang.setVisibility(View.VISIBLE);
                    holder.language.setVisibility(View.VISIBLE);
                    holder.forks.setVisibility(View.VISIBLE);
                    holder.forking.setVisibility(View.VISIBLE);
                    holder.stars.setVisibility(View.VISIBLE);
                    holder.starcolor.setVisibility(View.VISIBLE);
                    holder.url.startAnimation(animationDown);
                }
            }
        });
    }
    // recipe
    @Override
    public int getItemCount() {
        return cartList.size();
    }
}