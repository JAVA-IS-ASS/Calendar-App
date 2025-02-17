package com.example.calender_app;

import android.os.Bundle;

import android.view.View;

import android.widget.CalendarView;

import android.widget.EditText;

import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;



import java.util.Date;

import java.util.HashMap;



public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;

    private EditText reminderEditText;

    private HashMap<Long, String> remindersMap;






    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        calendarView = findViewById(R.id.calendarView);

        reminderEditText = findViewById(R.id.reminderEditText);

        remindersMap = new HashMap<>();



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // Note: month is zero-based (0 for January, 11 for December)

                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;

                Toast.makeText(MainActivity.this, "Selected date: " + selectedDate, Toast.LENGTH_SHORT).show();

            }

        });

    }



    public void addReminder(View view) {

        String reminder = reminderEditText.getText().toString().trim();

        long selectedDate = calendarView.getDate();



        if (reminder.isEmpty()) {

            Toast.makeText(MainActivity.this, "Please enter a reminder", Toast.LENGTH_SHORT).show();

            return;

        }



        remindersMap.put(selectedDate, reminder);

        Toast.makeText(MainActivity.this, "Reminder added for selected date", Toast.LENGTH_SHORT).show();

    }



    public void viewReminders(View view) {

        long selectedDate = calendarView.getDate();

        String reminder = remindersMap.get(selectedDate);



        if (reminder != null) {

            Toast.makeText(MainActivity.this, "Reminder: " + reminder, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(MainActivity.this, "No reminder found for selected date", Toast.LENGTH_SHORT).show();

        }

    }

}


