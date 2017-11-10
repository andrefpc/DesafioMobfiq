package com.andrefpc.desafiomobfiq.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by andrefelipepaivacardozo on 09/11/17.
 */

public class SharedPreferencesManager {

    public final static String PREFS_KEY = "key";
    public final static String PHONE_KEY = "key";


    public final static String PREFS_ACCESS = "access";
    public final static String FIRST_ACCESS = "first_access";

    public static void saveKey(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PHONE_KEY, key);

        editor.commit();

    }


    public static String getKey(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
        String key = prefs.getString(PHONE_KEY, "");

        return key;
    }

    public static void saveFirstAccess(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_ACCESS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(FIRST_ACCESS, false);

        editor.commit();

    }


    public static boolean isFirstAccess(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_ACCESS, Context.MODE_PRIVATE);
        boolean key = prefs.getBoolean(FIRST_ACCESS, true);

        return key;
    }
}
