package com.example.randomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textRolled = null;
    private SeekBar barMax = null;
    private TextView textMax = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMax = (TextView) findViewById(R.id.textMax);
        textRolled = (TextView) findViewById(R.id.textRolled);
        barMax = (SeekBar) findViewById(R.id.barMax);
        // nastavenie listenera na zmenu hodnoty seekbaru a updatnutie textu s max hodnotou

        barMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textMax.setText("Max = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void onRollClick(View v) {
        final int max = barMax.getProgress();
        int rolled;
        Random r = new Random();

        rolled = r.nextInt(max + 1);

        textRolled.setText(rolled + "");
    }

}