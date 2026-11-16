package main;

public class Main {
    public static void main(String[] args) {
        BattleService battleService = new BattleService();
        Warrior attacker = new Warrior("Zygor", 100, 100);
        Enemy defender = new Enemy("Agdemenon the Atrociuos", 150, 150);

        System.out.println(attacker.getFighterInformation());
        System.out.println(defender.getFighterInformation());


        //testing game
        battleService.attack(attacker, defender);
        battleService.attack(defender, attacker);
        battleService.specialAttack(attacker, defender);
        battleService.attack(defender, attacker);
        battleService.heal(attacker);
    }
}