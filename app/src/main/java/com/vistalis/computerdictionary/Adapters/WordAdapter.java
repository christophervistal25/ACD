package com.vistalis.computerdictionary.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.Word;
import com.vistalis.computerdictionary.DatabaseModules.Models.WordFavorite;
import com.vistalis.computerdictionary.R;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {

    private List<Word> list_word;
    private List<String> favoriteWords;


    public WordAdapter(List<Word> list_word) {
        this.list_word = list_word;
    }

    @Override
    public WordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_layout, parent, false);
        return new WordHolder(view);
    }

    @Override
    public void onBindViewHolder(WordHolder holder, int position) {
        Word word = list_word.get(position);
        Context context = holder.word.getContext();

        favoriteWords = DB.getInstance(context).wordFavoriteDao().getWords();

        holder.word.setText(word.getWord());

        if (favoriteWords.contains(word.getWord())) {
            holder.btnFavorite.setImageResource(R.drawable.ic_favorite_2_black_24dp);
        } else {
            holder.btnFavorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }

        holder.btnFavorite.setOnClickListener(v -> {
            String message;

            if (favoriteWords.contains(word.getWord())) {
                message = "Successfully remove to your favorites";
                DB.getInstance(context).wordFavoriteDao().deleteFavoriteWord(word.getWord());
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);

            } else {
                message = "Successfully add to your favorites";
                DB.getInstance(context).wordFavoriteDao().insertWord(
                        new WordFavorite(word.getWord(),word.getDefinition()));
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_2_black_24dp);
            }

            favoriteWords = new ArrayList<>();

            favoriteWords = DB.getInstance(context).wordFavoriteDao().getWords();




            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });




        holder.word.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(word.getWord());
            builder.setMessage(word.getDefinition()).create().show();
        });

    }

    @Override
    public int getItemCount() {
        return list_word.size();
    }

    public void filterList(ArrayList<Word> filteredList) {
        list_word = filteredList;
        notifyDataSetChanged();
    }

    class WordHolder extends RecyclerView.ViewHolder {
        TextView word;
        ImageButton btnFavorite;

        public WordHolder(View itemView) {
            super(itemView);

            word = itemView.findViewById(R.id.word);
            btnFavorite = itemView.findViewById(R.id.btnFavorite);

        }
    }
}