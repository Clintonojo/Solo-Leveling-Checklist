/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sololevelingchecklist;

/**
 *
 * @author Clinton
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    private String name;
    private String playerClass;
    private int exp;

    public Player(String name) {
        this.name = name;
        this.playerClass = "Non-Awakened"; // Start with Non-Awakened class
        this.exp = 0; // Start with 0 EXP
    }

    public String getName() {
        return name;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public int getExp() {
        return exp;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Player Information:\n" +
                "Name: " + name + "\n" +
                "Class: " + playerClass + "\n" +
                "EXP: " + exp + "\n";
    }
}

class PlayerManager {
    private List<Player> players;

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void showAllPlayersInfo() {
        System.out.println("===== All Players Information =====");
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
public class SoloLevelingChecklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerManager playerManager = new PlayerManager();

        // Create players
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player name: ");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            playerManager.addPlayer(player);
        }

        // Display player information
        playerManager.showAllPlayersInfo();

        scanner.close();
    }
}


