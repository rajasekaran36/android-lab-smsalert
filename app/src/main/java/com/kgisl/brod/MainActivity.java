package com.kgisl.brod;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{
    AlertDialog.Builder builder;
    BroadcastObserver observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},1000);
        builder = new AlertDialog.Builder(this);
        observer = BroadcastObserver.getInstance();
        observer.addObserver(this);
        Log.d("ob", "observer added");
        //Setting message manually and performing action on button click
        //createDio();

    }
    public void createDio(){
        Log.d("ob", "create dio called");
        builder.setMessage("Do you want to view?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"YES",Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("You got new SMS");
        alert.show();
        Log.d("ob", "alert show");
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d("ob", "update called");
        createDio();
    }
}
