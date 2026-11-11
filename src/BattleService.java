public class BattleService {

    public void attack(Fighter attacker, Fighter defender){
        int damage = attacker.attack();
        defender.takeDamage(damage);

        printAttackResults(attacker, defender, damage);

    }

    private void printAttackResults(Fighter attacker, Fighter defender, int damage){
        System.out.println(attacker.getName() + " attacked " + defender.getName());
        System.out.println("Damage: " + damage);
        System.out.println(attacker.getName() + " Hp: " + attacker.getHealth());
        System.out.println(defender.getName() + " Hp: " + defender.getHealth());

    }
}
