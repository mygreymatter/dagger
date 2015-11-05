package com.mayo.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.mayo.dagger.ActMain;
import com.mayo.dagger.ActTwo;
import com.mayo.dagger.App;
import com.mayo.dagger.job.IJobListener;
import com.mayo.dagger.job.JobManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mayo on 5/11/15.
 */
@Module(complete = false,
        library = true,
        injects = {
                App.class,
                ActMain.class,
                ActTwo.class,
                JobManager.class,
                SharedPreferences.class,
        })
public class AppModule {
    private static final String PREFS_DEFAULT = "dagger_sharedpreferences";
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return app;
    }

    @Provides
    IJobListener provideJobManager(){
        return new JobManager();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreference() {
        return app.getSharedPreferences(PREFS_DEFAULT, Context.MODE_PRIVATE);
    }

}
