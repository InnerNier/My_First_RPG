package main_files;

import java.util.Random;

public class Stats {

    String name;
    /**
     * Indicator of how strong the player or enemy is
     */
    int level;
    /**
     * "Hit Points". hp is not allowed to exceed this number
     */
    int maxHp;
    /**
     * The number that will lower when taking damage and rise when being healed,
     * <p>
     * not allowed to be below 0. Player or enemy will be defeated once it reaches 0
     */
    private int hp;
    /**
     * Will determine power of physical attacks
     */
    int strength;
    /**
     * Will determine power and resistance of magic attacks
     */
    int magic;
    /**
     * Will determine who goes first
     */
    int speed;
    /**
     * Will determine resistance of physical attacks
     */
    int defense;
    /**
     * Will determine if player can level up
     */
    int experience;
    final Random rand;

    public Stats(String name, int level, int maxHp, int strength, int magic, int speed, int defense) {
        this.maxHp = maxHp;
        this.hp = this.maxHp;
        this.defense = defense;
        this.level = level;
        this.name = name;
        this.strength = strength;
        this.magic = magic;
        this.speed = speed;
        this.experience = 0;
        this.rand = new Random();
    }

    public int calculateAttack(boolean isMagic) {
        if (isMagic) {
            return rand.nextInt(3) + magic;
        } else {
            return rand.nextInt(3) + strength;
        }
    }

    /**
     * lower current_hp
     * @param damage by how much
     *
     */
    public void takeDamage(int damage, boolean isMagic) {
        if (isMagic) {
            damage = damage - magic;
        } else {
            damage = damage - defense;
        }
        damage = Math.max(damage, 1);
        hp = hp - damage;
        hp = Math.max(hp, 0);
        System.out.println(name + " took " + damage + " damage");
    }

    /**
     * raises current_hp
     * @param heal by how much
     */
    public void healDamage(int heal) {
        hp = Math.clamp(getHp() + heal, 0, maxHp);
        System.out.println(name + " received heal of " + heal + " now at " + getHp() + " hp");
    }

    public void increaseExperience(int gainedExperience) {
        if (level == 10) {
            System.out.println("You are max level, so no experience for you");
            return;
        }
        experience = experience + gainedExperience;
        System.out.println("Gained " + gainedExperience + " experience points");
    }

    public boolean canLevelUp() {
        int[] milestones = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        if (level == 10) {
            return false;
        }
        return experience >= milestones[level - 1];
    }

    public void rest() {
        if (maxHp <= getHp()) {
            System.out.println("You are feeling fine, so decided not to rest right now");
            return;
        }
        hp = maxHp;
        System.out.println("You took a nice long rest and now your Current hp is now at max");
    }

    public void levelUp() {
        level = level + 1;
        maxHp = maxHp + rand.nextInt(5) + 1;
        hp = maxHp;
        strength = strength + rand.nextInt(3) + 1;
        magic = magic + rand.nextInt(3) + 1;
        speed = speed + rand.nextInt(3) + 1;
        defense = defense + rand.nextInt(3) + 1;
        System.out.println("You leveled up");
        System.out.println("Your level is now " + level);
        System.out.println("Your hp is now " + maxHp);
        System.out.println("Strength has increased to " + strength);
        System.out.println("Magic has increased to " + magic);
        System.out.println("Speed has increased to " + speed);
        System.out.println("Defense has increased to " + defense);
    }

    /**
     * The number that will lower when taking damage and rise when being healed,
     * <p>
     * not allowed to be below 0. Player or enemy will be defeated once it reaches 0
     */
    public int getHp() {
        return hp;
    }
}
