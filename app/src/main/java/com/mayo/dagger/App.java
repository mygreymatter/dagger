package com.mayo.dagger;

import android.app.Application;

import com.mayo.dagger.module.AppModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by mayo on 5/11/15.
 */
public class App extends Application {
    private static App app;
    private ObjectGraph mObjectGraph;

    public static App getApp(){return app;}

    public static void inject(Object o){
        App.getApp().mObjectGraph.inject(o);
    }

    public static <T> T produce(Class<T> claz){
        return App.getApp().mObjectGraph.get(claz);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        mObjectGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules(){
        return Arrays.<Object>asList(new AppModule(this));
    }
}
