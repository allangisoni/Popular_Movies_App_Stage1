package com.example.android.pendomoviz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.pendomoviz.Favorites;

import java.util.List;

@Dao
public interface FavoritesDao {

    @Query("SELECT * FROM Favorites")
    List<Favorites> getAll();



    @Insert
    void insertOnlySingleMovie (Favorites favorites);

    @Delete()
    void delete (Favorites favorites);
}
