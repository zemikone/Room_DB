
package com.example.kemila.room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kemila.room.model.Names;

import java.util.List;


@Dao
public interface NamesDao {

    @Insert
    void insertSingleName(Names names);

    @Insert
    void insertMultipleNames(List<Names> nameList);

//    @Query("SELECT * FROM Names WHERE name_id = sent_id")
//    Names getNameById (int send_id);

    @Query("SELECT * FROM Names")
    List<Names> getName ();

    @Update
    void updateNames(Names name);

    @Delete
    void deleteNames(Names name);

}
