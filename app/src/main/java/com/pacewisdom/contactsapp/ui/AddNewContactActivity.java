package com.pacewisdom.contactsapp.ui;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pacewisdom.contactsapp.R;
import com.pacewisdom.contactsapp.util.Validation;

public class AddNewContactActivity extends AppCompatActivity {

    RelativeLayout rlSave;
    Toolbar toolbar;
    EditText etName, etContactNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.add_new);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white_color), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etName = (EditText) findViewById(R.id.etName);
        etContactNo = (EditText) findViewById(R.id.etContactNo);
        rlSave = (RelativeLayout) findViewById(R.id.rlSave);
        rlSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFormvalidate()){

                    // Get android phone contact content provider uri.
                    //Uri addContactsUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                    // Below uri can avoid java.lang.UnsupportedOperationException: URI: content://com.android.contacts/data/phones error.
                    Uri addContactsUri = ContactsContract.Data.CONTENT_URI;

                    // Add an empty contact and get the generated id.
                    long rowContactId = getRawContactId();

                    // Add contact name data.
                    String displayName = etName.getText().toString();
                    insertContactDisplayName(addContactsUri, rowContactId, displayName);

                    // Add contact phone data.
                    String phoneNumber = etContactNo.getText().toString();
                //    String phoneTypeStr = (String)phoneTypeSpinner.getSelectedItem();
                    insertContactPhoneNumber(addContactsUri, rowContactId, phoneNumber);

                    Toast.makeText(getApplicationContext(),"New contact has been added" , Toast.LENGTH_LONG).show();

                    finish();
                }
            }
        });
    }

    private long getRawContactId()
    {
        // Insert an empty contact.
        ContentValues contentValues = new ContentValues();
        Uri rawContactUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, contentValues);
        // Get the newly created contact raw id.
        long ret = ContentUris.parseId(rawContactUri);
        return ret;
    }

    private void insertContactPhoneNumber(Uri addContactsUri, long rawContactId, String phoneNumber)
    {
        // Create a ContentValues object.
        ContentValues contentValues = new ContentValues();

        // Each contact must has an id to avoid java.lang.IllegalArgumentException: raw_contact_id is required error.
        contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);

        // Each contact must has an mime type to avoid java.lang.IllegalArgumentException: mimetype is required error.
        contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);

        // Put phone number value.
        contentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneNumber);


        // Insert new contact data into phone contact list.
        getContentResolver().insert(addContactsUri, contentValues);

    }


    private boolean isFormvalidate() {

        String name = etName.getText().toString();
        String contact = etContactNo.getText().toString();

        if (Validation.isBlank(name)) {
            Toast.makeText(AddNewContactActivity.this, "Name can't be left blank", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Validation.isBlank(contact)) {
            Toast.makeText(AddNewContactActivity.this, "Mobile no. can't be left blank", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void insertContactDisplayName(Uri addContactsUri, long rawContactId, String displayName)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);

        // Each contact must has an mime type to avoid java.lang.IllegalArgumentException: mimetype is required error.
        contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);

        // Put contact display name value.
        contentValues.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, displayName);

        getContentResolver().insert(addContactsUri, contentValues);

    }

}
