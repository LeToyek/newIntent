package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class moveFood extends AppCompatActivity {

    public static final String EXTRA_FOOD = "extra_food";
    public static final String EXTRA_CALORIES = "extra_calories";
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_food);

        tvData = findViewById(R.id.text_data);

        String food = getIntent().getStringExtra(EXTRA_FOOD);
        double calories = getIntent().getDoubleExtra(EXTRA_CALORIES,0);
        String text = "Food\t\t: " + food + "\nCalories\t: " + calories;
        tvData.setText(text);

    }
}