package com.example.toomy.gryterenowe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;
import android.graphics.Color;
/**
 * A simple {@link Fragment} subclass.
 */
public class QuestForUeCnti2 extends Fragment {


    private EditText answer;
    private Button QuestForUeBtn;

    public QuestForUeCnti2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_quest_for_ue_cnti2, container, false);

        QuestForUeBtn = (Button) v.findViewById(R.id.dalejcnti3);

        answer = (EditText)v.findViewById(R.id.editText);
        answer.addTextChangedListener(mWatcher);
        QuestForUeBtn.setEnabled(false);
        QuestForUeBtn.setBackgroundColor(Color.GRAY);

        QuestForUeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestForUeCnti3 questForUe = new QuestForUeCnti3();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.flcontent,questForUe,questForUe.getTag()).commit();

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


    public void enableSubmitIfReady(EditText answear, Button next) {

        boolean isReady = answer.getText().toString().equals("@");
        next.setEnabled(isReady);
        if (isReady == true){
            next.setBackgroundColor(Color.GREEN);
        }
    }


}
