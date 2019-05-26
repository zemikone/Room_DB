package com.example.kemila.room;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.kemila.room.model.Names;
import com.example.kemila.room.model.Repository;

public class Home extends AppCompatActivity {

    Db db;
    Names names;
    Button btsave;
    EditText iName,iPrice;
    Repository repository;
    App app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btsave = findViewById(R.id.btnSave);
        iName = findViewById(R.id.txtName);
        iPrice = findViewById(R.id.txtPrice);

        app=new App();
        db=app.get().getDb();
        names =new Names();
        repository = new Repository();

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                names.setName(iName.getText().toString());
                names.setPrice(iPrice.getText().toString());
                repository.saveName(names);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repository.getNames();
                String text="";
                for(int i=0;i<repository.getNames().size();i++)
                {
                    text = text.toString() + repository.getNames().get(i).getName()+" "+ repository.getNames().get(i).getPrice() + ",";
                }
                Snackbar.make(view, text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
