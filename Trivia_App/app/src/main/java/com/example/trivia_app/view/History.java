package com.example.trivia_app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trivia_app.R;
import com.example.trivia_app.adapter.UserAnswerAdapter;
import com.example.trivia_app.model.DatabaseHelper;
import com.example.trivia_app.model.UserAnswersModel;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    private UserAnswerAdapter mAdapter;
    private List<UserAnswersModel> userAnswersModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recycler_view);
        db = new DatabaseHelper(this);

        userAnswersModels.addAll(db.getAllUsers());

        mAdapter = new UserAnswerAdapter(this, userAnswersModels);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}