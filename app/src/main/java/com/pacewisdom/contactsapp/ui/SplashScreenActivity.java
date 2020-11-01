package com.pacewisdom.contactsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pacewisdom.contactsapp.R;

import static com.pacewisdom.contactsapp.util.PermissionAccess.setPermisson;

public class SplashScreenActivity extends AppCompatActivity {

    //Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setPermisson(this, this);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                goToContactList();
            }
        }, SPLASH_TIME_OUT);
    }

    private void goToContactList() {

        Intent intent = new Intent(SplashScreenActivity.this, ContactListActivity.class);
        startActivity(intent);
        finish();
    }


}
