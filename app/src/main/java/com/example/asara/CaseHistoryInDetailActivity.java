package com.example.asara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class CaseHistoryInDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_history_in_detail);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ViewSwitcher viewSwitcher = findViewById(R.id.viewSwitcher);
        TextView submitButton = findViewById(R.id.submitButton);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog;
                progressDialog = new ProgressDialog(CaseHistoryInDetailActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                // Create a Handler to post a delayed task to dismiss the ProgressDialog after 2 seconds
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                            viewSwitcher.showNext();
                            ratingBar.setIsIndicator(true);
                        }
                    }
                }, 1000);
            }
        });


    }
}