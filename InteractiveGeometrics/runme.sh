#!/bin/bash
CP='-cp .:src/:lib/core.jar:lib/controlP5.jar'
javac $CP src/*.java
java $CP ShipShaper
