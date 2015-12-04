package com.example.anujpal.contacts;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by anujpal on 4/12/15.
 */

public class PhoneFragment extends Fragment {

//    public static PhoneFragment newInstance(){
//        return new  PhoneFragment();
//    }

    public PhoneFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       // Button callBtn = (Button) findViewById(R.id.callBtn);
        call();                                                       //calling default call method of android
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.phone,container,false);
    }

    public void call(){                                               //for default call using phone
        try{
            Intent intentCall = new Intent(Intent.ACTION_DIAL);
            startActivity(intentCall);
        }
        catch (ActivityNotFoundException activityException){
            Log.e("Hello Android Dialer","Call Failed",activityException);
        }
    }
}
