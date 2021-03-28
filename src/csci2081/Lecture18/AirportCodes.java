package csci2081.Lecture18;


import java.util.Scanner;
import java.util.HashMap;

public class AirportCodes {
    public static void main (String[] args) {
        HashMap<String, String> playerTeam = new HashMap<String, String>();
        Scanner scnr = new Scanner(System.in);
        String playerName;

        playerTeam.put("Woods", "Rams");
        playerTeam.put("Franklin", "Eagles");
        playerTeam.put("Sharif", "Tigers");
        playerTeam.putIfAbsent("Woods", "Lions");
        playerTeam.putIfAbsent("Dale", "Bears");

        playerName = scnr.next();
        while (!playerName.equals("exit")) {
            System.out.print(playerName + ": ");
            System.out.println(playerTeam.get(playerName));
            playerName = scnr.next();
        }
    }
}