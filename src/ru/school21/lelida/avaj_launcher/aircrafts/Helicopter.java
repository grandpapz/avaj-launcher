package ru.school21.lelida.avaj_launcher.aircrafts;

import ru.school21.lelida.avaj_launcher.Simulator;
import ru.school21.lelida.avaj_launcher.WeatherTower;
import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(this.coordinates);

        switch (currentWeather){
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongitude() + 10,
                    coordinates.getLatitude(), coordinates.getHeight() + 2);
            break;
            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongitude() + 5,
                    coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG": this.coordinates = new Coordinates(coordinates.getLongitude() + 1,
                    coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
            default: break;
        }

        HashMap<String, String> message = new HashMap<>();
        message.put("SUN", "Ohhh Sunny weather is pretty fine!");
        message.put("RAIN", "Rain rain go away!");
        message.put("FOG", "Fog! i can't see anything!");
        message.put("SNOW", "Let it snow!");

        Simulator.printer.println("Helicopter#" + this.name + "(" + this.id + "):" + message.get(currentWeather));
        if (this.coordinates.getHeight() <= 0){
            Simulator.printer.println("Helicopter#" + this.name + "(" + this.id + ") landing");
            this.weatherTower.unregister(this);
            Simulator.printer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + "unregistered to weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + "registered to weather tower.");
    }
}
