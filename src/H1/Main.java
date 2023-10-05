package H1;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //set random status
        int mana = (new Random().nextInt  ( 50 - 10 + 1) + 10);
        int intelligence = (new Random().nextInt  ( 50 - 1 + 1) + 1);

        int stamina = (new Random().nextInt  ( 50 - 10 + 1) + 10);
        int strength = (new Random().nextInt  ( 10 - 1 + 1) + 1);

        int WarriorHealth = (new Random().nextInt  (200 - 100 + 1 )+ 100);
        int WizardHealth = (new Random().nextInt  ( 100 - 50 + 1 ) + 50);

        Warrior warrior = new Warrior("Computer/Warrior", WarriorHealth, stamina, strength);
        Wizard wizard = new Wizard("Computer/Wizard", WizardHealth, mana, intelligence);

        Scanner scanner = new Scanner(System.in);

        String name;
        boolean p = true;
        int choice = choice(); //Switch cases
        while (p) {
            switch (choice) {
                case 1:
                    System.out.print("Enter your character name: ");
                    name = scanner.nextLine();
                    warrior.setName(name+"/Warrior");
                    p = false;
                    break;
                case 2:
                    System.out.print("Enter your character name: ");
                    name = scanner.nextLine();
                    wizard.setName(name+"/Wizard");
                    p = false;
                    break;
                case 3:

                    p = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    choice = choice();

            }
        }

        System.out.println();
        //scanner.close();

//print initial Stats
        System.out.println("Battle Begins!");
        System.out.println(warrior.getName() + " vs. " + wizard.getName()+"\n");
        System.out.println(warrior.getName() +" Strength = "+warrior.getStrength() +", " + wizard.getName()+" Intelligence = "+ wizard.getIntelligence());
        displayStats(warrior,wizard);

        while (warrior.isAlive() && wizard.isAlive()) {
            warrior.attack(wizard);
            wizard.attack(warrior);
            displayStats(warrior, wizard);
        }

        if (warrior.isAlive()) {
            System.out.println(warrior.getName() + " wins!");
        } else if (wizard.isAlive()) {
            System.out.println(wizard.getName() + " wins!");
        } else {
            System.out.println("It's a tie! Restarting the battle.");
            main(args);
        }

    }

    //Display health and stamina/mana after each round
    private static void displayStats(Character character1, Character character2) {
        System.out.println("--------Current Stats--------");
        System.out.println(character1.getName() + " - HP: " + character1.getHp() + " | Stamina/Mana: " +
                (character1 instanceof Warrior ? ((Warrior) character1).getStamina() : ((Wizard) character1).getMana()));
        System.out.println(character2.getName() + " - HP: " + character2.getHp() + " | Stamina/Mana: " +
                (character2 instanceof Warrior ? ((Warrior) character2).getStamina() : ((Wizard) character2).getMana()));
        System.out.println();
}
public static int choice(){ //accept input from the user
    Scanner scanner = new Scanner(System.in);
    System.out.println("Chose Your Character:");
    System.out.println("1. Warrior");
    System.out.println("2. Wizard");
    System.out.println("3. Start a Random battle");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

        return choice;
}

}
