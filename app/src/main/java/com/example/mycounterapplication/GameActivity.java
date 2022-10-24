package com.example.mycounterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycounterapplication.model.CounterThread;

public class GameActivity extends AppCompatActivity {
    private TextView mInstructionTextView;
    private TextView mScoreTextView;
    private TextView mScoreAutomatiqueTextView;
    private TextView mTimeTextView;
    private Button mUpScoreButton;
    CounterThread mCounterThread = new CounterThread(143);
    long startTime = 0;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            mTimeTextView.setText(String.format("%d:%02d", minutes, seconds));
            mScoreAutomatiqueTextView.setText(String.valueOf(mCounterThread.counter));
            timerHandler.postDelayed(this, 500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mInstructionTextView = findViewById(R.id.game_textview_instruction);
        mScoreTextView = findViewById(R.id.game_textview_score);
        mScoreAutomatiqueTextView = findViewById(R.id.game_textview_score_automatique);
        mTimeTextView = findViewById(R.id.game_textview_time);
        mUpScoreButton = findViewById(R.id.game_button_up_score);
        mCounterThread.start();
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
        mUpScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mUser.setmFirstName("Vincent ");
                //String firstName = mNameEditText.getText().toString();
                //mUser.setmFirstName(firstName);

                //saveUserNameInPreferenceFile(firstName);
                String currentScore = mScoreTextView.getText().toString();
                int currentScoreToIncrement = Integer.parseInt(currentScore);
                currentScoreToIncrement++;
                String newScore = String.valueOf(currentScoreToIncrement);
                mScoreTextView.setText(newScore);
            }
        });

    }
}