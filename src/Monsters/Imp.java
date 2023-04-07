package Monsters;

import Abilities.MeleeAttack;

import java.util.HashMap;

public class Imp extends Monster {

    public Imp(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        super(maxHP, xp, items);
        //These should be stored in a HashMap
        //that way we can use an iterator.
        Integer maxStrength = 15;
        Integer maxDefense = 6;
        Integer maxAgility = 3;

        attack = new MeleeAttack(this);
        //This should use a data structure
        strength = super.getAttribute(strength, maxStrength);
        defense = super.getAttribute(defense, maxDefense);
        agility = super.getAttribute(agility, maxAgility);
    }

    @Override
    public String toString() {
        return "Monsters.Imp has : " + super.toString();
    }
}
