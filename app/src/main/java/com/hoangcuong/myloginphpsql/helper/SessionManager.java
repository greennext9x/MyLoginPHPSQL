package com.hoangcuong.myloginphpsql.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jarvis on 4/8/2017.
 */

public class SessionManager {
    private static String TAG = SessionManager.class.getSimpleName();
     private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context mContext;

    private int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "AndroidHiveLogin";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    //Register
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_UID = "uid";
    private static final String KEY_CREATED_AT = "created_at";

    public void StoreID(String id){
        editor.putString(KEY_ID,id).commit();
    }
    public void StoreName(String name){
        editor.putString(KEY_NAME, name).commit();
    }
    public void StoreEmail(String email){
        editor.putString(KEY_EMAIL,email).commit();
    }
    public void StoreUID(String uid){
        editor.putString(KEY_UID,uid).commit();
    }
    public void StoreCreateAt(String create_at){
        editor.putString(KEY_CREATED_AT, create_at).commit();
    }

    public SessionManager(Context mContext) {
        this.mContext = mContext;
        pref = mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setLogin(boolean isLoggedIn){
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.commit();
    }
    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }
    public void clear(){
        editor.clear().commit();
    }
    public String getName(){
        return pref.getString(KEY_NAME,"");
    }
    public String getEmail(){
        return pref.getString(KEY_EMAIL,"");
    }

}
