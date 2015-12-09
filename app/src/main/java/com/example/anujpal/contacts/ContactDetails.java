package com.example.anujpal.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by anujpal on 9/12/15.
 */
public class ContactDetails extends AppCompatActivity {

    TextView name;
    TextView phone;
    TextView email;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);
        Log.i("In Contact","Details");
    }

    @Override
    public void onStart(){
        super.onStart();
        name = (TextView)findViewById(R.id.contactName);
        phone = (TextView)findViewById(R.id.contactPhone);
        email = (TextView)findViewById(R.id.contactEmail);

        Bundle bundle = getIntent().getExtras();
        String cName = bundle.getString("phone");
        phone.setText(cName);

    }
}
