package com.example.asara;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ResolvedCasesFragment extends Fragment {

    public ResolvedCasesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resolved_cases, container, false);
        CardView caseID1333 = view.findViewById(R.id.caseID1333);

        caseID1333.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaseHistoryInDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}