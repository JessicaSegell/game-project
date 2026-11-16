package main;

public class Warrior extends Fighter {

    public Warrior(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
    }

    public int specialAttack(){
        return 20;
    }

    @Override
    public int attack() {
        int min = 5;
        int max = 15;

        return min + (int) (Math.random() * ((max - min) + 1));
    }

    @Override
    public String getFighterType(){
        return FighterType.HERO.getFighterType();
    }

    @Override
    public int heal() {
        return 10;
    }

    @Override
    public String getSpecialAttack() {
        return SpecialAttack.HAMMER_OF_JUSTICE.getSpecialAttack();
    }
}
