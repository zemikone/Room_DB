package com.example.kemila.room.model;

import com.example.kemila.room.App;
import com.example.kemila.room.Dao.NamesDao;
import com.example.kemila.room.Db;

import java.util.List;

public class Repository {

    public void saveName(Names names)
    {
        NamesDao namesDao= App.get().getDb().namesDao();
        namesDao.insertSingleName(names);

    }

    public List<Names> getNames()
    {
        NamesDao namesDao= App.get().getDb().namesDao();
       return namesDao.getName();

    }

    }

