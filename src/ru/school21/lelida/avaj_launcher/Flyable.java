package ru.school21.lelida.avaj_launcher;

/* All interface methotds public by default */

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}