package com.example.favdish.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.favdish.model.entities.FavDish
import java.util.concurrent.Flow

@Dao
interface FavDishDao {

    @Insert
    suspend fun addFavDishDetails (favDish: FavDish)

    @Query("SELECT * FROM FAV_DISHES_TABLE ORDER BY ID")
    fun getAllDishesList(): kotlinx.coroutines.flow.Flow<List<FavDish>>

    @Update
    suspend fun updateFavDishDetails(favDish: FavDish)
}