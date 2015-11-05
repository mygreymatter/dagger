package com.mayo.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mayo.dagger.job.IJobListener;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActMain extends AppCompatActivity {
    @Inject
    IJobListener jobManager;

    @Bind(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        App.inject(this);
        jobManager.doSomeJob();

        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        text.setText("ButterKnife");
    }
}
