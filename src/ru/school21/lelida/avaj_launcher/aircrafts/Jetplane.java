package ru.school21.lelida.avaj_launcher.aircrafts;

import ru.school21.lelida.avaj_launcher.Simulator;
import ru.school21.lelida.avaj_launcher.WeatherTower;

import java.util.HashMap;

public class Jetplane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Jetplane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(this.coordinates);

        switch (currentWeather){
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            break;
            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 1, coordinates.getHeight());
                break;
            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 7);
                break;
            default: break;
        }

        HashMap<String, String> message = new HashMap<>();
        message.put("SUN", "Sun shining, the weather is sweet, yeah");
        message.put("RAIN", "After rain coming inspiration. (A. Fet)");
        message.put("FOG", "Fog doesn't matter, i've arduino navigation!");
        message.put("SNOW", "Let's make some snowman?!");

        Simulator.printer.println("Jetplane#" + this.name + "(" + this.id + "):" + message.get(currentWeather));
        if (this.coordinates.getHeight() <= 0){
            Simulator.printer.println("Jetplane#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Simulator.printer.println("Tower says: Jetplane#" + this.name + "(" + this.id + ")" + "unregistered to weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printer.println("Tower says: Jetplane#" + this.name + "(" + this.id + ")" + "registered to weather tower.");
    }
}
