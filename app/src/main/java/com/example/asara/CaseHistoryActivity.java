package com.example.asara;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CaseHistoryActivity extends AppCompatActivity {

    private TextView userDetailsTextView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_history);

        userDetailsTextView = findViewById(R.id.userDetailsTextView);
        databaseHelper = new DatabaseHelper(this);

        // Execute the database operation asynchronously
        new RetrieveDataTask().execute();
    }

    private class RetrieveDataTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... voids) {
            // Perform database operations in the background
            return databaseHelper.retrieveDataFromTable("asara");
        }

        @Override
        protected void onPostExecute(List<String> dataList) {
            // Update the UI with the retrieved data
            userDetailsTextView.setText(TextUtils.join("\n", dataList));
        }
    }
}

