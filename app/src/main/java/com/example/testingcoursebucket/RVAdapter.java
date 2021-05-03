package com.example.testingcoursebucket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public abstract class RVAdapter extends RecyclerView.Adapter<RVAdapter.CourseViewHolder> implements View.OnClickListener {
    List<Course> courses;

    public RVAdapter(List<Course> courses) {
        this.courses = courses;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView code;
        TextView title;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.element);
            code = itemView.findViewById(R.id.course_code);
            title = itemView.findViewById(R.id.course_title);
        }
    }

    @NonNull
    @Override
    public RVAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bucket_element, parent, false);
        v.setOnClickListener(this);
        CourseViewHolder cvh = new CourseViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.CourseViewHolder holder, int position) {
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
}
