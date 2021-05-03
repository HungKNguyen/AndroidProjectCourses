package com.example.testingcoursebucket;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Course> courses;
    private ExtendedFloatingActionButton addButton;
    private RecyclerView rv;
    private RVAdapter adapter;
    static final int PICK_COURSE_REQUEST = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ChooseCourseActivity.class);
                startActivityForResult(i, PICK_COURSE_REQUEST);
            }
        });

        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        courses = new ArrayList<>();
        adapter = new RVAdapter(courses) {
            @Override
            public void onClick(View v) {
                int position = rv.getChildLayoutPosition(v);
                Course course = courses.get(position);
                Toast button_clicked = Toast.makeText(MainActivity.this, "Chosen course " + course.getCode(), Toast.LENGTH_SHORT);
                button_clicked.show();
            }
        };
        rv.setAdapter(adapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_COURSE_REQUEST && resultCode == Activity.RESULT_OK) {
            assert data != null;
            Course chosen = (Course) data.getSerializableExtra(ChooseCourseActivity.EXTRA_KEY);
            courses.add(chosen);
            adapter.notifyDataSetChanged();
            //Toast sup = Toast.makeText(MainActivity.this, data.getStringExtra(ChooseCourseActivity.EXTRA_KEY), Toast.LENGTH_SHORT);
            //sup.show();
        }
    }
}