package H1;

import java.util.Random;

import static java.lang.Character.getName;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {
        System.out.print("Action: ");

        Random random = new Random();
        int randomNumber = random.nextInt(2);
        int damage = this.strength;

        //Randomizer loop with conditions
        if (randomNumber == 0 && stamina >= 5) { // Heavy Attack
            System.out.println(getName() + " is Using Heavy Attack on " + character.getName() + "! inflecting "+ damage + " damage.");
            stamina -= 5;
        } else if (randomNumber == 1) { //Weak
            damage = this.strength/2;
            System.out.println(getName() + " is Using Weak Attack on " + character.getName() + "! inflecting "+ damage + " damage.");
            stamina += 1;
        } else { // No Stamina
            damage = 0;
            System.out.println(getName() + " is recovering stamina by 2.");
            stamina += 2;
        }

        character.setHp(character.getHp() - damage);

        if (character.getHp() <= 0) {
            character.setHp(0);
            character.setAlive(false);
        }
    }

}
