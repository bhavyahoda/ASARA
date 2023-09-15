package com.example.asara;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class CaseHistoryInternalActivity extends AppCompatActivity {
    private CreateLoadLocalData createLoadLocalData;
    private ListView animalListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_history_internal);

        createLoadLocalData = new CreateLoadLocalData(this);
        animalListView = findViewById(R.id.animalListView);

        // Read data from the Animal table
        Cursor cursor = createLoadLocalData.readAnimalData();

        // Check if data is available
        if (cursor != null && cursor.getCount() > 0) {
            String[] columns = cursor.getColumnNames();
            int[] columnIndices = new int[columns.length];
            for (int i = 0; i < columns.length; i++) {
                columnIndices[i] = cursor.getColumnIndex(columns[i]);
            }

            // Create an array adapter to display data in a ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            animalListView.setAdapter(adapter);

            // Iterate through the cursor and display data
            while (cursor.moveToNext()) {
                StringBuilder rowData = new StringBuilder();
                for (int i = 0; i < columnIndices.length; i++) {
                    String columnName = columns[i];
                    String columnValue = cursor.getString(columnIndices[i]);
                    rowData.append(columnName).append(": ").append(columnValue).append("\n");
                }
                adapter.add(rowData.toString());
            }

            // Close the cursor when done
            cursor.close();
        } else {
            // Handle case where no data is available
        }
    }
}
