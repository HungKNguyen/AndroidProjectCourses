package com.example.testingcoursebucket;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class CourseDialogActivity extends Activity{
    private Button cancel;
    private Button action;
    private TextView title;
    private TextView body;
    private TextView unit;
    static final String SELECTED_COURSE = "SELECTED_COURSE";
    static final String REQUEST_ORDER = "REQUEST_ORDER";
    static final int REQUEST_ADD = 1;
    static final int REQUEST_REMOVE = 0;
    Course selected;
    int term_position;
    int request;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_dialog);
        Intent data = getIntent();

        selected = (Course) data.getSerializableExtra(SELECTED_COURSE);
        term_position = data.getIntExtra(TermAdapter.TERM_POSITION, 0);
        request = data.getIntExtra(REQUEST_ORDER, 0);

        title = findViewById(R.id.course_dialog_title);
        title.setText(selected.getCode());

        body = findViewById(R.id.course_dialog_description_body);
        body.setText(selected.getFlavortext());

        unit = findViewById(R.id.course_dialog_unit_body);
        unit.setText(String.valueOf(selected.getCredit()));

        cancel = findViewById(R.id.course_dialog_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        action = findViewById(R.id.course_dialog_confirm);
        switch (request) {
            case REQUEST_ADD:
                action.setText("ADD COURSE");
                break;
            case REQUEST_REMOVE:
                action.setText("REMOVE COURSE");
                break;
        }
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(SELECTED_COURSE, selected);
                data.putExtra(TermAdapter.TERM_POSITION, term_position);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
