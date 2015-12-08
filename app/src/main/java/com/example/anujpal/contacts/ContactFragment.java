package com.example.anujpal.contacts;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by anujpal on 4/12/15.
 */
public class ContactFragment extends Fragment {

    Button addContacts;
    String phone;
    private ContactDatabase db;

    public ContactFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.detach(this).attach(this).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.contacts, container, false);
        db = new ContactDatabase(getContext());
        final ArrayList<Contacts> contactsArrayList = db.getAllContacts();
        ArrayList<String> namesList = new ArrayList<String>();
        for(int i = 0;i<contactsArrayList.size();i++){
            namesList.add(contactsArrayList.get(i).getName());
//          namesList.add(contactsArrayList.get(i).getPhone());
        }

        ListView listView = (ListView)view.findViewById(R.id.contactList);
        ArrayAdapter ad = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,namesList);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                phone = contactsArrayList.get(position).getPhone();
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
                Log.i("num", phone);
                Log.i("position",Integer.toString(position));
            }
        });
        addContacts = (Button)view.findViewById(R.id.addContact);
        addContacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent intent = new Intent(getContext(),AddContact.class);
                startActivity(intent);
                //AddContacts addContacts = new AddContacts();
//                Fragment addContacts = new AddContacts();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();
//                transaction.replace(R.layout.add_contacts,addContacts);
//                transaction.commit();
            }
        });
        return view;
    }
}
