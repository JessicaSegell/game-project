package main;


public abstract class Fighter implements FighterActions {
    private String name;
    private int health;

    private int maxHealth;

    public Fighter(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
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


    public void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int healAmount){

        health = health + healAmount;
        if(health > maxHealth){
            health = maxHealth;
        }
    }

    public String getFighterInformation() {
        return getFighterType() + " : " + getName() +
                " health: " + getHealth() +
                " special attack: " + getSpecialAttack();
    }

}
