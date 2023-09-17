package com.example.asara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ReportedCasesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reported_cases_list);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout  = findViewById(R.id.tab_layout);

        viewPager.setAdapter(new FragmentAdaptor(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}