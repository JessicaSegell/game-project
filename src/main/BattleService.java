package main;

import javax.swing.*;

public class BattleService {

    public void attack(Fighter attacker, Fighter defender){
        int damage = attacker.attack();
        defender.takeDamage(damage);

        if(defender.getHealth() <= 0){
            defender.setHealth(0);
            System.out.println(defender.getName() + " has been defeated");
        }

        printAttackResults(attacker, defender, damage);

    }

    public void enemyAttack(Fighter attacker, Fighter defender, int turnCount){
        //attack
        //var tredje runda spec


    }

    //public boolean specialAttack = false;
    public void specialAttack(Fighter attacker, Fighter defender){
        //specialAttack = true;
        String specialAttack = attacker.getSpecialAttack();
        int damage = attacker.specialAttack();
        defender.takeDamage(damage);
        System.out.println(attacker.getName() + " used  " + specialAttack +
                " and dealt " + damage + " to " + defender.getName());
        System.out.println("Damage: " + damage);
        System.out.println(attacker.getName() + " Hp: " + attacker.getHealth());
        System.out.println(defender.getName() + " Hp: " + defender.getHealth());
    }

    public void heal(Fighter attacker){
        attacker.heal(10);
        printHealResult(attacker);
    }

    private void printHealResult(Fighter attacker){
        System.out.println(attacker.getName() + " healed 10 HP. New HP: " + attacker.getHealth());
    }

    private void printAttackResults(Fighter attacker, Fighter defender, int damage){

        JOptionPane.showMessageDialog(null,
                attacker.getName() + " dealt " + damage + " to " + defender.getName());

        System.out.println(attacker.getName() + " attacked " + defender.getName());
        System.out.println("Damage: " + damage);
        System.out.println(attacker.getName() + " Hp: " + attacker.getHealth());
        System.out.println(defender.getName() + " Hp: " + defender.getHealth());

    }
}
