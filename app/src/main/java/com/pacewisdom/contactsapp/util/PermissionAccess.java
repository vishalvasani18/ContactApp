package com.pacewisdom.contactsapp.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class PermissionAccess {
    public static void setPermisson(Activity activity, Context context) {

        ArrayList<String> permissionArrayList = new ArrayList();


        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.CAMERA);
        }

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.READ_PHONE_STATE);
        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.INTERNET);
        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.ACCESS_WIFI_STATE);
        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.ACCESS_NETWORK_STATE);

        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.MODIFY_AUDIO_SETTINGS) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.MODIFY_AUDIO_SETTINGS);

        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.WAKE_LOCK) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.MODIFY_AUDIO_SETTINGS);

        }

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.RECEIVE_SMS);
        }

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(android.Manifest.permission.SEND_SMS);
        }
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(Manifest.permission.READ_SMS);
        }
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(Manifest.permission.READ_CONTACTS);
        }
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            permissionArrayList.add(Manifest.permission.WRITE_CONTACTS);
        }
        String[] permissionString = new String[permissionArrayList.size()];
        permissionString = permissionArrayList.toArray(permissionString);
        if (permissionString.length != 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(permissionString, 100);
            }
        }

    }
}
