package lelida.avaj_launcher;

/*This Class realize "Singletone" pattern */

import lelida.avaj_launcher.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int seed = 21 * (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());

        return weather[seed % 4];
    }
}
