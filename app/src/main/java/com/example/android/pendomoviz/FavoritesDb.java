package com.example.android.pendomoviz;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Favorites.class}, version = 1)
public abstract class FavoritesDb extends RoomDatabase {


    private static final String DATABASE_NAME = "favoritemovies_db";
    private static FavoritesDb INSTANCE;
    public  abstract FavoritesDao favoritesDao();


    public static FavoritesDb getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), FavoritesDb.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
