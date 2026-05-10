package org.example;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class AppModule {
    @Provides
    @Named("customsUrl")
    String provideCustomsUrl() {
        return "https://autoholding-customs.com/api";
    }

    @Provides
    @Singleton
    CarRepository provideCarRepository(AppCarRepository appCarRepository) {
        return appCarRepository;
    }
}
