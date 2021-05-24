package lelida.avaj_launcher.aircraft;

/* Base class for aircraft's. We will extend by our new types of Flyable objects */

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.coordinates = coordinates;
        this.name = name;
        this.id = nextId();
    }

    private long nextId(){
        return ++idCounter;
    }
}
