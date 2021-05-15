package ru.school21.lelida.avaj_launcher;

import java.io.*;
//Need to think about some file Validation and make own Exceptions
public class Simulator {
    public static PrintWriter printer;
    static int counter;

    public static void main(String[] args) throws IOException {
        WeatherTower weatherTower = new WeatherTower();
        if (args.length != 1)
            return;
        String input = args[0];
        printer = new PrintWriter("simulation.txt");


        //Some Validation here;


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
