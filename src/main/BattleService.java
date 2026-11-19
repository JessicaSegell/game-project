package main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class BattleService {

    TurnCounter turn = new TurnCounter(0);

    public void heroTurn(Fighter hero, Fighter enemy) {
        Scanner scanner = new Scanner(System.in);

        int turnCounter = turn.getTurnCount();
        System.out.println("AFTR SET: " + turnCounter + " " + turn.turnCount);

        String heroStats = "---" + hero.getName() + " HP: " + hero.getHealth() + "---";
        String enemyStats = "---" + enemy.getName() + " HP: " + enemy.getHealth() + "---";

        System.out.println(heroStats + "\n" + enemyStats);
        System.out.println("Choose an option");
        if (turnCounter < 3) {
            System.out.println("1. Attack");

            int result = scanner.nextInt();
            switch (result) {
                case 1:
                    attack(hero, enemy);
                    turnCounter++;
                    break;
            }
            turn.setTurnCount(turnCounter);
        }
        if (turnCounter >= 3) {
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Special Attack");

            int result = scanner.nextInt();
            switch (result) {
                case 1:
                    attack(hero, enemy);
                    turnCounter++;
                    break;
                case 2:
                    heal(hero);
                    turnCounter = turn.setTurnCount(0);
                    break;
                case 3:
                    specialAttack(hero, enemy);
                    turnCounter = turn.setTurnCount(0);
                    break;
            }
            turn.setTurnCount(turnCounter);
        }

        if ((enemy.getHealth()) == 0) {
            gameOver(hero);

        } else {
            enemyTurn(enemy, hero);
        }

    }

    static Enemy generateBoss() {
        Enemy defender1 = new Enemy("Agdemenon the Atrociuos", 150, 150);
        Enemy defender2 = new Enemy("Tengel the Terrible", 125, 125);
        Enemy defender3 = new Enemy("Francis the Feeble", 100, 100);

        List<Enemy> bosses = new ArrayList<>();
        bosses.add(defender1);
        bosses.add(defender2);
        bosses.add(defender3);

        RandomGenerator randomGenerator;

        randomGenerator = new Random();

        int index = randomGenerator.nextInt(bosses.size());

        Enemy boss = bosses.get(index);
        System.out.println("Random boss: " + boss.getName());
        return boss;
    }

    public void attack(Fighter attacker, Fighter defender) {
        int damage = attacker.attack();
        defender.takeDamage(damage);

        if (defender.getHealth() <= 0) {
            defender.setHealth(0);
            System.out.println(defender.getName() + " has been defeated");
        }

        printAttackResults(attacker, defender, damage);

    }

    public void enemyTurn(Fighter enemy, Fighter hero) {
        System.out.println("IN ENEMY ATTACK");
        attack(enemy, hero);

        if ((hero.getHealth() == 0)) {
            gameOver(enemy);
        } else {
            heroTurn(hero, enemy);
        }
        //attack
        //var tredje runda spec
    }

    public void specialAttack(Fighter attacker, Fighter defender) {
        String specialAttack = attacker.getSpecialAttack();
        int damage = attacker.specialAttack();
        defender.takeDamage(damage);

        System.out.println("SPEC TURNSET: " + turn.turnCount + " " + turn.getTurnCount());
        System.out.println(attacker.getName() + " used  " + specialAttack +
                " and dealt " + damage + " to " + defender.getName());
        System.out.println("Damage: " + damage);
        System.out.println(attacker.getName() + " Hp: " + attacker.getHealth());
        System.out.println(defender.getName() + " Hp: " + defender.getHealth());
    }

    public void heal(Fighter attacker) {
        attacker.heal(10);
        printHealResult(attacker);
    }

    private void printHealResult(Fighter attacker) {
        System.out.println(attacker.getName() + " healed 10 HP. New HP: " + attacker.getHealth());
    }

    private void printAttackResults(Fighter attacker, Fighter defender, int damage) {

        System.out.println("-->" + attacker.getName() + " ATTACKED " + defender.getName());
        System.out.println("Damage: " + damage);
        System.out.println(attacker.getName() + " Hp: " + attacker.getHealth());
        System.out.println(defender.getName() + " Hp: " + defender.getHealth());
        System.out.println("PRINT COUNT: " + turn.getTurnCount());

    }

    private void gameOver(Fighter winner) {

        System.out.println("The winner is: " + winner.getName());

    }
}
