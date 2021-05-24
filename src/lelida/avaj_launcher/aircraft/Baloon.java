package lelida.avaj_launcher.aircraft;

import lelida.avaj_launcher.Simulator;
import lelida.avaj_launcher.WeatherTower;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(this.coordinates);

        switch (currentWeather){
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongitude() + 2,
                    coordinates.getLatitude(), coordinates.getHeight() + 4);
            break;
            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            case "FOG": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 15);
                break;
            default: break;
        }

        HashMap<String, String> message = new HashMap<>();
        message.put("SUN", "Where are my sunglasses?!");
        message.put("RAIN", "I'm going to get wet, senpai-tower!");
        message.put("FOG", "Lilac mist floating over us...");
        message.put("SNOW", "Frozen! The air inside me shrinks...");

        Simulator.printer.println("Baloon#" + this.name + "(" + this.id + "):" + message.get(currentWeather));
        if (this.coordinates.getHeight() <= 0){
            Simulator.printer.println("Baloon#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Simulator.printer.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered to weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printer.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
