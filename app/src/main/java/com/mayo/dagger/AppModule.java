package com.mayo.dagger;

import android.content.Context;

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
                JobManager.class,
        })
public class AppModule {
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


}
