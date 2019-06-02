package com.vistalis.computerdictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vistalis.computerdictionary.Adapters.WordsFavoriteAdapter;
import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.WordFavorite;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WordsFavoriteAdapter wordsFavoriteAdapter;
    LinearLayoutManager layoutManager;
    List<WordFavorite> word_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        this.setActivityToFullScreen();
        this.buildRecyclerView();
    }

    private void buildRecyclerView() {

        word_list = DB.getInstance(this).wordFavoriteDao().getAllFavorites();

        wordsFavoriteAdapter = new WordsFavoriteAdapter(word_list);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,
                        LinearLayoutManager.VERTICAL)
        );

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(wordsFavoriteAdapter);

    }

    private void setActivityToFullScreen()
    {
        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
