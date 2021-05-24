package lelida.avaj_launcher;

public class AvajExeptions extends Exception{
    public AvajExeptions() {
        super();
    }
    public AvajExeptions(Throwable throwable){
        super(throwable);
    }
    public AvajExeptions(String message) {
        super(message);
    }
}
