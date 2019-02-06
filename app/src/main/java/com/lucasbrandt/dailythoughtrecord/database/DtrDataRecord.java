package com.lucasbrandt.dailythoughtrecord.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "dtr_entries")
public class DtrDataRecord {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "date")
    public Date date = new Date(System.currentTimeMillis());

    @ColumnInfo(name = "situation")
    public String situation;

    @ColumnInfo(name = "emotion")
    public String emotion;

    @ColumnInfo(name = "automatic_thoughts")
    public String automaticThoughts;

    @ColumnInfo(name = "rational_response")
    public String rationalResponse;

    @ColumnInfo(name = "outcome_emotion")
    public String outcomeEmotion;
}
