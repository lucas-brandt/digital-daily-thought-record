package com.lucasbrandt.dailythoughtrecord.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DtrDao {

    @Query("SELECT * FROM dtr_entries")
    List<DtrDataRecord> getAll();

    @Insert
    void insert(DtrDataRecord dataRecord);

    @Delete
    void delete(DtrDataRecord dataRecord);
}
