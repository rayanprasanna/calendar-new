package com.universl.ryan.calendar.sub_activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.universl.ryan.calendar.MainActivity;
import com.universl.ryan.calendar.R;
import com.universl.ryan.calendar.data.AlarmReminderContract;

import java.util.Objects;

public class RemindTaskActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor>, CompoundButton.OnCheckedChangeListener{
    RelativeLayout main;
    RadioButton blue,red,green,purple,pink,default_color;
    Boolean isBlue = false,isRed = false,isGreen = false,isPurple = false,isPink = false,isNormal = true;
    FloatingActionButton mAddReminderButton;
    AlarmCursorAdapter mCursorAdapter;
    ListView reminderListView;

    private static final int VEHICLE_LOADER = 0;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind_task);

        main = findViewById(R.id.main);
        Toolbar toolbar = findViewById(R.id.search_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>සිහිකැඳ වීම්</font>"));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);


        reminderListView = findViewById(R.id.remind_list);
        View emptyView = findViewById(R.id.empty_view);
        reminderListView.setEmptyView(emptyView);

        mCursorAdapter = new AlarmCursorAdapter(this, null);
        reminderListView.setAdapter(mCursorAdapter);

        reminderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(RemindTaskActivity.this, AddReminderActivity.class);

                Uri currentVehicleUri = ContentUris.withAppendedId(AlarmReminderContract.AlarmReminderEntry.CONTENT_URI, id);

                // Set the URI on the data field of the intent
                intent.setData(currentVehicleUri);

                startActivity(intent);

            }
        });


        mAddReminderButton = findViewById(R.id.fab);

        mAddReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddReminderActivity.class);
                startActivity(intent);
            }
        });

        getLoaderManager().initLoader(VEHICLE_LOADER, null, this);


    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                AlarmReminderContract.AlarmReminderEntry._ID,
                AlarmReminderContract.AlarmReminderEntry.KEY_TITLE,
                AlarmReminderContract.AlarmReminderEntry.KEY_DATE,
                AlarmReminderContract.AlarmReminderEntry.KEY_TIME,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_NO,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_TYPE,
                AlarmReminderContract.AlarmReminderEntry.KEY_ACTIVE

        };

        return new CursorLoader(this,   // Parent activity context
                AlarmReminderContract.AlarmReminderEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mCursorAdapter.swapCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void popupWindow(){
        final Dialog dialogs = new Dialog(RemindTaskActivity.this);
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
            Intent intent = new Intent(RemindTaskActivity.this, MainActivity.class);
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
            Intent intent = new Intent(RemindTaskActivity.this, RemindTaskActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_holiday){
            Intent intent = new Intent(RemindTaskActivity.this, AllHolidayActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.rahu){
            Intent intent = new Intent(RemindTaskActivity.this, RahuTimeActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.awurudu_charithra){
            Intent intent = new Intent(RemindTaskActivity.this, AwuruduCharitraActivity.class);
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
        Intent intent = new Intent(RemindTaskActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
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
                main.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
    }
}
