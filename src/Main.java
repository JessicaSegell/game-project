public class Main {
    public static void main(String[] args) {
        BattleService battleService = new BattleService();
        Warrior attacker = new Warrior("Zygor", 100, 10);
        Enemy defender = new Enemy("Agdemenom the Atrociuos", 150, 15);

        System.out.println(attacker.getFighterInformation());
        System.out.println(defender.getFighterInformation());

        battleService.attack(attacker, defender);
    }
}