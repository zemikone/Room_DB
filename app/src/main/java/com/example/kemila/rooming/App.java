package com.example.kemila.room;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class App extends Application {
    public static App INSTANCE;
    private Db db;
    private static final String DATABASE_NAME = "names_db";

    @Override
    public void onCreate() {

        super.onCreate();

            Stetho.initializeWithDefaults(this);

            db = Room.databaseBuilder(this,
                    Db.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        INSTANCE = this;
    }

    public static App get() {
        return INSTANCE;
    }

    public Db getDb() {
        return db;
    }

}
