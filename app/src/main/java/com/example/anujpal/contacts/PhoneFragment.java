package com.example.anujpal.contacts;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anujpal on 4/12/15.
 */

public class PhoneFragment extends Fragment {

//    public static PhoneFragment newInstance(){
//        return new  PhoneFragment();
//    }

    Button callBtn;
    EditText dialEditText;

    public PhoneFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

       // call();                                                       //calling default call method of android
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.phone,container,false);
        callBtn= (Button)view.findViewById(R.id.callBtn);
        dialEditText = (EditText)view.findViewById(R.id.dialEditText);
        callBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if (dialEditText != null) {
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + dialEditText.getText())));
                    } else {
                        Toast.makeText(getContext(), "You missed to type the number!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("DialerAppActivity", "error: " +
                            e.getMessage(), e);
                }
                dialEditText.setText("");
            }
        });
        return view;
    }

//    public void call(){                                               //for default call using phone
//        try{
//            Intent intentCall = new Intent(Intent.ACTION_CALL);
//            startActivity(intentCall);
//        }
//        catch (ActivityNotFoundException activityException){
//            Log.e("Hello Android Dialer","Call Failed",activityException);
//        }
//    }
}
