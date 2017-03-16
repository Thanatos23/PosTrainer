package com.bracketcove.postrainer;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This all made more sense after watching
 * <a href="https://www.youtube.com/watch?v=plK0zyRLIP8&t=92s">This talk.</a>
 *
 * This is a Module. It provides dependencies via @Provides annotated methods below.
 * Module's are designed to be partitioned in a way that makes sense.
 * Created by Ryan on 10/03/2017.
 */
@Module
public final class ApplicationModule {
    private final Context context;

    public ApplicationModule(Context context) {

        this.context = context;
    }

    /**
     * A Module method which provides a dependency, should be annotated with (at)Provides,
     * like so. This is a "hook" which tells Dagger that there is a dependency that can be grabbed
     * from here. Also, the since we only want a Single Instance ever, we use the Singleton
     * annotation to tell dagger.
     * @return
     */
    @Provides
    public Context provideContext() {
        return context.getApplicationContext();
    }

}
