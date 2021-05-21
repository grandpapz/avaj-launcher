package ru.school21.lelida.avaj_launcher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Validator {
    public Validator(String file) throws AvajExeptions {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Integer.parseInt(bufferedReader.readLine());
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String split[] = str.split(" ");
                if (split.length > 5) {
                    throw new AvajExeptions("Wrong number of arguments in line!");
                }
                ArrayList <String> types = new ArrayList<>();
                types.add("helicopter");
                types.add("baloon");
                types.add("jetplane");
               //if (!split[0].equalsIgnoreCase("helicopter") || !split[0].equalsIgnoreCase("baloon") || !split[0].toLowerCase().equals("jetplane")) {
                if (!types.contains(split[0].toLowerCase())){
                    System.out.println(split[0]);
                    throw new AvajExeptions("Wrong type of Aircraft!");
                }
                try {
                    Integer.parseInt(split[2]);
                    Integer.parseInt(split[3]);
                    Integer.parseInt(split[4]);
                } catch (NumberFormatException e) {
                    throw new AvajExeptions("Coordinats are not INTEGER!");
                }
            }
            bufferedReader.close();
        } catch (NumberFormatException e) {
            throw new AvajExeptions("Numbers of weather changes are not INTEGER!");
        } catch (FileNotFoundException e) {
            throw new AvajExeptions("File " + file + " not found!");
        } catch (IOException e) {
            throw new AvajExeptions("Can't read from source file!");
        }
    }
}
