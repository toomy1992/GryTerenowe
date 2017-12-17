package com.example.toomy.gryterenowe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestForUeC1 extends Fragment {


    public QuestForUeC1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quest_for_ue_c1, container, false);
        Button QuestForUeBtn = (Button) v.findViewById(R.id.dalejc2);
        QuestForUeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestForUeC2 questForUe = new QuestForUeC2();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.flcontent, questForUe, questForUe.getTag()).commit();

            }
        });
        return v;
    }

}
