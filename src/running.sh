#!/usr/bin/bash
find . -name "*.java" > sources.txt
javac @sources.txt
java lelida.avaj_launcher.Simulator scenario.txt