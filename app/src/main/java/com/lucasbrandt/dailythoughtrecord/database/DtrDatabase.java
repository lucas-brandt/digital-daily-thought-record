package com.lucasbrandt.dailythoughtrecord.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {DtrDataRecord.class}, version = 1)
public abstract class DtrDatabase extends RoomDatabase {
    public abstract DtrDao dtrDao();
}

