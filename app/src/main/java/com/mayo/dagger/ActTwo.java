package com.mayo.dagger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class ActTwo extends BaseActivity {
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_two);

//        App.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getString("name", null) == null) {
            editor.putString("name", "mayo");
            Log.i(Tag.LOG, "Edited");
        } else
            Log.i(Tag.LOG, "Existed");

        editor.commit();
    }

}
