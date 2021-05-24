package lelida.avaj_launcher;

import lelida.avaj_launcher.aircraft.Coordinates;

public class WeatherTower extends Tower{

    void changeWeather(){
        this.conditionsChanged();
    }

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}