package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveHealth extends AppCompatActivity implements View.OnClickListener {

    private Button btnSee;
    private RadioGroup rgNumber;

    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final String EXTRA_SELECTED_CHAD = "extra_selected_chad";
    public static final int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_health);

        rgNumber = findViewById(R.id.rg_number);

        btnSee = findViewById(R.id.btn_see_result);
        btnSee.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_see_result){
            if(rgNumber.getCheckedRadioButtonId() != 0){
                int value = 0;
                String chad = "";
                int id = rgNumber.getCheckedRadioButtonId();
                if(id == R.id.radio_0){
                    value = 100;
                    chad = "Giga Chad";
                } else if (id == R.id.radio_1){
                    value = 80;
                    chad = "Chad";
                } else if (id == R.id.radio_2){
                    value = 60;
                    chad = "Euguene";
                } else if (id == R.id.radio_3){
                    value = 40;
                    chad = "Lester";
                } else if (id == R.id.radio_4){
                    value = 20;
                    chad = "Nolep";
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE,value);
                resultIntent.putExtra(EXTRA_SELECTED_CHAD,chad);
                setResult(RESULT_CODE,resultIntent);
                finish();
            }
        }
    }
}