package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public abstract class Monster {

    private Integer hp;
    private Integer xp = 10;
    Integer agility = 10;
    Integer defense = 10;
    Integer strength = 10;
    Attack attack;
    private Integer maxHP;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    /**
     * This method returns an integer value between min and max.
     * This is goofy. rand.nextInt(n) returns a number between 0-n
     * to get the value we want, a value between str - maxStr,
     * We need to get a random number from maxStr-str and
     * add str back in.
     * @param min an integer
     * @param max an integer
     * @return a random integer between min and max
     */
    Integer getAttribute(Integer min, Integer max){
        Random rand = new Random();
        if(min > max){
            Integer temp = min;
            min = max;
            max = temp;
        }
        //returns a random number between min and max inclusive
        return rand.nextInt(max-min) + min;
    }

    public Integer attackTarget(Monster target){
        Integer damage = attack.attack(target);
        target.takeDamage(damage);

        return damage;
    }

    public boolean takeDamage(Integer damage){
        if(damage > 0){
            hp -= damage;
            System.out.println("The creature was hit for " + damage + " damage");
        }

        if(hp <= 0){
            System.out.println("Oh no! The creature has perished");
        }

        System.out.println(this.toString());

        if(hp > 0){
            return true;
        }else{
            return false;
        }
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getStrength() {
        return strength;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public String toString() {
        return "hp=" + hp + "/" + maxHP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp == monster.hp && xp == monster.xp && maxHP == monster.maxHP && Objects.equals(items, monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, maxHP, items);
    }
}
