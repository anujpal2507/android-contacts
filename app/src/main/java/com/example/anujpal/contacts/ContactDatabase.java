package com.example.anujpal.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anujpal on 7/12/15.
 */
public class ContactDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyContacts.db";
    public static final String DATABASE_TABLE = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public ContactDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DATABASE_TABLE + "(" + COLUMN_ID +" INTEGER PRIMARY KEY,"+
                COLUMN_NAME + " TEXT," +COLUMN_PHONE + " TEXT," + COLUMN_EMAIL + " TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS contacts" + DATABASE_TABLE);
        onCreate(db);
    }
// Add New Contacts
    public void addContact(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,contacts.getName());
        contentValues.put(COLUMN_PHONE,contacts.getPhone());
        contentValues.put(COLUMN_EMAIL,contacts.getEmail());

        db.insert(DATABASE_TABLE, null, contentValues);
        db.close();
    }
// Get Contacts
    public Contacts getContacts(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_PHONE,COLUMN_EMAIL},COLUMN_ID+
                        "= ?", new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();

        Contacts contacts = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
                cursor.getString(2),cursor.getString(3));

        return contacts;
    }
// Get All Contacts
    public List<Contacts> getAllContacts(){
        List<Contacts> contactsList = new ArrayList<Contacts>();
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Contacts contacts = new Contacts();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhone(cursor.getString(2));
                contacts.setEmail(cursor.getString(3));

                contactsList.add(contacts);
            } while (cursor.moveToNext());
        }
        return contactsList;
    }
// Get Contacts Count
    public int getContactsCount(){
        String countQuery = "SELECT * FROM "+ DATABASE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
// Updating Record
    public int updateContact(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME,contacts.getName());
        contentValues.put(COLUMN_PHONE,contacts.getPhone());
        contentValues.put(COLUMN_EMAIL, contacts.getEmail());

        return db.update(DATABASE_TABLE, contentValues, COLUMN_ID + "= ?",
                new String[]{String.valueOf(contacts.getId())});
    }
// Deleting Record
    public void deleteContact(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE,COLUMN_ID+"= ?",
                new String[]{String.valueOf(contacts.getId())});
        db.close();
    }




//    public boolean insertContact(String name, String phone, String email){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name",name);
//        contentValues.put("phone",phone);
//        contentValues.put("email", email);
//        db.insert("contacts", null, contentValues);
//        return true;
//    }
//
//    public Cursor getData(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = db.rawQuery("select * from contacts id="+id+"",null);
//        return res;
//    }
//
//    public int numberOfRows(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        int numRows = (int) DatabaseUtils.queryNumEntries(db,dbTable);
//        return numRows;
//    }
//
//    public boolean updateContact(Integer id, String name, String phone, String email){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name",name);
//        contentValues.put("phone",phone);
//        contentValues.put("email", email);
//        db.update("contacts",contentValues,"id=?", new String[]{Integer.toString(id)});
//        return true;
//    }
//
//    public Integer deleteContact(Integer id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete("contacts","id=? ", new String[]{Integer.toString(id)});
//    }
//
//    public ArrayList<String> getAllContacts(){
//        ArrayList<String> arrayList = new ArrayList<String>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from contacts",null);
//        cursor.moveToFirst();
//
//        while (cursor.isAfterLast()==false ){
//            arrayList.add(cursor.getString(cursor.getColumnIndex(dbColumnName)));
//            cursor.moveToNext();
//        }
//        return arrayList;
//    }
}
