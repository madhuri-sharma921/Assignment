package com.example.trivia_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trivia_app.R;
import com.example.trivia_app.model.DatabaseHelper;
import com.example.trivia_app.model.UserAnswersModel;

public class Summary extends AppCompatActivity {

    TextView hello,cricketerAnswer,colorsAnswers;
    Button finish,history;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        cricketerAnswer=findViewById(R.id.edit2);
        colorsAnswers=findViewById(R.id.edit3);
        hello=findViewById(R.id.hello);
        finish=findViewById(R.id.button3);
        history=findViewById(R.id.button4);

        db = new DatabaseHelper(this);

        Intent i = getIntent();
        UserAnswersModel userModel = (UserAnswersModel)i.getSerializableExtra("userModel");
        if(userModel != null){
            hello.setText("Hello "+userModel.getName());
            cricketerAnswer.setText(userModel.getBestCricketer());
            colorsAnswers.setText(userModel.getColorsInFlag());
            db.insertUser(userModel);
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Summary.this,FirstActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Summary.this,History.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}