package com.example.trivia_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trivia_app.R;
import com.example.trivia_app.model.UserAnswersModel;


public class FirstActivity extends AppCompatActivity {
    EditText name;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        name=findViewById(R.id.edit_text1);
        nextButton=findViewById(R.id.button1);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(name.getText().toString().isEmpty())){
                    Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                    UserAnswersModel userAnswersModel = new UserAnswersModel();
                    userAnswersModel.setName(name.getText().toString().trim());
                    intent.putExtra("userModel", userAnswersModel);
                    startActivity(intent);
                }
                else
                    name.setError("Required Field");
            }
        });
    }
}
