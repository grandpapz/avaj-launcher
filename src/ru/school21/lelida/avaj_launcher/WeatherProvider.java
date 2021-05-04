package ru.school21.lelida.avaj_launcher;

import java.util.ArrayList;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int seed = 21 * (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());

        return weather[seed % 4];
    }

//    public static void main(String[] args){
//        Coordinates coordinates = new Coordinates(1, 1, 1);
//        Coordinates coordinates2 = new Coordinates(2, 2, 2);
//        Coordinates coordinates3 = new Coordinates(3, 3, 3);
//        Coordinates coordinates4 = new Coordinates(4, 4, 4);
//        Coordinates[] cord = {coordinates3, coordinates2, coordinates4, coordinates};
//        for (Coordinates cords : cord) {
//            System.out.println(WeatherProvider.weatherProvider.getCurrentWeather(cords));
//        }
//    }
}
