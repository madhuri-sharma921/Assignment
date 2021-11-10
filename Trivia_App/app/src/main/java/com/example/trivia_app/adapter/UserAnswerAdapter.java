package com.example.trivia_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trivia_app.R;
import com.example.trivia_app.model.UserAnswersModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserAnswerAdapter extends RecyclerView.Adapter<UserAnswerAdapter.MyViewHolder>{
    private Context context;
    private List<UserAnswersModel> userAnswersModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView gameTime;
        public TextView name;
        public TextView cricketerAnswer;
        public TextView colorAnswer;

        public MyViewHolder(View view) {
            super(view);
            gameTime = view.findViewById(R.id.game_time);
            name = view.findViewById(R.id.name);
            cricketerAnswer = view.findViewById(R.id.edit2);
            colorAnswer = view.findViewById(R.id.edit3);
        }
    }

    public UserAnswerAdapter(Context context, List<UserAnswersModel> userAnswersModels) {
        this.context = context;
        this.userAnswersModelList = userAnswersModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserAnswersModel userAnswersModel = userAnswersModelList.get(position);

        holder.gameTime.setText("Game "+(position+1)+ " : "+ formatDate(userAnswersModel.getTimestamp()));
        holder.name.setText("Name : "+ userAnswersModel.getName());
        holder.cricketerAnswer.setText("Answer : "+ userAnswersModel.getBestCricketer());
        holder.colorAnswer.setText("Answers : "+userAnswersModel.getColorsInFlag());
    }

    @Override
    public int getItemCount() {
        return userAnswersModelList.size();
    }

    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}
