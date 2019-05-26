package com.example.kemila.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.kemila.room.Dao.NamesDao;
import com.example.kemila.room.model.Names;

//Put Entities here
@Database(entities = {Names.class,},

        version = 1, exportSchema = false)
public abstract class Db extends RoomDatabase {

    public abstract NamesDao namesDao() ;
}
