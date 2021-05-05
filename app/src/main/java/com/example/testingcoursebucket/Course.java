package com.example.testingcoursebucket;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Course implements Serializable {
    private String code;
    private String title;
    private int credit;
    private ArrayList<String[]> prerequisite;
    private String flavortext;

    public Course(String code, String title, int credit) {
        this.code = code;
        this.title = title;
        this.credit = credit;
        prerequisite = new ArrayList<>();
    }

    public Course addPrerequisite(ArrayList<Course> preCourses) {
        int size = preCourses.size();
        String[] toAdd = new String[size];
        for(int i = 0; i < size; i++) {
            toAdd[i] = preCourses.get(i).getCode();
        }
        prerequisite.add(toAdd);
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() { return credit; }

    public String getFlavortext() { return flavortext; };

    public Course setFlavortext(String flavortext) {
        this.flavortext = flavortext;
        return this;
    }

    public boolean isValid(HashMap<String, String> alreadyTook) {
        if(prerequisite.isEmpty()) {
            return true;
        }
        for(String[] requirement : prerequisite) {
            boolean satisfied = true;
            for(int i = 0; i < requirement.length; i++) {
                if(!alreadyTook.containsKey(requirement[i])) {
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

    @Override
    public boolean equals(@Nullable Object obj) {
        Course other = (Course) obj;
        return this.getCode().equals(other.getCode());
    }
}
