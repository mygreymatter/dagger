package com.mayo.dagger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mayo.dagger.job.IJobListener;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class ActMain extends BaseActivity {
    @Inject
    IJobListener jobManager;

    @Inject
    SharedPreferences sharedPreferences;

    @Bind(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

//        App.inject(this);
        jobManager.doSomeJob();

//        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        text.setText("ButterKnife");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getString("name", null) == null) {
            editor.putString("name", "mayo");
            Log.i(Tag.LOG, "Edited");
        } else
            Log.i(Tag.LOG, "Existed");

        editor.commit();

    }

    @OnClick(R.id.text)
    public void showShared() {
        Intent intent = new Intent(this, ActTwo.class);
        startActivity(intent);
    }
}
