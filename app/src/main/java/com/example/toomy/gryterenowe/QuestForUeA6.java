package com.example.toomy.gryterenowe;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestForUeA6 extends Fragment {

    EditText answer;
    Button QuestForUeBtn;
    public QuestForUeA6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quest_for_ue_a6, container, false);
        QuestForUeBtn = (Button) v.findViewById(R.id.daleja7);
        answer = (EditText)v.findViewById(R.id.answer);
        answer.addTextChangedListener(mWatcher);
        QuestForUeBtn.setEnabled(false);
        QuestForUeBtn.setBackgroundColor(Color.GRAY);

        setTimer(v);
        QuestForUeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestForUeA7 questForUe = new QuestForUeA7();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.flcontent, questForUe, questForUe.getTag()).commit();

            }
        });
        return v;
    }

    private TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            enableSubmitIfReady(answer, QuestForUeBtn);
        }
    };

    public void enableSubmitIfReady(EditText answer, Button next) {

        if (answer.getText().toString().equals("1")){
            next.setEnabled(true);
            next.setBackgroundColor(Color.GREEN);
        }
    }
    private void setTimer(View v){
        TextView timer = (TextView) v.findViewById(R.id.timer);
        GameTimer.getInstance().setTimerToTextViewOnContinue(timer);
    }

}
