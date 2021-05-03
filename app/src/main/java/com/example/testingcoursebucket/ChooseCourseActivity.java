package com.example.testingcoursebucket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChooseCourseActivity extends Activity {

    private List<Course> catalog;
    private RecyclerView rv_catalog;
    private RVAdapter adapter;
    static final String EXTRA_KEY = "EXTRA_KEY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_course_activity);

        catalog = new Catalog();
        rv_catalog = findViewById(R.id.rv_catalog);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_catalog.setLayoutManager(llm);
        adapter = new RVAdapter(catalog) {
            @Override
            public void onClick(View v) {
                int position = rv_catalog.getChildLayoutPosition(v);
                Course chosen = catalog.get(position);
                Intent data = new Intent();
                data.putExtra(EXTRA_KEY, chosen);
                //data.putExtra(EXTRA_KEY, chosen.getTitle());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        };
        rv_catalog.setAdapter(adapter);
    }
}
