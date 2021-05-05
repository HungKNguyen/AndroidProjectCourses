package com.example.testingcoursebucket;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder>  {
    private List<Term> terms;
    private Activity activity;
    public static String  TERM_POSITION = "TERM_POSITION";

    public TermAdapter(List<Term> terms, Activity activity) {
        this.terms = terms;
        this.activity = activity;
    }

    public static class TermViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        RecyclerView recyclerView;
        ExtendedFloatingActionButton button;

        public TermViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.term_item);
            title = itemView.findViewById(R.id.term_title);
            recyclerView = itemView.findViewById(R.id.course_rv);
            button = itemView.findViewById(R.id.floatingActionButton);
        }

    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.term_element, parent, false);
        return new TermViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int term_position) {
        RecyclerView.LayoutManager llm = new LinearLayoutManager(activity);
        holder.recyclerView.setLayoutManager(llm);
        ArrayList<Course> courses = new ArrayList<>();
        CourseAdapter adapter = new CourseAdapter(courses, activity) {
            @Override
            public void onClick(View v) {
                int course_position = holder.recyclerView.getChildLayoutPosition(v);
                Course course = courses.get(course_position);
                Intent i = new Intent(activity, CourseDialogActivity.class);
                i.putExtra(CourseDialogActivity.SELECTED_COURSE, course);
                i.putExtra(TERM_POSITION, term_position);
                i.putExtra(CourseDialogActivity.REQUEST_ORDER, CourseDialogActivity.REQUEST_REMOVE);
                activity.startActivityForResult(i, MainActivity.COURSE_INFO_REMOVE);
            }
        };
        holder.recyclerView.setAdapter(adapter);

        holder.title.setText(terms.get(term_position).getSeason() + " " + terms.get(term_position).getYear());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, ChooseCourseActivity.class);
                i.putExtra(TERM_POSITION, term_position);
                activity.startActivityForResult(i, MainActivity.COURSE_INFO_ADD);
            }
        });
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }
}
