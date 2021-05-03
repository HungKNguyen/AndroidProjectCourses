package com.example.testingcoursebucket;

import java.util.ArrayList;

public class Catalog extends ArrayList<Course> {
    public Catalog() {
        super();
        add(new Course("CMSC100", "Intro to HTML"));
        add(new Course("CMSC150", "Intro to OOP"));
        add(new Course("CMSC200", "Data Structure"));
        add(new Course("CMSC350", "Android Developing"));
    }
}
