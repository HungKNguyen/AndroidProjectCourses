package com.example.testingcoursebucket;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    static final int COURSE_INFO_ADD = 1;
    static final int COURSE_INFO_REMOVE = 2;
    RecyclerView term_rv;
    List<Term> terms;
    TermAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        term_rv = findViewById(R.id.term_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        term_rv.setLayoutManager(llm);

        terms = new ArrayList<>();
        terms.add(new Term(2021, "Fall"));
        terms.add(new Term(2021, "Winter"));
        terms.add(new Term(2021, "Spring"));
        adapter = new TermAdapter(terms, this);
        term_rv.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == COURSE_INFO_ADD && resultCode == Activity.RESULT_OK) {
            assert data != null;
            Course chosen = (Course) data.getSerializableExtra(CourseDialogActivity.SELECTED_COURSE);
            int term_position = data.getIntExtra(TermAdapter.TERM_POSITION, 0);
            CardView cv = (CardView) term_rv.getChildAt(term_position);
            RecyclerView course_rv = cv.findViewById(R.id.course_rv);
            CourseAdapter courseAdapter = (CourseAdapter) course_rv.getAdapter();
            List<Course> courses = courseAdapter.getCourses();
            courses.add(chosen);
            courseAdapter.notifyDataSetChanged();
        } else if(requestCode == COURSE_INFO_REMOVE && resultCode == Activity.RESULT_OK) {
            assert data != null;
            Course chosen = (Course) data.getSerializableExtra(CourseDialogActivity.SELECTED_COURSE);
            int term_position = data.getIntExtra(TermAdapter.TERM_POSITION, 0);
            CardView cv = (CardView) term_rv.getChildAt(term_position);
            RecyclerView course_rv = cv.findViewById(R.id.course_rv);
            CourseAdapter courseAdapter = (CourseAdapter) course_rv.getAdapter();
            List<Course> courses = courseAdapter.getCourses();
            courses.remove(chosen);
            courseAdapter.notifyDataSetChanged();
        }
    }
}