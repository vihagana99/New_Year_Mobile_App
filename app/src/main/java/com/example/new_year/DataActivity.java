
package com.example.new_year;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    TextView dataname, dataofdata, data, Day, Hour, Minute, Second;
    ImageView dataimageview;
    Button button;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        dataname = findViewById(R.id.name);
        dataofdata = findViewById(R.id.data);
        dataimageview = findViewById(R.id.imageview);
        Day = findViewById(R.id.day);
        Hour = findViewById(R.id.hour);
        Minute = findViewById(R.id.minute);
        Second = findViewById(R.id.second);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            dataimageview.setImageResource(bundle.getInt("imageview"));
            dataname.setText(bundle.getString("name"));
            dataofdata.setText(getString(bundle.getInt("data"))); // Correctly retrieve string resource
            long countdown = bundle.getLong("countdown");
            startCountdown(countdown); // countdown methord callig
        }

        //back button
        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish(); // Just finish the activity to go back
            }
        });
    }

    private void startCountdown(long targetTimeMillis) {

        long currentTimeMillis = System.currentTimeMillis();
        long millisUntilFinished = targetTimeMillis - currentTimeMillis;

        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateCountdownText(millisUntilFinished );
            }

            @Override
            public void onFinish() {
                updateCountdownText(0);
            }
        };
        countDownTimer.start();
    }

    private void updateCountdownText( long millisUntilFinished ) {

        if (millisUntilFinished <= 0) {
            Day.setText("00");
            Hour.setText("00");
            Minute.setText("00");
            Second.setText("00");


        } else {
            long days = millisUntilFinished / (1000 * 60 * 60 * 24);
            long hours = (millisUntilFinished % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (millisUntilFinished % (1000 * 60 * 60)) / (1000 * 60);
            long seconds = (millisUntilFinished % (1000 * 60)) / 1000;

            String day = String.format(" %02d", days);
            Day.setText(day);

            String hour = String.format(" %02d", hours);
            Hour.setText(hour);

            String minute = String.format(" %02d", minutes);
            Minute.setText(minute);

            String second = String.format(" %02d", seconds);
            Second.setText(second);
        }
    }



}