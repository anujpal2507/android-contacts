package com.example.anujpal.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by anujpal on 8/12/15.
 */
public class AddContact extends AppCompatActivity {

    EditText addName;
    EditText addPhn;
    EditText addEmail;
    Button saveContact;
    public ContactDatabase contactDatabase;
    private String valid_email;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contacts);
        Log.i("In Add Contacts","hi");
    }

    @Override
    public void onStart(){
        super.onStart();

        addName = (EditText)findViewById(R.id.name);
        addPhn = (EditText)findViewById(R.id.phn);
        addEmail = (EditText)findViewById(R.id.email);
        addEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Is_Valid_Email(addEmail);
            }

            public void Is_Valid_Email(EditText edit){
                if(edit.getText().toString()==null){
                    edit.setError("In Valid Email");
                    valid_email=null;
                }
                else if (isEmailValid(addEmail.getText().toString()) == false) {
                    edit.setError("In Valid Email");
                    valid_email=null;
                }
                else {
                    valid_email = edit.getText().toString();
                }

            }

            boolean isEmailValid(CharSequence email){
                return Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
        });
        saveContact = (Button)findViewById(R.id.save);
        saveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contactName = addName.getText().toString();
                String contactPhone = addPhn.getText().toString();
                String contactEmail = addEmail.getText().toString();

                if (!(contactName.equals("") && contactPhone.equals(""))) {
                    contactDatabase = new ContactDatabase(getApplicationContext());
                    contactDatabase.addContact(new Contacts(contactName, contactPhone, contactEmail));
                }

                List<Contacts> tempList = contactDatabase.getAllContacts();
                for (Contacts cn : tempList) {
                    String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone()
                            + " Email" + cn.getEmail();
                    Log.i("Name", log);
                }
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
                finish();
            }
        });

        Log.i("Android", "In Start");
    }
}
