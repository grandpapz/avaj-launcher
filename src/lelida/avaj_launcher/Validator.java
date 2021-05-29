package lelida.avaj_launcher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Validator {
    public Validator(String file) throws AvajExeptions {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            if (Integer.parseInt(bufferedReader.readLine()) <= 0){
                throw new AvajExeptions("First row [Weather changes value] must be greater than zero!");
            }
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String split[] = str.split(" ");
                if (split.length != 5) {
                    throw new AvajExeptions("Wrong number of arguments in line!");
                }
//                if (split[1].isEmpty()){
//                    throw new AvajExeptions("Thats boring. Don't type NULL in da name");
//                }
                ArrayList <String> types = new ArrayList<>();
                types.add("helicopter");
                types.add("baloon");
                types.add("jetplane");
                if (!types.contains(split[0].toLowerCase())){
                    throw new AvajExeptions("Wrong type of Aircraft!");
                }
                try {
                    if (Integer.parseInt(split[2]) < 0 || Integer.parseInt(split[3]) < 0 ||
                            Integer.parseInt(split[4]) < 0){
                        throw new AvajExeptions("Negative value on coordinates detected!");
                    }

                } catch (NumberFormatException e) {
                    throw new AvajExeptions("Coordinates are not INTEGER!");
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new AvajExeptions("File " + file + " not found!");
        } catch (NumberFormatException e) {
            throw new AvajExeptions("Wrong numbers of weather changes cycles!");
        } catch (IOException e) {
            throw new AvajExeptions("Can't read from source file!");
        }
    }
}
