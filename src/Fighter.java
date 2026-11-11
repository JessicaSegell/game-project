abstract class Fighter implements FighterActions {
    private String name;
    private int health;
    //private int maxHealth;
    private int attackPower;

    public Fighter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        health = health - damage;
    }

    public String getFighterInformation() {
        return getFighterType() + " : " + getName() +
                " health: " + getHealth() +
                " attack power: " + getAttackPower() +
                " special attack: " + getSpecialAttack();
    }

}
