package com.example.testingcoursebucket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Course implements Serializable { //Later implements Parcelable for faster performance
    private String code;
    private String title;
    private ArrayList<Course[]> prerequisite;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
        prerequisite = new ArrayList<>();
    }

    public void addPrerequisite(ArrayList<Course> preCourses) {
        int size = preCourses.size();
        Course[] toAdd = new Course[size];
        for(int i = 0; i < size; i++) {
            toAdd[i] = preCourses.get(i);
        }
        prerequisite.add(toAdd);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public boolean isValid(HashMap<String, String> alreadyTook) {
        if(prerequisite.isEmpty()) {
            return true;
        }
        for(Course[] requirement : prerequisite) {
            boolean satisfied = true;
            for(int i = 0; i < requirement.length; i++) {
                if(!alreadyTook.containsKey(requirement[i].getCode())) {
                    satisfied = false;
                    break;
                }
            }
            if(satisfied) {
                return true;
            }
        }
        return false;
    }
}
