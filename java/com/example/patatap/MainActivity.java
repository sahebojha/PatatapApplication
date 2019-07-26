package com.example.patatap;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void playMusic(View view){
        int id = view.getId();
        Log.i("ID", "ID value is " + id);

        String nameID;
        nameID = view.getResources().getResourceEntryName(id);

        Log.i("nameID", "my NAME ID IS: " + nameID);

        int myMusic = getResources().getIdentifier(nameID, "raw", "com.example.patatap");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, myMusic);
        mediaPlayer.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void onBackPressed()  {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}

