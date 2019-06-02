package com.vistalis.computerdictionary.DatabaseModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "words_favorite")
public class WordFavorite {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String word;
    public String definition;

    public WordFavorite(String word, String definition) {
        this.setWord(word);
        this.setDefinition(definition);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
