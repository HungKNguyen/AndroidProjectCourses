package com.example.testingcoursebucket;

import java.util.ArrayList;
import java.util.HashMap;

public class Term {
    private int year;
    private String season;
    private int total_credit;
    private ArrayList<Course> taking;
    private boolean warning;

    public Term(int year, String season) {
        this.year = year;
        this.season = season;
        total_credit = 0;
        taking = new ArrayList<>();
        warning = false;
    }

    public int getYear() {
        return year;
    }

    public String getSeason() {
        return season;
    }

    public int getTotal_credit() {
        return total_credit;
    }

    public ArrayList<Course> getTaking() {
        return taking;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }
}
