package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Change the program to allow players to type full words, or phrases, then move to the
// correct location based upon their input.
// The player should be able to type commands such as "Go West", "run South", or just "East"
// and the program will move to the appropriate location if there is one.  As at present, an
// attempt to move in an invalid direction should print a message and remain in the same place.
//
// Single letter commands (N, W, S, E, Q) should still be available.

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map <String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "in from of a computer (0)", null));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "at the end of a road (1)", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "at the top of a hill (2)", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "inside of a building (3)", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "in a valley, near a stream (4)", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "in the forest (5)", tempExit));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("UP", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("DOWN", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("RIGHT", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("LEFT", "W");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExists();
            System.out.println("Available exists are:");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word:words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get (word);
                        break;
                    }
                }
            }

//            if (direction.contains("NORTH")) {
//                direction = "N";
//            } else if (direction.contains("SOUTH")) {
//                direction = "S";
//            } else if (direction.contains("EAST")) {
//                direction = "E";
//            } else if (direction.contains("WEST")) {
//                direction = "W";
//            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
