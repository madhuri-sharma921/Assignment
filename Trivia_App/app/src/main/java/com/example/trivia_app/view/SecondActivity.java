package com.example.trivia_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.trivia_app.R;
import com.example.trivia_app.model.UserAnswersModel;

public class SecondActivity extends AppCompatActivity {
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    Button next;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String radioButtonValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        r1=findViewById(R.id.radioButton1);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
        r4=findViewById(R.id.radioButton4);
        next=findViewById(R.id.button2);
        radioGroup = findViewById(R.id.group);

        Intent i = getIntent();
        UserAnswersModel userModel = (UserAnswersModel)i.getSerializableExtra("userModel");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton = (RadioButton) findViewById(checkedId);
                radioButtonValue = radioButton.getText().toString();
            }
        }
        );

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButtonValue.isEmpty()){
                    Toast toast= Toast.makeText(getApplicationContext(),"Please select your answer",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else{
                    Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                    if(userModel != null)
                    {
                        userModel.setBestCricketer(radioButtonValue.substring(3));
                        intent.putExtra("userModel",userModel);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}