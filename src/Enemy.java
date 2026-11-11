public class Enemy extends Fighter {
    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public String getFighterType(){
        return FighterType.ENEMY.getFighterType();
    }

    @Override
    public int heal() {
        return 10;
    }

    @Override
    public int attack() {
        int min = 5;
        int max = 15;

        return min + (int) (Math.random() * ((max - min) + 1));
    }

    @Override
    public String getSpecialAttack(){
        return SpecialAttack.DEMONIC_EMBRACE.getSpecialAttack();
    }
}
