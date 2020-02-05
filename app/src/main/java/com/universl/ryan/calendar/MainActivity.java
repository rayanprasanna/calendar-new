package com.universl.ryan.calendar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.universl.ryan.calendar.internal_data.EventCollection;
import com.universl.ryan.calendar.internal_data.SLCalendar;
import com.universl.ryan.calendar.sub_activity.AllHolidayActivity;
import com.universl.ryan.calendar.sub_activity.AwuruduCharitraActivity;
import com.universl.ryan.calendar.sub_activity.RahuTimeActivity;
import com.universl.ryan.calendar.sub_activity.RemindTaskActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    public Calendar cal_month, cal_month_copy;
    private SLCalendar hwAdapter;
    private TextView tv_month;
    RelativeLayout main;
    LinearLayout date_layout;
    LinearLayout holiday,holiday_details;
    TextView month_1,month_2,month_3,month_4,title_1,title_2,title_3,title_4;
    CircleImageView blue_1,green_1,red_1,yellow_1;
    CircleImageView blue_2,green_2,red_2,yellow_2;
    CircleImageView blue_3,green_3,red_3,yellow_3;
    CircleImageView blue_4,green_4,red_4,yellow_4;
    public Activity activity;
    RadioButton blue,red,green,purple,pink,default_color;
    Boolean isBlue = false,isRed = false,isGreen = false,isPurple = false,isPink = false,isNormal = true;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;
        holiday = findViewById(R.id.holiday); holiday_details = findViewById(R.id.holiday_details);

        date_layout = findViewById(R.id.layout);
        main = findViewById(R.id.main); month_1 = findViewById(R.id.month_1); month_2 = findViewById(R.id.month_2); month_3 = findViewById(R.id.month_3); month_4 = findViewById(R.id.month_4);

        blue_1 = findViewById(R.id.blue_1); blue_2 = findViewById(R.id.blue_2); blue_3 = findViewById(R.id.blue_3); blue_4 = findViewById(R.id.blue_4);

        green_1 = findViewById(R.id.green_1); green_2 = findViewById(R.id.green_2); green_3 = findViewById(R.id.green_3); green_4 = findViewById(R.id.green_4);

        red_1 = findViewById(R.id.red_1); red_2 = findViewById(R.id.red_2); red_3 = findViewById(R.id.red_3); red_4 = findViewById(R.id.red_4);

        yellow_1 = findViewById(R.id.yellow_1); yellow_2 = findViewById(R.id.yellow_2); yellow_3 = findViewById(R.id.yellow_3); yellow_4 = findViewById(R.id.yellow_4);

        // 2019 Sri Lanka Calendar
        EventCollection.date_collection_arr=new ArrayList<>(); title_1 = findViewById(R.id.title_1); title_2 = findViewById(R.id.title_2); title_3 = findViewById(R.id.title_3); title_4 = findViewById(R.id.title_4);
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-15" ,"15 - දෙමළ තෛපොංගල් දිනය","Holiday","ජන."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-01-20" ,"20 - දුරුතු පුර පසළොස්වක පෝය දිනය","Holiday","ජන."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-02-04" ,"04 - ජාතික නිදහස් දිනය","Holiday","පෙබ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-02-19" ,"19 - නවම් පුර පසළොස්වක පෝය දිනය","Holiday","පෙබ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-03-04" ,"04 - මහා ශිව රාත්\u200Dරී දිනය","Holiday","මාර්තු"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-03-20" ,"20 - මැදින් පුර පසළොස්වක පෝය දිනය","Holiday","මාර්තු"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-13" ,"13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය","Holiday","අප්\u200Dරේල්"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-14" ,"14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය","Holiday","අප්\u200Dරේල්"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-04-19" ,"19 - බක් පුර පසළොස්වක පෝය දිනය , මහා සිකුරාදා දිනය","Holiday","අප්\u200Dරේල්"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-05-01" ,"01 - ලෝක කම්කරු දිනය","Holiday","මැයි"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-05-18" ,"18 - වෙසක් පුර පසළොස්වක පෝය දිනය","Holiday","මැයි"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-05-19" ,"19 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය","Holiday","මැයි"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-06-05" ,"05 - ඊද්-උල්-ෆීතර්(රාමසාන් දිනය)","Holiday","ජුනි"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-06-16" ,"16 - පොසොන් පුර පසළොස්වක පෝය දිනය","Holiday","ජුනි"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-07-16" ,"16 - ඇසළ පුර පසළොස්වක පෝය දිනය","Holiday","ජුලි"));
        EventCollection.date_collection_arr.add( new EventCollection("2019-08-12" ,"12 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)","Holiday","අගෝ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-08-14" ,"14 - නිකිණි පුර පසළොස්වක පෝය දිනය","Holiday","අගෝ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-09-13" ,"13 - බිනර පුර පසළොස්වක පෝය දිනය","Holiday","සැප්."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-13" ,"13 - වප් පුර පසළොස්වක පෝය දිනය","Holiday","ඔක්."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-10-27" ,"27 - දීපවාලී උත්සව දිනය","Holiday","ඔක්."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-11-10" ,"10 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)","Holiday","නොවැ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-11-12" ,"12 - ඉල් පුර පසළොස්වක පෝය දිනය","Holiday","නොවැ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-12-11" ,"11 - උඳුවප් පුර පසළොස්වක පෝය දිනය","Holiday","දෙසැ."));
        EventCollection.date_collection_arr.add( new EventCollection("2019-12-25" ,"25 - නත්තල් දිනය","Holiday","දෙසැ."));

        //2020 Sri Lanka Calendar
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-10" ,"10 - දුරුතු පුර පසළොස්වක පෝය දිනය","Holiday","ජන."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-15" ,"15 - දෙමළ තෛපොංගල් දිනය","Holiday","ජන."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-02-04" ,"04 - ජාතික නිදහස් දිනය","Holiday","පෙබ."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-08" ,"08 - නවම් පුර පසළොස්වක පෝය දිනය","Holiday","පෙබ."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-21" ,"21 - මහා ශිව රාත්\u200Dරී දිනය","Holiday","පෙබ."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-03-09" ,"09 - මැදින් පුර පසළොස්වක පෝය දිනය","Holiday","මාර්තු"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-04-07" ,"07 - බක් පුර පසළොස්වක පෝය දිනය","Holiday","අප්\u200Dරේල්"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-10" ,"10 - මහා සිකුරාදා දිනය","Holiday","අප්\u200Dරේල්"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-13" ,"13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය","Holiday","අප්\u200Dරේල්"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-14" ,"14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය","Holiday","අප්\u200Dරේල්"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-05-01" ,"01 - ලෝක කම්කරු දිනය","Holiday","මැයි"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-07" ,"07 - වෙසක් පුර පසළොස්වක පෝය දිනය","Holiday","මැයි"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-08" ,"08 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය","Holiday","මැයි"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-24" ,"24 - වඊද්-උල්-ෆීතර්(රාමසාන් දිනය)","Holiday","මැයි"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-06-05" ,"05 - පොසොන් පුර පසළොස්වක පෝය දිනය","Holiday","ජුනි"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-07-04" ,"04 - ඇසළ පුර පසළොස්වක පෝය දිනය","Holiday","ජුලි"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-07-31" ,"31 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)","Holiday","ජුලි"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-08-03" ,"03 - නිකිණි පුර පසළොස්වක පෝය දිනය","Holiday","අගෝ."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-09-01" ,"01 - බිනර පුර පසළොස්වක පෝය දිනය","Holiday","සැප්."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-10-01" ,"01 - අදි වප් පුර පසළොස්වක පෝය දිනය","Holiday","ඔක්."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-29" ,"29 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)","Holiday","ඔක්."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-20" ,"30 - වප් පුර පසළොස්වක පෝය දිනය","Holiday","ඔක්."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-11-14" ,"14 - දීපවාලී උත්සව දිනය","Holiday","නොවැ."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-29" ,"29 - ඉල් පුර පසළොස්වක පෝය දිනය","Holiday","නොවැ."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-12-25" ,"25 - නත්තල් දිනය","Holiday","දෙසැ."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-29" ,"29 - උඳුවප් පුර පසළොස්වක පෝය දිනය","Holiday","දෙසැ."));

        cal_month = GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new SLCalendar(this, cal_month,EventCollection.date_collection_arr);

        tv_month = findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));

        if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
            main.setBackgroundResource(R.drawable.january);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
            month_1.setText("ජන.");title_1.setText("15 - දෙමළ තෛපොංගල් දිනය");yellow_1.setVisibility(View.GONE);
            month_2.setText("ජන.");title_2.setText("20 - දුරුතු පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
            main.setBackgroundResource(R.drawable.february);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
            month_1.setText("පෙබ.");title_1.setText("04 - ජාතික නිදහස් දිනය");yellow_1.setVisibility(View.GONE);
            month_2.setText("පෙබ.");title_2.setText("19 - නවම් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
            main.setBackgroundResource(R.drawable.march);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
            month_1.setText("මාර්තු");title_1.setText("04 - මහා ශිව රාත්\u200Dරී දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
            month_2.setText("මාර්තු");title_2.setText("20 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
            main.setBackgroundResource(R.drawable.april);
            month_1.setText("අප්\u200Dරේල්");title_1.setText("13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);
            month_2.setText("අප්\u200Dරේල්");title_2.setText("14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය");yellow_2.setVisibility(View.GONE);
            month_3.setText("අප්\u200Dරේල්");title_3.setText("19 - බක් පුර පසළොස්වක පෝය දිනය");
            month_4.setText("අප්\u200Dරේල්");title_4.setText("19 - මහා සිකුරාදා දිනය");red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
            main.setBackgroundResource(R.drawable.may);
            month_1.setText("මැයි");title_1.setText("01 - ලෝක කම්කරු දිනය");yellow_1.setVisibility(View.GONE);
            month_2.setText("මැයි");title_2.setText("18 - වෙසක් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
            month_3.setText("මැයි");title_3.setText("19 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය");yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
            main.setBackgroundResource(R.drawable.june);
            month_1.setText("ජුනි");title_1.setText("05 - ඊද්-උල්-ෆීතර්(රාමසාන් දිනය)");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
            month_2.setText("ජුනි");title_2.setText("16 - පොසොන් පුර පසළොස්වක පෝය දිනය");
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
            main.setBackgroundResource(R.drawable.july);
            month_1.setText("ජුලි");title_1.setText("16 - ඇසළ පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
            main.setBackgroundResource(R.drawable.august);
            month_1.setText("අගෝ.");title_1.setText("12 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
            month_2.setText("අගෝ.");title_2.setText("14 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
            main.setBackgroundResource(R.drawable.september);
            month_1.setText("සැප්.");title_1.setText("13 - බිනර පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
            main.setBackgroundResource(R.drawable.october);
            month_1.setText("ඔක්.");title_1.setText("13 - වප් පුර පසළොස්වක පෝය දිනය");
            month_2.setText("ඔක්.");title_2.setText("27 - දීපවාලී උත්සව දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
            main.setBackgroundResource(R.drawable.november);
            month_1.setText("නොවැ.");title_1.setText("10 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)");yellow_1.setVisibility(View.GONE);
            month_2.setText("නොවැ.");title_2.setText("12 - ඉල් පුර පසළොස්වක පෝය දිනය");red_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
            main.setBackgroundResource(R.drawable.december);
            month_1.setText("දෙසැ.");title_1.setText("11 - උඳුවප් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);
            month_2.setText("දෙසැ.");title_2.setText("25 - නත්තල් දිනය");yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }


        else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
            main.setBackgroundResource(R.drawable.january);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
            month_1.setText("ජන.");title_1.setText("10 - දුරුතු පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);
            month_2.setText("ජන.");title_2.setText("15 - දෙමළ තෛපොංගල් දිනය");yellow_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
            main.setBackgroundResource(R.drawable.february);
            //month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
            month_1.setText("පෙබ.");title_1.setText("04 - ජාතික නිදහස් දිනය");yellow_1.setVisibility(View.GONE);
            month_2.setText("පෙබ.");title_2.setText("08 - නවම් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
            month_3.setText("පෙබ.");title_3.setText("21 - මහා ශිව රාත්\u200Dරී දිනය");red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
            main.setBackgroundResource(R.drawable.march);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
            month_1.setText("මාර්තු");title_1.setText("09 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            //month_2.setText("මාර්තු");title_2.setText("20 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
            main.setBackgroundResource(R.drawable.april);
            month_1.setText("අප්\u200Dරේල්");title_1.setText("07 - බක් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            month_2.setText("අප්\u200Dරේල්");title_2.setText("10 - මහා සිකුරාදා දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);
            month_3.setText("අප්\u200Dරේල්");title_3.setText("13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය");yellow_3.setVisibility(View.GONE);
            month_4.setText("අප්\u200Dරේල්");title_4.setText("14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය");red_4.setVisibility(View.VISIBLE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
            main.setBackgroundResource(R.drawable.may);
            month_1.setText("මැයි");title_1.setText("01 - ලෝක කම්කරු දිනය");yellow_1.setVisibility(View.GONE);
            month_2.setText("මැයි");title_2.setText("07 - වෙසක් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
            month_3.setText("මැයි");title_3.setText("08 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය");yellow_3.setVisibility(View.GONE);
            month_4.setText("මැයි");title_4.setText("24 - වඊද්-උල්-ෆීතර්(රාමසාන් දිනය)");yellow_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);
            //month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
            main.setBackgroundResource(R.drawable.june);
            month_1.setText("ජුනි");title_1.setText("05 - පොසොන් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            //month_2.setText("ජුනි");title_2.setText("16 - පොසොන් පුර පසළොස්වක පෝය දිනය");
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
            main.setBackgroundResource(R.drawable.july);
            month_1.setText("ජුලි");title_1.setText("04 - ඇසළ පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            month_2.setText("ජුලි");title_2.setText("31 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);
            //month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
            main.setBackgroundResource(R.drawable.august);
            month_1.setText("අගෝ.");title_1.setText("03 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            //month_2.setText("අගෝ.");title_2.setText("14 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
            main.setBackgroundResource(R.drawable.september);
            month_1.setText("සැප්.");title_1.setText("01 - බිනර පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
            month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
            main.setBackgroundResource(R.drawable.october);
            month_1.setText("ඔක්.");title_1.setText("01 - අදි වප් පුර පසළොස්වක පෝය දිනය");
            month_2.setText("ඔක්.");title_2.setText("29 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
            month_3.setText("ඔක්.");title_3.setText("30 - වප් පුර පසළොස්වක පෝය දිනය");yellow_3.setVisibility(View.VISIBLE);red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
            //month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
            main.setBackgroundResource(R.drawable.november);
            month_1.setText("නොවැ.");title_1.setText("14 - දීපවාලී උත්සව දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
            month_2.setText("නොවැ.");title_2.setText("29 - ඉල් පුර පසළොස්වක පෝය දිනය");red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
            main.setBackgroundResource(R.drawable.december);
            month_1.setText("දෙසැ.");title_1.setText("25 - නත්තල් දිනය");yellow_1.setVisibility(View.GONE);
            month_2.setText("දෙසැ.");title_2.setText("29 - උඳුවප් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
            month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
        }
        ImageButton previous = findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.err.println("Month : " + GregorianCalendar.MONTH);
                System.err.println("Month : " + Calendar.MONTH);
                setPreviousMonth();
                refreshCalendar();

                if (isBlue){
                    main.setBackgroundResource(R.drawable.blue_theme);
                }else if (isRed){
                    main.setBackgroundResource(R.drawable.red_theme);
                }else if (isGreen){
                    main.setBackgroundResource(R.drawable.green_theme);
                }else if (isPurple){
                    main.setBackgroundResource(R.drawable.purple_theme);
                }else if (isPink){
                    main.setBackgroundResource(R.drawable.rose_theme);
                }else if (isNormal){
                    if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("ජන.");title_1.setText("15 - දෙමළ තෛපොංගල් දිනය");yellow_1.setVisibility(View.GONE);
                        month_2.setText("ජන.");title_2.setText("20 - දුරුතු පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("පෙබ.");title_1.setText("04 - ජාතික නිදහස් දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);
                        month_2.setText("පෙබ.");title_2.setText("19 - නවම් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("මාර්තු");title_1.setText("04 - මහා ශිව රාත්\u200Dරී දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
                        month_2.setText("මාර්තු");title_2.setText("20 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.VISIBLE);green_4.setVisibility(View.VISIBLE);red_4.setVisibility(View.VISIBLE);yellow_4.setVisibility(View.VISIBLE);
                        month_1.setText("අප්\u200Dරේල්");title_1.setText("13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);
                        month_2.setText("අප්\u200Dරේල්");title_2.setText("14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය");yellow_2.setVisibility(View.GONE);
                        month_3.setText("අප්\u200Dරේල්");title_3.setText("19 - බක් පුර පසළොස්වක පෝය දිනය");yellow_3.setVisibility(View.VISIBLE);
                        month_4.setText("අප්\u200Dරේල්");title_4.setText("19 - මහා සිකුරාදා දිනය");red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);red_3.setVisibility(View.VISIBLE);
                        month_1.setText("මැයි");title_1.setText("01 - ලෝක කම්කරු දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);
                        month_2.setText("මැයි");title_2.setText("18 - වෙසක් පුර පසළොස්වක පෝය දිනය");
                        month_3.setText("මැයි");title_3.setText("19 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය");yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);
                        month_1.setText("ජුනි");title_1.setText("05 - ඊද්-උල්-ෆීතර්(රාමසාන් දිනය)");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
                        month_2.setText("ජුනි");title_2.setText("16 - පොසොන් පුර පසළොස්වක පෝය දිනය");
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("ජුලි");title_1.setText("16 - ඇසළ පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);
                        month_1.setText("අගෝ.");title_1.setText("12 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
                        month_2.setText("අගෝ.");title_2.setText("14 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("සැප්.");title_1.setText("13 - බිනර පුර පසළොස්වක පෝය දිනය");
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("ඔක්.");title_1.setText("13 - වප් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);
                        month_2.setText("ඔක්.");title_2.setText("27 - දීපවාලී උත්සව දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.november);
                        month_1.setText("නොවැ.");title_1.setText("10 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)");yellow_1.setVisibility(View.GONE);
                        month_2.setText("නොවැ.");title_2.setText("12 - ඉල් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("දෙසැ.");title_1.setText("11 - උඳුවප් පුර පසළොස්වක පෝය දිනය");
                        month_2.setText("දෙසැ.");title_2.setText("25 - නත්තල් දිනය");yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }
                    else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("ජන.");title_1.setText("10 - දුරුතු පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("ජන.");title_2.setText("15 - දෙමළ තෛපොංගල් දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        //month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("පෙබ.");title_1.setText("04 - ජාතික නිදහස් දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("පෙබ.");title_2.setText("08 - නවම් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("පෙබ.");title_3.setText("21 - මහා ශිව රාත්\u200Dරී දිනය");red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("මාර්තු");title_1.setText("09 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        //month_2.setText("මාර්තු");title_2.setText("20 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("අප්\u200Dරේල්");title_1.setText("07 - බක් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("අප්\u200Dරේල්");title_2.setText("10 - මහා සිකුරාදා දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setText("අප්\u200Dරේල්");title_3.setText("13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය");yellow_3.setVisibility(View.GONE);red_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);
                        month_4.setText("අප්\u200Dරේල්");title_4.setText("14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය");red_4.setVisibility(View.VISIBLE);yellow_4.setVisibility(View.GONE);blue_4.setVisibility(View.VISIBLE);green_4.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("මැයි");title_1.setText("01 - ලෝක කම්කරු දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("මැයි");title_2.setText("07 - වෙසක් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("මැයි");title_3.setText("08 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය");yellow_3.setVisibility(View.GONE);red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("මැයි");title_4.setText("24 - වඊද්-උල්-ෆීතර්(රාමසාන් දිනය)");yellow_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);red_4.setVisibility(View.VISIBLE);green_4.setVisibility(View.VISIBLE);
                        //month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("ජුනි");title_1.setText("05 - පොසොන් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        //month_2.setText("ජුනි");title_2.setText("16 - පොසොන් පුර පසළොස්වක පෝය දිනය");
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("ජුලි");title_1.setText("04 - ඇසළ පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("ජුලි");title_2.setText("31 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        //month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("අගෝ.");title_1.setText("03 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
                        //month_2.setText("අගෝ.");title_2.setText("14 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("සැප්.");title_1.setText("01 - බිනර පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("ඔක්.");title_1.setText("01 - අදි වප් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("ඔක්.");title_2.setText("29 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("ඔක්.");title_3.setText("30 - වප් පුර පසළොස්වක පෝය දිනය");yellow_3.setVisibility(View.VISIBLE);red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                        //month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.november);
                        month_1.setText("නොවැ.");title_1.setText("14 - දීපවාලී උත්සව දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("නොවැ.");title_2.setText("29 - ඉල් පුර පසළොස්වක පෝය දිනය");red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("දෙසැ.");title_1.setText("25 - නත්තල් දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("දෙසැ.");title_2.setText("29 - උඳුවප් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else {
                        if (android.text.format.DateFormat.format("MMMM", cal_month).equals("January")){
                            main.setBackgroundResource(R.drawable.january);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("February")){
                            main.setBackgroundResource(R.drawable.february);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("March")){
                            main.setBackgroundResource(R.drawable.march);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("April")){
                            main.setBackgroundResource(R.drawable.april);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("May")){
                            main.setBackgroundResource(R.drawable.may);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("June")){
                            main.setBackgroundResource(R.drawable.june);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("July")){
                            main.setBackgroundResource(R.drawable.july);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("August")){
                            main.setBackgroundResource(R.drawable.august);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("September")){
                            main.setBackgroundResource(R.drawable.september);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("October")){
                            main.setBackgroundResource(R.drawable.october);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("November")){
                            main.setBackgroundResource(R.drawable.november);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("December")){
                            main.setBackgroundResource(R.drawable.december);
                        }
                        holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);

                    }
                }
            }
        });
        ImageButton next = findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (cal_month.get(GregorianCalendar.MONTH) == Calendar.DECEMBER && cal_month.get(GregorianCalendar.YEAR)==2019) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(MainActivity.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }*/
                setNextMonth();
                refreshCalendar();

                if (isBlue){
                    main.setBackgroundResource(R.drawable.blue_theme);
                }else if (isRed){
                    main.setBackgroundResource(R.drawable.red_theme);
                }else if (isGreen){
                    main.setBackgroundResource(R.drawable.green_theme);
                }else if (isPurple){
                    main.setBackgroundResource(R.drawable.purple_theme);
                }else if (isPink){
                    main.setBackgroundResource(R.drawable.rose_theme);
                }else if (isNormal){
                    if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("ජන.");title_1.setText("15 - දෙමළ තෛපොංගල් දිනය");yellow_1.setVisibility(View.GONE);
                        month_2.setText("ජන.");title_2.setText("20 - දුරුතු පුර පසළොස්වක පෝය දිනය");
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("පෙබ.");title_1.setText("04 - ජාතික නිදහස් දිනය");
                        month_2.setText("පෙබ.");title_2.setText("19 - නවම් පුර පසළොස්වක පෝය දිනය");
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("මාර්තු");title_1.setText("04 - මහා ශිව රාත්\u200Dරී දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
                        month_2.setText("මාර්තු");title_2.setText("20 - මැදින් පුර පසළොස්වක පෝය දිනය");
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);red_3.setVisibility(View.VISIBLE);yellow_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.VISIBLE);green_4.setVisibility(View.VISIBLE);
                        month_1.setText("අප්\u200Dරේල්");title_1.setText("13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය");red_1.setVisibility(View.VISIBLE);
                        month_2.setText("අප්\u200Dරේල්");title_2.setText("14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය");yellow_2.setVisibility(View.GONE);
                        month_3.setText("අප්\u200Dරේල්");title_3.setText("19 - බක් පුර පසළොස්වක පෝය දිනය");
                        month_4.setText("අප්\u200Dරේල්");title_4.setText("19 - මහා සිකුරාදා දිනය");red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("මැයි");title_1.setText("01 - ලෝක කම්කරු දිනය");
                        month_2.setText("මැයි");title_2.setText("18 - වෙසක් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                        month_3.setText("මැයි");title_3.setText("19 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය");yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("ජුනි");title_1.setText("05 - ඊද්-උල්-ෆීතර්(රාමසාන් දිනය)");red_1.setVisibility(View.GONE);
                        month_2.setText("ජුනි");title_2.setText("16 - පොසොන් පුර පසළොස්වක පෝය දිනය");
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("ජුලි");title_1.setText("16 - ඇසළ පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);
                        month_1.setText("අගෝ.");title_1.setText("12 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);
                        month_2.setText("අගෝ.");title_2.setText("14 - නිකිණි පුර පසළොස්වක පෝය දිනය");
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("සැප්.");title_1.setText("13 - බිනර පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_1.setText("ඔක්.");title_1.setText("13 - වප් පුර පසළොස්වක පෝය දිනය");
                        month_2.setText("ඔක්.");title_2.setText("27 - දීපවාලී උත්සව දිනය");
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.november);
                        month_1.setText("නොවැ.");title_1.setText("10 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)");yellow_1.setVisibility(View.GONE);
                        month_2.setText("නොවැ.");title_2.setText("12 - ඉල් පුර පසළොස්වක පෝය දිනය");red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    } else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("දෙසැ.");title_1.setText("11 - උඳුවප් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);
                        month_2.setText("දෙසැ.");title_2.setText("25 - නත්තල් දිනය");yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }
                    else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("ජන.");title_1.setText("10 - දුරුතු පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setText("ජන.");title_2.setText("15 - දෙමළ තෛපොංගල් දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
                        main.setBackgroundResource(R.drawable.february);
                        //month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("පෙබ.");title_1.setText("04 - ජාතික නිදහස් දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setText("පෙබ.");title_2.setText("08 - නවම් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("පෙබ.");title_3.setText("21 - මහා ශිව රාත්\u200Dරී දිනය");red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
                        main.setBackgroundResource(R.drawable.march);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                        month_1.setText("මාර්තු");title_1.setText("09 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        //month_2.setText("මාර්තු");title_2.setText("20 - මැදින් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("අප්\u200Dරේල්");title_1.setText("07 - බක් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("අප්\u200Dරේල්");title_2.setText("10 - මහා සිකුරාදා දිනය");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("අප්\u200Dරේල්");title_3.setText("13 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනයට පෙර දිනය");yellow_3.setVisibility(View.GONE);red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                        month_4.setVisibility(View.VISIBLE);title_4.setVisibility(View.VISIBLE);month_4.setText("අප්\u200Dරේල්");title_4.setText("14 - සිංහල හා දෙමළ අලුත් අවුරුදු දිනය");red_4.setVisibility(View.VISIBLE);yellow_4.setVisibility(View.GONE);green_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.VISIBLE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("මැයි");title_1.setText("01 - ලෝක කම්කරු දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setText("මැයි");title_2.setText("07 - වෙසක් පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setText("මැයි");title_3.setText("08 - වෙසක් පුර පසළොස්වක පෝය දිනයට පසු දිනය");yellow_3.setVisibility(View.GONE);red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                        month_4.setText("මැයි");title_4.setText("24 - වඊද්-උල්-ෆීතර්(රාමසාන් දිනය)");yellow_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);green_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.VISIBLE);
                        //month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("ජුනි");title_1.setText("05 - පොසොන් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        //month_2.setText("ජුනි");title_2.setText("16 - පොසොන් පුර පසළොස්වක පෝය දිනය");
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("ජුලි");title_1.setText("04 - ඇසළ පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("ජුලි");title_2.setText("31 - ඊද්-උල්-අල්හා (හජ්ජි දිනය)");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);green_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);
                        //month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("අගෝ.");title_1.setText("03 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);
                        //month_2.setText("අගෝ.");title_2.setText("14 - නිකිණි පුර පසළොස්වක පෝය දිනය");yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);red_2.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("සැප්.");title_1.setText("01 - බිනර පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.GONE);title_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);green_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);yellow_2.setVisibility(View.GONE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("ඔක්.");title_1.setText("01 - අදි වප් පුර පසළොස්වක පෝය දිනය");yellow_1.setVisibility(View.VISIBLE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setVisibility(View.VISIBLE);title_2.setVisibility(View.VISIBLE);month_2.setText("ඔක්.");title_2.setText("29 - මිලාද්-උන්-නබී(නබී නායකතුමාගේ උපන් දිනය)");yellow_2.setVisibility(View.GONE);red_2.setVisibility(View.GONE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.VISIBLE);title_3.setVisibility(View.VISIBLE);month_3.setText("ඔක්.");title_3.setText("30 - වප් පුර පසළොස්වක පෝය දිනය");yellow_3.setVisibility(View.VISIBLE);red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.VISIBLE);green_3.setVisibility(View.VISIBLE);
                        //month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
                        main.setBackgroundResource(R.drawable.november);
                        month_1.setText("නොවැ.");title_1.setText("14 - දීපවාලී උත්සව දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.GONE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("නොවැ.");title_2.setText("29 - ඉල් පුර පසළොස්වක පෝය දිනය");red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("දෙසැ.");title_1.setText("25 - නත්තල් දිනය");yellow_1.setVisibility(View.GONE);red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.VISIBLE);green_1.setVisibility(View.VISIBLE);
                        month_2.setText("දෙසැ.");title_2.setText("29 - උඳුවප් පුර පසළොස්වක පෝය දිනය");red_2.setVisibility(View.VISIBLE);yellow_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.VISIBLE);green_2.setVisibility(View.VISIBLE);
                        month_3.setVisibility(View.GONE);title_3.setVisibility(View.GONE);blue_3.setVisibility(View.GONE);green_3.setVisibility(View.GONE);red_3.setVisibility(View.GONE);yellow_3.setVisibility(View.GONE);
                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);green_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);yellow_4.setVisibility(View.GONE);
                    }else {
                        holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);
                        if (android.text.format.DateFormat.format("MMMM", cal_month).equals("January")){
                            main.setBackgroundResource(R.drawable.january);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("February")){
                            main.setBackgroundResource(R.drawable.february);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("March")){
                            main.setBackgroundResource(R.drawable.march);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("April")){
                            main.setBackgroundResource(R.drawable.april);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("May")){
                            main.setBackgroundResource(R.drawable.may);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("June")){
                            main.setBackgroundResource(R.drawable.june);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("July")){
                            main.setBackgroundResource(R.drawable.july);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("August")){
                            main.setBackgroundResource(R.drawable.august);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("September")){
                            main.setBackgroundResource(R.drawable.september);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("October")){
                            main.setBackgroundResource(R.drawable.october);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("November")){
                            main.setBackgroundResource(R.drawable.november);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("December")){
                            main.setBackgroundResource(R.drawable.december);
                        }
                    }
                }
            }
        });
        GridView gridview = findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = SLCalendar.day_string.get(position);
                ((SLCalendar) parent.getAdapter()).getPositionList(selectedGridDate, MainActivity.this);
            }

        });

        initAds();
    }

    // ads
    private void initAds() {
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(Calendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    @SuppressLint("SetTextI18n")
    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void popupWindow(){
        final Dialog dialogs = new Dialog(MainActivity.this);
        dialogs.setContentView(R.layout.theme_popup);
        TextView imgCross = dialogs.findViewById(R.id.close);

        blue = dialogs.findViewById(R.id.blue_ray);
        blue.setOnCheckedChangeListener(this);

        red = dialogs.findViewById(R.id.red_ray);
        red.setOnCheckedChangeListener(this);

        green = dialogs.findViewById(R.id.green_ray);
        green.setOnCheckedChangeListener(this);

        purple = dialogs.findViewById(R.id.purple_ray);
        purple.setOnCheckedChangeListener(this);

        pink = dialogs.findViewById(R.id.pink_ray);
        pink.setOnCheckedChangeListener(this);

        default_color = dialogs.findViewById(R.id.default_ray);
        default_color.setOnCheckedChangeListener(this);

        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogs.dismiss();
            }
        });
        dialogs.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.power) {
            logout();
            return true;
        }
        if (id == R.id.theme){
            //open_popup_window();
            popupWindow();
        }
        if (id == R.id.reminder){
            Intent intent = new Intent(MainActivity.this, RemindTaskActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_holiday){
            Intent intent = new Intent(MainActivity.this, AllHolidayActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.rahu){
            Intent intent = new Intent(MainActivity.this, RahuTimeActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.awurudu_charithra){
            Intent intent = new Intent(MainActivity.this, AwuruduCharitraActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        System.exit(0);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getId() == R.id.blue_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = true;isRed = false;isGreen = false;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.blue_theme);
            }
            if (buttonView.getId() == R.id.red_ray) {
                blue.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = true;isGreen = false;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.red_theme);
            }
            if (buttonView.getId() == R.id.green_ray) {
                red.setChecked(false);
                blue.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = true;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.green_theme);
            }
            if (buttonView.getId() == R.id.purple_ray) {
                red.setChecked(false);
                green.setChecked(false);
                blue.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = true;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.purple_theme);
            }
            if (buttonView.getId() == R.id.pink_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                blue.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = false;isPink = true;isNormal = false;
                main.setBackgroundResource(R.drawable.rose_theme);
            }
            if (buttonView.getId() == R.id.default_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                blue.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = false;isPink = false;isNormal = true;

                if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                    main.setBackgroundResource(R.drawable.january);
                    //theme_layout.setBackgroundResource(R.drawable.january);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                    main.setBackgroundResource(R.drawable.february);
                    //theme_layout.setBackgroundResource(R.drawable.february);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                    main.setBackgroundResource(R.drawable.march);
                    //theme_layout.setBackgroundResource(R.drawable.march);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                    main.setBackgroundResource(R.drawable.april);
                    //theme_layout.setBackgroundResource(R.drawable.april);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                    main.setBackgroundResource(R.drawable.may);
                    //theme_layout.setBackgroundResource(R.drawable.may);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                    main.setBackgroundResource(R.drawable.june);
                    //theme_layout.setBackgroundResource(R.drawable.june);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                    main.setBackgroundResource(R.drawable.july);
                    //theme_layout.setBackgroundResource(R.drawable.july);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                    main.setBackgroundResource(R.drawable.august);
                    //theme_layout.setBackgroundResource(R.drawable.august);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                    main.setBackgroundResource(R.drawable.september);
                    //theme_layout.setBackgroundResource(R.drawable.september);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                    main.setBackgroundResource(R.drawable.october);
                    //theme_layout.setBackgroundResource(R.drawable.october);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                    main.setBackgroundResource(R.drawable.november);
                    //theme_layout.setBackgroundResource(R.drawable.november);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                    main.setBackgroundResource(R.drawable.december);
                    //theme_layout.setBackgroundResource(R.drawable.december);
                }
            }
        }
    }
}
