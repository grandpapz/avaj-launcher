package lelida.avaj_launcher;

import lelida.avaj_launcher.aircraft.Flyable;

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
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}