package com.example.android.jokedisplay;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokeDisplayFragment extends Fragment {


    public JokeDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_display,container,false);
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        String gceResult = getActivity().getIntent().getStringExtra("gce_result");
        TextView tellJoke = rootView.findViewById(R.id.tell_joke_tv);
        /**if(getIntent().getStringExtra("joke").equals("empty")){
         textView.setText(R.string.default_joke);
         }else{
         textView.setText(getIntent().getStringExtra("joke"));*/
       /** if (joke != null){
            tellJoke.setText(joke);
        } else {
            tellJoke.setText(R.string.tell_joke);
        }*/
       tellJoke.setText(gceResult);


        return rootView;
    }

}
