package com.vistalis.computerdictionary.DatabaseModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.vistalis.computerdictionary.DatabaseModules.Models.WordFavorite;

import java.util.List;

@Dao
    public interface WordFavoriteDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insertWord(WordFavorite wordFavorite);

        @Query("DELETE from words_favorite WHERE word =:word")
        void deleteFavoriteWord(String word);


    @Query("SELECT * FROM words_favorite")
        List<WordFavorite> getAllFavorites();

        @Query("SELECT word FROM words_favorite")
        List<String> getWords();


}
