package H1;

import H1.Attacker;
import H1.Character;

import java.util.Random;

public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {
        System.out.print("Action: ");

        Random random = new Random();
        int randomNumber = random.nextInt(2);
        int damage = this.intelligence;

        //Randomizer loop with conditions
        if (randomNumber == 0 && mana >= 5) { // Heavy Attack
            System.out.println(getName() + " is Casting Fireball on " +character.getName()+"!" + " inflecting " + damage + " damage.");
            mana -= 5;
        } else if (randomNumber == 1) { //Staff
            damage = 2;
            System.out.println(getName() + " is Using Staff Hit on " +character.getName()+"!" + " inflecting " + damage + " damage.");
            mana += 1;
        } else { // No mana to cast Fireball or Staff hit
            damage = 0;
            System.out.println(getName() + " has no mana to cast a spell. Recovering mana by 2.");
            mana += 2;
        }

        character.setHp(character.getHp() - damage);

        if (character.getHp() <= 0) {
            character.setHp(0);
            character.setAlive(false);
        }

    }
}
