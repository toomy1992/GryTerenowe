package com.example.toomy.gryterenowe;


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
public class QuestForUeA2 extends Fragment {
    private TextView errorText;
    SharedPref sharedPref;
    public QuestForUeA2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_quest_for_ue_a2, container, false);
        Button QuestForUeBtn = (Button) v.findViewById(R.id.daleja3);
        Button Blad = (Button) v.findViewById(R.id.blad);
        errorText = (TextView) v.findViewById(R.id.error_text) ;
        setTimer(v);
        QuestForUeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestForUeA3 questForUe = new QuestForUeA3();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.flcontent,questForUe,questForUe.getTag()).commit();

            }
        });
        Blad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorText.setText("+5 sec");
                sharedPref = new SharedPref(getContext());
                sharedPref.addErrorSeconds(5);
            }
        });
        return v;
    }
    private void setTimer(View v){
        TextView timer = (TextView) v.findViewById(R.id.timer);
        GameTimer.getInstance().setTimerToTextViewOnContinue(timer);
    }
}

