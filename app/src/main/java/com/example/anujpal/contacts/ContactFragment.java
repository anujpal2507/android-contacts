package com.example.anujpal.contacts;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by anujpal on 4/12/15.
 */
public class ContactFragment extends Fragment {

//    public static ContactFragment newInstance(){
//        return new  ContactFragment();
//    }
    EditText name;
    EditText phn;
    EditText email;
    Button save;
    private ContactDatabase db;
    public ContactFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.contacts, container, false);
        name = (EditText)view.findViewById(R.id.name);
        phn = (EditText)view.findViewById(R.id.phn);
        email = (EditText)view.findViewById(R.id.email);
        save = (Button)view.findViewById(R.id.save);
       // db = new ContactDatabase(getActivity());
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view1){
               String contactName = name.getText().toString();
               String contactPhone = phn.getText().toString();
               String contactEmail = email.getText().toString();

               if(contactName != null && contactPhone !=null ){
                   db = new ContactDatabase(getContext());
                   db.addContact(new Contacts(contactName,contactPhone,contactEmail));
               }
               name.setText("");
               phn.setText("");
               email.setText("");

                List<Contacts> contactsList= db.getAllContacts();
                for (Contacts cn : contactsList) {
                    String log = "Id: "+cn.getId() +" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone()
                            + " Email" + cn.getEmail();
                    // Writing Contacts to log
                    Log.i("Name: ", log);
                }
                //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            }
        });
        return view;
    }
}
