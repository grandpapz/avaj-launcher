package lelida.avaj_launcher.aircraft;

/* All interface methotds public by default */

import lelida.avaj_launcher.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}