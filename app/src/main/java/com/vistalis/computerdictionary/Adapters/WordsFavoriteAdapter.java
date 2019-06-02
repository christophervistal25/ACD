package com.vistalis.computerdictionary.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vistalis.computerdictionary.DatabaseModules.Models.Word;
import com.vistalis.computerdictionary.DatabaseModules.Models.WordFavorite;
import com.vistalis.computerdictionary.R;

import java.util.ArrayList;
import java.util.List;

public class WordsFavoriteAdapter extends RecyclerView.Adapter<WordsFavoriteAdapter.WordFavoriteHolder>  {

    private List<WordFavorite> list_favorites;

    public WordsFavoriteAdapter(List<WordFavorite> list_word) {
        this.list_favorites = list_word;
    }


    @NonNull
    @Override
    public WordFavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.words_favorite, parent, false);
        return new WordsFavoriteAdapter.WordFavoriteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordFavoriteHolder holder, int position) {
        WordFavorite word = list_favorites.get(position);
        holder.word.setText(word.getWord());
        holder.wordDescription.setText(word.getDefinition());
    }



    @Override
    public int getItemCount() {
        return list_favorites.size();
    }



    class WordFavoriteHolder extends RecyclerView.ViewHolder {
        TextView word;
        TextView wordDescription;

        public WordFavoriteHolder(View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
            wordDescription = itemView.findViewById(R.id.wordDescription);

        }
    }
}
