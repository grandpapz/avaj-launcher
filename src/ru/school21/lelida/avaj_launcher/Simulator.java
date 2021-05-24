package ru.school21.lelida.avaj_launcher;

import java.io.*;

public class Simulator {
    public static PrintWriter printer;
    static int counter;

    public static void main(String[] args) {
        if (args.length != 1)
            return;
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Validator validator = new Validator(args[0]);
        } catch (AvajExeptions avajExeptions) {
            System.out.println("\u001B[34m" + "Validator says: " + avajExeptions.getMessage());
            return;
        }
        try {
            WeatherTower weatherTower = new WeatherTower();
            String input = args[0];
            printer = new PrintWriter("simulation.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
            counter = Integer.parseInt(bufferedReader.readLine());
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(" ");

                // need to create Factory to make objects here;

            }
            while (counter-- > 0) {
                weatherTower.changeWeather();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[34m" + "Simulator says: Can't write in simulation.txt");
            return;
        } catch (IOException e) {
            // There are must be buffereReader exceptions, but... I checked this in da Validator.
            System.out.println("Simulator says: IO Exception. One on da million");
            return;
        }
    }
}
