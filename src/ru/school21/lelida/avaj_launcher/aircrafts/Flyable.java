package ru.school21.lelida.avaj_launcher.aircrafts;

import ru.school21.lelida.avaj_launcher.WeatherTower;

/* All interface methotds public by default */

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}