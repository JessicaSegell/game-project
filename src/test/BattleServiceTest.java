package test;

import main.BattleService;
import main.Enemy;
import main.Fighter;
import main.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BattleServiceTest {

    private BattleService battleService;
    private Fighter attacker;
    private Fighter defender;

    @BeforeEach
    public void setup(){
        battleService  = new BattleService();
        attacker = new Warrior("Sygor", 150, 150);
        defender = new Enemy("remory", 200, 200);

    }

    @Test
    void attackShouldNotReduceHealthBelowZero(){
        defender.setHealth(5);

        battleService.attack(attacker, defender);

        assertEquals(0, defender.getHealth());
    }

    @Test
    void specialAttackShouldNotReduceHealthBelowZero(){
        defender.setHealth(5);
        battleService.specialAttack(attacker, defender);
        assertEquals(0, defender.getHealth());
    }

    @Test
    void healingShouldNotSetHealthAboveMaxHealth(){
        attacker.setHealth(145);
        battleService.heal(attacker);
        assertEquals(150, attacker.getHealth());
    }




}
