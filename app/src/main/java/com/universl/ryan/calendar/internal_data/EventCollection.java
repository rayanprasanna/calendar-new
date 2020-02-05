package com.universl.ryan.calendar.internal_data;

import java.util.ArrayList;

public class EventCollection {
    public String date="";
    public String name="";
    public String subject="";
    public String description="";


    public static ArrayList<EventCollection> date_collection_arr;

    public EventCollection(String date, String name, String subject, String description){

        this.date=date;
        this.name=name;
        this.subject=subject;
        this.description= description;

    }
}
