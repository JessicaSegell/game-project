package main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BattleService battleService = new BattleService();
        Scanner scanner = new Scanner(System.in);

        Mage mage = new Mage("Occulus", 80, 80);
        Warrior warrior = new Warrior("Zygor", 100, 100);


        List<Fighter> heroes = new ArrayList<>();
        heroes.add(mage);
        heroes.add(warrior);

        for (Fighter hero : heroes) {
            System.out.println(hero.getFighterInformation());
        }

        boolean heroMenu = true;

        while (heroMenu) {
            try {
                System.out.println("Choose a hero: ");

                String heroChoice = scanner.nextLine();

                if (heroChoice == null) {
                    return;
                }

                heroChoice = heroChoice.trim();

                if (heroChoice.isEmpty()) {
                    throw new IllegalArgumentException("Type a hero name");
                }

                Fighter chosenFighter = null;

                for (Fighter hero : heroes) {
                    if (hero.getName().equalsIgnoreCase(heroChoice)) {
                        chosenFighter = hero;
                        break;
                    }
                }
                if (chosenFighter != null) {
                    System.out.println("You have chosen: " + chosenFighter.getFighterInformation());
                    Enemy enemy = BattleService.generateBoss();

                    battleService.heroTurn(chosenFighter, enemy);
                    heroMenu = false;

                } else {
                    throw new NullPointerException("Choose a hero");
                }

            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}