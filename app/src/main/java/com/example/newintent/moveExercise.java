package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class moveExercise extends AppCompatActivity {

    public static final String EXTRA_EXERCEISE ="extra_exercise";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_exercise);

        TextView textData = findViewById(R.id.data_exercise);
        Exercise exercise = getIntent().getParcelableExtra(EXTRA_EXERCEISE);
        String text = "Name\t: " + exercise.getType() + "Duration: " + exercise.getDuration();
        textData.setText(text);

    }
}