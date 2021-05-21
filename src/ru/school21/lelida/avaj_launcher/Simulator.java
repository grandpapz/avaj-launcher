package ru.school21.lelida.avaj_launcher;

import java.io.*;

public class Simulator {
    public static PrintWriter printer;
    static int counter;

    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            return;
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Validator validator = new Validator(args[0]);
        } catch (AvajExeptions avajExeptions) {
            System.out.println("\u001B[34m" + "Validator says: "+ avajExeptions.getMessage());
            return;
        }

        WeatherTower weatherTower = new WeatherTower();
        String input = args[0];
        printer = new PrintWriter("simulation.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        counter = Integer.parseInt(bufferedReader.readLine());
        if (counter <= 0)
            throw new IOException();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] split = line.split(" ");
            if (split.length == 5){
                // need to create Factory to make objects here;
            }
            else
                throw new IOException();
        }
        while (counter-- > 0){
            weatherTower.changeWeather();
        }
    }
}
