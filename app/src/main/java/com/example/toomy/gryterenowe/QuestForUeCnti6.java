package com.example.toomy.gryterenowe;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestForUeCnti6 extends Fragment {


    public QuestForUeCnti6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_quest_for_ue_cnti6, container, false);
        Button QuestForUeBtn = (Button) v.findViewById(R.id.dalejcnti6);
        Button WrongAnswer = (Button) v.findViewById(R.id.wrong_answer);
        final TextView MistakeInformation =  (TextView) v.findViewById(R.id.mistake_information);
        setTimer(v);
        QuestForUeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestForUeCnti7 questForUe = new QuestForUeCnti7();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.flcontent,questForUe,questForUe.getTag()).commit();

            }
        });
        WrongAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long wrongAnwerCost = 50000000;

                MistakeInformation.setText("Błąd +5 sekund.");
                MistakeInformation.setTextColor(Color.RED);
            }
        });
        return v;
    }
    private void setTimer(View v){
        TextView timer = (TextView) v.findViewById(R.id.timer);
        GameTimer.getInstance().setTimerToTextViewOnContinue(timer);
    }


}
