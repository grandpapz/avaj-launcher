package ru.school21.lelida.avaj_launcher;

import ru.school21.lelida.avaj_launcher.aircrafts.Coordinates;

public class WeatherTower extends Tower{

    void changeWeather(){
        this.conditionsChanged();
    }

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}