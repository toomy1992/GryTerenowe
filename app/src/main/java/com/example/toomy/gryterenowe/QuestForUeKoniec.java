package com.example.toomy.gryterenowe;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestForUeKoniec extends Fragment {

    SharedPref sharedPref;

    public QuestForUeKoniec() {
        // Required empty public constructor
    }

    TextView myTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quest_for_ue_koniec, container, false);
        myTextView = (TextView) v.findViewById(R.id.czas) ;
        myTextView.setText(GameTimer.getInstance().getTime());
        sharedPref = new SharedPref(getContext());
        sharedPref.setHighScore(GameTimer.getInstance().getTime());
        return v;
    }
}
