package com.example.testingcoursebucket;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public abstract class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> implements View.OnClickListener {
    private List<Course> courses;
    private Activity activity;

    public CourseAdapter(List<Course> courses, Activity activity) {
        this.courses = courses;
        this.activity = activity;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView code;
        TextView title;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.course_item);
            code = itemView.findViewById(R.id.course_code);
            title = itemView.findViewById(R.id.course_title);
        }
    }

    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_element, parent, false);
        v.setOnClickListener(this);
        CourseViewHolder cvh = new CourseViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        holder.code.setText(courses.get(position).getCode());
        holder.title.setText(courses.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView rv) {
        super.onAttachedToRecyclerView(rv);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Activity getActivity() {
        return activity;
    }
}
