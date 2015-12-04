package com.example.anujpal.contacts;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anujpal on 4/12/15.
 */
public class FavoritesFragment extends Fragment {

//    public static FavoritesFragment newInstance(){
//        return new FavoritesFragment();
//    }

    public FavoritesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.favorites,container,false);
    }
}
