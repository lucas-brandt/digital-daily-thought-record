package com.lucasbrandt.dailythoughtrecord.dependencyinjection;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.lucasbrandt.dailythoughtrecord.database.DtrDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public DtrDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, DtrDatabase.class, "dtr_database.db")
                .fallbackToDestructiveMigration()
                .build();
    }
}
