package com.example.newintent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFood,btnCallDoc,btnDrink,btnExercise,btnMeter;
    private TextView healthMeter;

    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
        if (result.getResultCode() == MoveHealth.RESULT_CODE && result.getData() !=null){
            int selectedValue = result.getData().getIntExtra(MoveHealth.EXTRA_SELECTED_VALUE,0);
            String selectedChad = result.getData().getStringExtra(MoveHealth.EXTRA_SELECTED_CHAD);
            healthMeter.setText("Your Health Score = " + selectedValue+ "\nYou represented as " + selectedChad );
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFood = findViewById(R.id.btn_food);
        btnFood.setOnClickListener(this);

        btnCallDoc = findViewById(R.id.btn_call);
        btnCallDoc.setOnClickListener(this);

        btnDrink = findViewById(R.id.btn_drink);
        btnDrink.setOnClickListener(this);

        btnExercise = findViewById(R.id.btn_exercise);
        btnExercise.setOnClickListener(this);

        btnMeter = findViewById(R.id.btn_healthy_meter);
        btnMeter.setOnClickListener(this);

        healthMeter = findViewById(R.id.text_result_meter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_food){
            Intent moveIntent = new Intent(MainActivity.this,moveFood.class);
            moveIntent.putExtra(moveFood.EXTRA_FOOD,"Iwak");
            moveIntent.putExtra(moveFood.EXTRA_CALORIES,496.1);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.btn_call){
            String phoneNumber = "";
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(call);
        }else if(view.getId() == R.id.btn_drink){
            Drink drink = new Drink();
            drink.setName("Aq*a");
            drink.setCalories(23.1);
            Intent moveDrink = new Intent(MainActivity.this,MoveDrink.class);
            moveDrink.putExtra(MoveDrink.EXTRA_DRINK,drink);
            startActivity(moveDrink);
        }else if(view.getId() == R.id.btn_exercise){
            Exercise exercise = new Exercise();
            exercise.setType("push up");
            exercise.setDuration(4);
            Intent moveExercisee = new Intent(MainActivity.this,moveExercise.class);
            moveExercisee.putExtra(moveExercise.EXTRA_EXERCEISE,exercise);
            startActivity(moveExercisee);
        }else if(view.getId() == R.id.btn_healthy_meter){
            Intent moveResult = new Intent(MainActivity.this,MoveHealth.class);
            resultLauncher.launch(moveResult);
        }
    }
}