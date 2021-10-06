package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveDrink extends AppCompatActivity {

    public static final String EXTRA_DRINK = "extra_drink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_drink);

        TextView textDrink = findViewById(R.id.text_drink);
        Drink drink = getIntent().getParcelableExtra(EXTRA_DRINK);
        String text = "Name\t\t: " + drink.getName() +"\nCalories\t: " + drink.getCalories();
        textDrink.setText(text);

    }
}