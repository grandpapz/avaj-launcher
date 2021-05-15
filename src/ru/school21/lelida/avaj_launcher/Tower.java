package ru.school21.lelida.avaj_launcher;

import ru.school21.lelida.avaj_launcher.aircrafts.Flyable;
import java.util.ArrayList;
import java.util.List;

/* This class observe all Aircrafts. Also register and unregister them. This class realize "Observer" pattern */

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable observer : observers){
            observer.updateConditions();
        }
    }
}