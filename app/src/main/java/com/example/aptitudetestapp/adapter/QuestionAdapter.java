package com.example.aptitudetestapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aptitudetestapp.R;
import com.example.aptitudetestapp.model.InputQues;
import com.example.aptitudetestapp.model.ResponseComingQues;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    List<InputQues> questions_list;
    Context context;

    public QuestionAdapter(Context context, List<InputQues> responseComingQues) {
        this.questions_list = responseComingQues;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {

        holder.tv.setText(questions_list.get(position).getQues());

        holder.r1.setText(questions_list.get(position).getOp1());
        holder.r2.setText(questions_list.get(position).getOp2());
        holder.r3.setText(questions_list.get(position).getOp3());
        holder.r4.setText(questions_list.get(position).getOp4());

        holder.r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context.getApplicationContext(), "cheked 1", Toast.LENGTH_LONG).show();
                    questions_list.get(holder.getAdapterPosition()).setWhich_checked(1);
                }
            }
        });

        holder.r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context.getApplicationContext(), "cheked 2", Toast.LENGTH_LONG).show();
                    questions_list.get(holder.getAdapterPosition()).setWhich_checked(2);
                }
            }
        });

        holder.r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context.getApplicationContext(), "cheked 3", Toast.LENGTH_LONG).show();
                    questions_list.get(holder.getAdapterPosition()).setWhich_checked(3);
                }
            }
        });

        holder.r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //Toast.makeText(context.getApplicationContext(), "cheked 4", Toast.LENGTH_LONG).show();
                    questions_list.get(holder.getAdapterPosition()).setWhich_checked(4);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        RadioButton r1, r2, r3, r4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.question);
            r1 = itemView.findViewById(R.id.one);
            r2 = itemView.findViewById(R.id.two);
            r3 = itemView.findViewById(R.id.three);
            r4 = itemView.findViewById(R.id.four);

        }
    }
}