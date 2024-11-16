package com.example.new_year;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    Switch aswitch;
    TextView Status,About,Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.items);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity2.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<Item> items = new ArrayList<>();

        aswitch = findViewById(R.id.click);
        Info =findViewById(R.id.info);
        Status = findViewById(R.id.status);
        Status.setText("නව නැකැත් සඳහා");
        Info.setText(R.string.info1);
        loadoldItems();


        About = findViewById(R.id.about);
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Status.setText("පෙර නැකැත් සඳහා");
                    Info.setText(R.string.info2);
                    loadnewItems();
                } else {
                    Status.setText("නව නැකැත් සඳහා");
                    Info.setText(R.string.info1);
                    loadoldItems();
                }
            }
        });
    }

    private void loadoldItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("නව සද බැලීම.", R.drawable.nawa_sada, R.string.Old_data1, getMillisUntilTarget(2025,04,11,18,30,00)));
        items.add(new Item("පරණ අවුරුද්ද සදහා ස්නානය.", R.drawable.nema, R.string.Old_data2, getMillisUntilTarget(2025,04,11,10,30,0)));
        items.add(new Item("අලුත් අවුරුදු උදාව.", R.drawable.awurudu_udawa, R.string.Old_data3, getMillisUntilTarget(2025,04,13,21,05,0)));
        items.add(new Item("පුණ්\u200Dය කාලය.", R.drawable.punya_kalaya, R.string.Old_data4, getMillisUntilTarget(2025,04,13,20,57,0)));
        items.add(new Item("ආහාර පිසීම.", R.drawable.kiri_ithirima, R.string.Old_data5, getMillisUntilTarget(2025,04,13,23,06,0)));
        items.add(new Item("වැඩ ඇල්ලීම ගනුදෙනු කිරීම හා ආහාර අනුභවය.", R.drawable.ganudenu, R.string.Old_data6, getMillisUntilTarget(2025,04,14,00,06,0)));
        items.add(new Item("හිස තෙල් ගෑම.", R.drawable.histhel, R.string.Old_data7, getMillisUntilTarget(2025,04,15,10,17,0)));
        items.add(new Item("රැකියා සඳහා පිටත්ව යෑම.", R.drawable.rakee_raksh, R.string.Old_data8, getMillisUntilTarget(2025,04,17,06,52,0)));
        items.add(new Item("පැළ සිටුවීම.", R.drawable.pela_situwima, R.string.Old_data9, getMillisUntilTarget(2025,04,18,10,16,0)));

        adapter = new MyAdapter(MainActivity2.this, items);
        recyclerView.setAdapter(adapter);
    }

    private void loadnewItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("නව සද බැලීම.", R.drawable.nawa_sada, R.string.New_data1, getMillisUntilTarget(2024,04,11,18,30,00)));
        items.add(new Item("පරණ අවුරුද්ද සදහා ස්නානය.", R.drawable.nema, R.string.New_data2, getMillisUntilTarget(2024,04,11,10,30,0)));
        items.add(new Item("අලුත් අවුරුදු උදාව.", R.drawable.awurudu_udawa, R.string.New_data3, getMillisUntilTarget(2024,04,13,21,05,0)));
        items.add(new Item("පුණ්\u200Dය කාලය.", R.drawable.punya_kalaya, R.string.New_data4, getMillisUntilTarget(2024,04,13,14,41,0)));
        items.add(new Item("ආහාර පිසීම.", R.drawable.kiri_ithirima, R.string.New_data5, getMillisUntilTarget(2024,04,14,06,17,0)));
        items.add(new Item("වැඩ ඇල්ලීම ගනුදෙනු කිරීම හා ආහාර අනුභවය.", R.drawable.ganudenu, R.string.New_data6, getMillisUntilTarget(2024,04,14,07,07,0)));
        items.add(new Item("හිස තෙල් ගෑම.", R.drawable.histhel, R.string.New_data7, getMillisUntilTarget(2024,04,15,10,17,0)));
        items.add(new Item("රැකියා සඳහා පිටත්ව යෑම.", R.drawable.rakee_raksh, R.string.New_data8, getMillisUntilTarget(2024,04,17,06,52,0)));

        adapter = new MyAdapter(MainActivity2.this,items);
        recyclerView.setAdapter(adapter);
    }

    private long getMillisUntilTarget(int year, int month, int day, int hour, int minute, int second) {
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.set(year, month-1, day, hour, minute, second);
        long targetTimeMillis = targetCalendar.getTimeInMillis();
        return targetTimeMillis;
    }
}
