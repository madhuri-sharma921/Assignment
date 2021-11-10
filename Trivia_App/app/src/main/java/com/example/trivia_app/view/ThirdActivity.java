package com.example.trivia_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.trivia_app.R;
import com.example.trivia_app.model.UserAnswersModel;

public class ThirdActivity extends AppCompatActivity {
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    CheckBox c4;
    Button next;
    String checkBoxSelectedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        checkBoxSelectedList = "";
        c1=findViewById(R.id.checkbox1);
        c2=findViewById(R.id.checkbox2);
        c3=findViewById(R.id.checkbox3);
        c4=findViewById(R.id.checkbox4);
        next=findViewById(R.id.button2);

        Intent i = getIntent();
        UserAnswersModel userModel = (UserAnswersModel)i.getSerializableExtra("userModel");

        next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(noCheckBoxSelected()){
                        Toast toast= Toast.makeText(getApplicationContext(),"Please select your answer",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    else{
                        checkBoxSelectedList = getSelectedCheckBoxSelectedList();
                        Intent intent=new Intent(ThirdActivity.this,Summary.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        if(userModel != null){
                            intent.putExtra("userModel",userModel);
                            if(!(checkBoxSelectedList.isEmpty())){
                                userModel.setColorsInFlag(checkBoxSelectedList);
                                intent.putExtra("userModel",userModel);
                                startActivity(intent);
                            }
                        }
                    }
                }
            });
        }

    private String getSelectedCheckBoxSelectedList() {
        StringBuilder sb=new StringBuilder();
        if(c1.isChecked())
            sb.append(c1.getText().toString().substring(3)).append(",");
        if(c2.isChecked())
            sb.append(c2.getText().toString().substring(3)).append(",");
        if(c3.isChecked())
            sb.append(c3.getText().toString().substring(3)).append(",");
        if(c4.isChecked())
            sb.append(c4.getText().toString().substring(3)).append(",");

        return sb.toString().substring(0,sb.toString().length()-1);
    }

    private boolean noCheckBoxSelected() {
        return !c1.isChecked() && !c2.isChecked() && !c3.isChecked() && !c4.isChecked();
    }
}

