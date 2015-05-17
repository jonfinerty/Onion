package com.jonathanfinerty.onionexampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jonathanfinerty.onion.Onion;
import com.jonathanfinerty.onionexampleapp.commands.RequestTextCommand;
import com.jonathanfinerty.onionexampleapp.commands.UpdateDatabaseCommand;


public class MainActivity extends Activity implements RequestTextCommand.Callbacks, UpdateDatabaseCommand.Callbacks {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.main_activity_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fire command off
                RequestTextCommand requestTextCommand = new RequestTextCommand("YO");
                Onion onion = new Onion();
                onion.executeCommand(MainActivity.this, requestTextCommand, MainActivity.this);
            }
        });

        Button button2 = (Button) findViewById(R.id.main_activity_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fire command off
                UpdateDatabaseCommand updateDatabaseCommand = new UpdateDatabaseCommand();
                Onion onion = new Onion();
                onion.executeCommand(MainActivity.this, updateDatabaseCommand, MainActivity.this);
            }
        });


        textView = (TextView) findViewById(R.id.main_activity_textView);
    }

    @Override
    public void returnText(String text) {
        textView.setText(text);
    }

    @Override
    public void databaseUpdated() {
        textView.setText("DATABASE UPDATED");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button1, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
