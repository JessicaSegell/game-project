package main;

public class Mage extends Fighter{
    public Mage(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
    }

    public int specialAttack(){
        return 25;
    }

    @Override
    public int attack() {
        int min = 8;
        int max = 17;

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
        return SpecialAttack.DEMONIC_EMBRACE.getSpecialAttack();
    }
}
