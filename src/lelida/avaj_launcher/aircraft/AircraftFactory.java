package lelida.avaj_launcher.aircraft;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        type = type.toLowerCase();
        switch (type){
            case("jetplane"): return new JetPlane(name, coordinates);
            case("helicopter"): return new Helicopter(name, coordinates);
            case("baloon"): return new Baloon(name, coordinates);
            default: return null;
        }
    }
}
