package main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        BattleService battleService = new BattleService();
        Scanner scanner = new Scanner(System.in);

        Mage mage = new Mage("Occulus", 80, 80);
        Warrior warrior = new Warrior("Zygor", 100, 100);

        /*
        Enemy defender1 = new Enemy("Agdemenon the Atrociuos", 150, 150);
        Enemy defender2 = new Enemy("Tengel the Terrible", 125, 125);
        List<Enemy> bosses = new ArrayList<>();
        bosses.add(defender1);
        bosses.add(defender2);
*/


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
                    //generateBoss();
                    startGame(chosenFighter);
                    heroMenu = false;

                } else {
                    throw new NullPointerException("Choose a hero");
                }

            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    static void startGame(Fighter hero) {
        Enemy enemy = generateBoss();
        BattleService battleService = new BattleService();

        Object[] options1 = {"Attack", "Heal", "SpecialAttack"};
        JPanel panel = new JPanel();
        String heroStats = hero.getName() + " HP: " + hero.getHealth();
        String enemyStats = enemy.getName() + " HP: " + enemy.getHealth();
        panel.add(new JLabel(heroStats));
        panel.add(new JLabel(enemyStats));
        panel.add(new JLabel("Choose an action"));
        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Battle Arena",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);

        int turnCounter = 0;


        if(result == JOptionPane.YES_OPTION){
            battleService.attack(hero, enemy);
            turnCounter++;
            battleService.enemyAttack(enemy, hero, turnCounter);
        }
    }

    static Enemy generateBoss() {
        Enemy defender1 = new Enemy("Agdemenon the Atrociuos", 150, 150);
        Enemy defender2 = new Enemy("Tengel the Terrible", 125, 125);

        List<Enemy> bosses = new ArrayList<>();
        bosses.add(defender1);
        bosses.add(defender2);

        RandomGenerator randomGenerator;

        randomGenerator = new Random();

        int index = randomGenerator.nextInt(bosses.size());

        Enemy boss = bosses.get(index);
        System.out.println("Random boss: " + boss.getName());
        return boss;

    }


      /*  System.out.println(attacker.getFighterInformation());
        System.out.println(defender.getFighterInformation());


        //testing game
        battleService.attack(attacker, defender);
        battleService.attack(defender, attacker);
        battleService.specialAttack(attacker, defender);
        battleService.attack(defender, attacker);
        battleService.heal(attacker);
    }*/
}