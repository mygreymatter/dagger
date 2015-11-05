package com.mayo.dagger.job;

import android.util.Log;

import com.mayo.dagger.Tag;

/**
 * Created by mayo on 5/11/15.
 */
public class JobManager implements IJobListener{
    @Override
    public void doSomeJob() {
        Log.i(Tag.LOG,"Doing some job..!");
    }
}
