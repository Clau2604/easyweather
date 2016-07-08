package com.daniloprado.weather.dagger.module;

import android.content.Context;

import com.daniloprado.weather.data.db.helper.DatabaseHelper;
import com.daniloprado.weather.data.repository.CityRepository;
import com.daniloprado.weather.data.repository.ForecastRepository;
import com.daniloprado.weather.data.repository.impl.CityRepositoryImpl;
import com.daniloprado.weather.data.repository.impl.ForecastRepositoryImpl;
import com.daniloprado.weather.data.service.ForecastService;
import com.daniloprado.weather.model.City;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    CityRepository provideCityRepository(Context context, DatabaseHelper databaseHelper, @Named("CityDao") RuntimeExceptionDao<City, Integer> cityDao) {
        return new CityRepositoryImpl(context, databaseHelper, cityDao);
    }

    @Provides
    ForecastRepository provideForecastRepository(ForecastService service, Context context) {
        return new ForecastRepositoryImpl(service, context);
    }

}
