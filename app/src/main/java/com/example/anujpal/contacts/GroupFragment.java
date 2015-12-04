package com.example.anujpal.contacts;

import android.animation.FloatArrayEvaluator;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anujpal on 4/12/15.
 */
public class GroupFragment extends Fragment {

//    public static GroupFragment newInstance(){
//        return new GroupFragment();
//    }

    public GroupFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.groups,container, false);
    }
}
