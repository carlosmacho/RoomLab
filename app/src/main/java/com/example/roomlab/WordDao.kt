package com.example.roomlab

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the data has changed.
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Query("SELECT * FROM word_table WHERE word LIKE 'p%'")
    fun getP(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Query("delete from word_table where word = 'lapis'")
    suspend fun deleteLapis()

    @Query("update word_table set word='andre' where word = 'lapis'")
    suspend fun updateLapis()

}