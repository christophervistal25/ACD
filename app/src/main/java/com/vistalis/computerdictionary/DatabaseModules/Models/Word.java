package com.vistalis.computerdictionary.DatabaseModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "words")
    public class Word {
        @PrimaryKey(autoGenerate = true)
        public int id;
        public String word;
        public String definition;

        public Word(String word, String definition) {
            this.word = word;
            this.definition = definition;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
            return word;
        }

        public String getDefinition() {
            return definition;
        }

    }
