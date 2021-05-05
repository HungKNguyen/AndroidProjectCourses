package com.example.testingcoursebucket;

import android.app.Activity;
import android.content.res.Resources;

import java.util.ArrayList;

public class Catalog extends ArrayList<Course> {
    Activity activity;
    public Catalog(Activity activity) {
        //Hardcoded for now
        super();
        this.activity = activity;

        add(new Course("CMSC 106", "Web Client Programming", 6)
              .setFlavortext(activity.getString(R.string.CMSC_106_text)));

        add(new Course("CMSC 150", "Introduction to Computer Science", 6)
                .setFlavortext(activity.getString(R.string.CMSC_150_text)));

        add(new Course("CMSC 205", "Data-Scientific Programming", 6)
                .setFlavortext(activity.getString(R.string.CMSC_205_text)));

        add(new Course("CMSC 208", "Machine Learning", 6)
                .setFlavortext(activity.getString(R.string.CMSC_208_text)));

        add(new Course("CMSC 210", "Introduction to Scientific Programming", 6)
                .setFlavortext(activity.getString(R.string.CMSC_210_text)));

        add(new Course("CMSC 250", "Intermediate Programming Concepts", 6)
                .setFlavortext(activity.getString(R.string.CMSC_250_text)));

        add(new Course("CMSC 270", "Introduction to Data Structures", 6)
                .setFlavortext(activity.getString(R.string.CMSC_270_text)));

        add(new Course("CMSC 405", "Advanced Data Computing", 6)
                .setFlavortext(activity.getString(R.string.CMSC_405_text)));

        add(new Course("CMSC 410", "Systems Analysis and Design", 6)
                .setFlavortext(activity.getString(R.string.CMSC_410_text)));

        add(new Course("CMSC 420", "Computer Graphics", 6)
                .setFlavortext(activity.getString(R.string.CMSC_420_text)));

        add(new Course("CMSC 435", "Computer Organization & Architecture", 6)
                .setFlavortext(activity.getString(R.string.CMSC_435_text)));

        add(new Course("CMSC 460", "Programming Languages", 6)
                .setFlavortext(activity.getString(R.string.CMSC_460_text)));

        add(new Course("CMSC 470", "Artificial Intelligence", 6)
                .setFlavortext(activity.getString(R.string.CMSC_470_text)));

        add(new Course("CMSC 480", "Systems Programming", 6)
                .setFlavortext(activity.getString(R.string.CMSC_480_text)));

        add(new Course("CMSC 510", "Data Structures and Algorithm Analysis", 6)
                .setFlavortext(activity.getString(R.string.CMSC_510_text)));

        add(new Course("CMSC 515", "Theory of Computation", 6)
                .setFlavortext(activity.getString(R.string.CMSC_515_text)));

        add(new Course("CMSC 600", "Computer Science Senior Seminar", 3)
                .setFlavortext(activity.getString(R.string.CMSC_600_text)));

        add(new Course("CMSC 698", "Computer Science Senior Projects", 3)
                .setFlavortext(activity.getString(R.string.CMSC_698_text)));
    }
}
