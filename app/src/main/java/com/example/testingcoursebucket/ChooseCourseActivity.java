package com.example.testingcoursebucket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChooseCourseActivity extends Activity {

    private List<Course> catalog;
    private RecyclerView rv_catalog;
    private CourseAdapter adapter;
    static final String EXTRA_KEY = "EXTRA_KEY";
    private int termPosition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_course_activity);

        Intent input = getIntent();
        termPosition = input.getIntExtra(TermAdapter.TERM_POSITION, 0);
        catalog = new Catalog(this);
        rv_catalog = findViewById(R.id.rv_catalog);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_catalog.setLayoutManager(llm);
        adapter = new CourseAdapter(catalog, this) {
            @Override
            public void onClick(View v) {
                int coursePosition = rv_catalog.getChildLayoutPosition(v);
                Course chosen = catalog.get(coursePosition);
                Intent i = new Intent(getActivity(), CourseDialogActivity.class);
                i.putExtra(CourseDialogActivity.SELECTED_COURSE, chosen);
                i.putExtra(TermAdapter.TERM_POSITION, termPosition);
                i.putExtra(CourseDialogActivity.REQUEST_ORDER, CourseDialogActivity.REQUEST_ADD);
                getActivity().startActivityForResult(i, MainActivity.COURSE_INFO_ADD);
            }
        };
        rv_catalog.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity.COURSE_INFO_ADD && resultCode == Activity.RESULT_OK) {
            setResult(Activity.RESULT_OK, data);
            finish();
        }
    }
}
