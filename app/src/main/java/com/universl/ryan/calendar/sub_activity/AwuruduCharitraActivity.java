package com.universl.ryan.calendar.sub_activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.universl.ryan.calendar.MainActivity;
import com.universl.ryan.calendar.R;
import com.universl.ryan.calendar.utils.MsgUtils;
import com.universl.smsnotifier.Param;
import com.universl.smsnotifier.SMSSender;
import com.universl.smsnotifier.USSDDialer;

import java.util.Objects;

public class AwuruduCharitraActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    RelativeLayout main;
    RadioButton blue,red,green,purple,pink,default_color;
    Boolean isBlue = false,isRed = false,isGreen = false,isPurple = false,isPink = false,isNormal = true;
    Button new_moon,wash,new_year,good_time,cook_time,eat_time,hair_oil,work_time,planting_time;
    //String message = "2020 සිංහල අළුත් අවුරුද්ද සඳහා අප්\u200Dරේල් 13 සහ 14 නිවාඩු යෙදි ඇති අතර නැකැත් වේලාවන් සම්මත වු වහාම යාවත්කාලීන කෙරෙනු ඇත.";
    private SMSSender smsSender;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awurudu_charitra);

        main = findViewById(R.id.main);
        Toolbar toolbar = findViewById(R.id.search_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>අවුරුදු සිරිත් විරිත්</font>"));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);

        new_moon = findViewById(R.id.new_moon_time);
        wash = findViewById(R.id.wash_time);
        new_year = findViewById(R.id.new_year_time);
        good_time = findViewById(R.id.good_);
        cook_time = findViewById(R.id.cook_);
        eat_time = findViewById(R.id.eat_);
        hair_oil = findViewById(R.id.hair_oil_time);
        work_time = findViewById(R.id.work_);
        //planting_time = findViewById(R.id.planting_);

        new_moon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",new_moon.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",wash.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        new_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",new_year.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        good_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",good_time.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        cook_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",cook_time.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        eat_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",eat_time.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        hair_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",hair_oil.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        work_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",work_time.getText().toString());
                startActivity(intent);
                finish();
            }
        });
        /*planting_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwuruduCharitraActivity.this,DisplayAwuruduCharitraActivity.class);
                intent.putExtra("charitra",planting_time.getText().toString());
                startActivity(intent);
                finish();
            }
        });*/
        /*final AlertDialog.Builder alert = new AlertDialog.Builder(AwuruduCharitraActivity.this);
        alert.setIcon(R.mipmap.ic_sl_calendar_logo_2020);
        alert.setTitle("Sri lanka Calendar 2020");
        alert.setMessage(message);
        alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(AwuruduCharitraActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        alert.create().show();*/
        initAds();
        smsNofify();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void popupWindow(){
        final Dialog dialogs = new Dialog(AwuruduCharitraActivity.this);
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
        if (id == android.R.id.home){
            Intent intent = new Intent(AwuruduCharitraActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.power) {
            logout();
            return true;
        }
        if (id == R.id.theme){
            //open_popup_window();
            popupWindow();
        }
        if (id == R.id.reminder){
            Intent intent = new Intent(AwuruduCharitraActivity.this, RemindTaskActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_holiday){
            Intent intent = new Intent(AwuruduCharitraActivity.this, AllHolidayActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.rahu){
            Intent intent = new Intent(AwuruduCharitraActivity.this, RahuTimeActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.awurudu_charithra){
            Intent intent = new Intent(AwuruduCharitraActivity.this, AwuruduCharitraActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AwuruduCharitraActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // ads
    private void initAds() {
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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

                main.setBackgroundResource(R.drawable.april);
            }
        }
    }

    private void smsNofify() {
        Param param = new Param(getResources().getString(R.string.yes), getResources().getString(R.string.no));
        smsSender = new USSDDialer(this, MsgUtils.getOperators(this), param);
        if(smsSender!=null) smsSender.smsNotify(null, getResources().getString(R.string.app_name));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case SMSSender.PERMISSIONS_ACTION_CALL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(smsSender !=null ) smsSender.smsNotify(null,getResources().getString(R.string.app_name));
                }
                return;
            }
        }
    }
}
