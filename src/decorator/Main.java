package decorator;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 * 
 * This is the main driver class for a basic adventure game.  To embark on a campaign,
 * the adventurer first chooses a name and then chooses items to equip (sword, spear and shield).  
 * Then the campaign begins.
 * 
 * From that point forward, the character must periodically choose 1 of the following 3 options:
 * 1)  Read scroll
 * 2)  Eat food
 * 3)  Drink potion
 * 4)  Exit campaign
 * 
 * If the character exits the campaign, the game ends and the character's might is displayed.
 * By choosing any of the other 3 options, the character will continue the campaign
 * and his/ her might will either increase or decrease depending on a randomly 
 * generated result.  The logic is as follows:
 * 
 * Read scroll
 *      Increase might by 5 if Inspired
 *      Decrease might by 10 if Despaired
 * 
 * Eat food
 *      Increase might by 5 if Energized
 *      Decrease might by 10 if Poisoned
 * 
 * Drink potion
 *      Increase might by 5 if Healed
 *      Decrease might by 10 if Poisoned
 * 
 * The results that increase might are more likely than the results that decrease might.
 * The character will perish when his/ her might is reduced to 0 or below.
 * 
 * There is an ancillary factor to consider as well.  When the character chooses either
 * "read scroll" or "drink potion", there is a random chance that he/ she will begin
 * to starve.
 * 
 * @author tquigley1
 */
public class Main {

    public static void main(String[] args) {
        boolean endUserLoop = false;
        boolean validAction = false;
        boolean validInput = false;
        char action;
        String characterName;
        
        //Character basicCharacter = new Spear(new Sword(new BasicCharacter("Bilbo")));
        //System.out.println("Name: " + basicCharacter.getName());
        //System.out.println("Might: " + basicCharacter.getMight());
        
        // Create a keyboard Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        // Instantiate menu object to provide methods for management of the campaign
        Menu menu = new Menu();
        
        // Initial display messages and prompt for user name
        System.out.println("You are about to embark on an adventure.  What is your name? ");
        characterName = keyboard.nextLine();
        
        Character basicCharacter = new BasicCharacter(characterName);
        
        // Prompt the character to equip items 
        menu.displaySwordAdd();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        validAction = menu.verifyYesOrNo(action);
        while (!validAction) {
            System.out.println("Invalid action.  Please re-enter. ");
            menu.displaySwordAdd();
            action = toUpperCase(keyboard.nextLine().charAt(0));
            validAction = menu.verifyYesOrNo(action);
        }
        switch (action) {
            case 'Y':
                basicCharacter = new Sword(basicCharacter);
                break;
            case 'N':
                break;
        }
        
        menu.displaySpearAdd();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        validAction = menu.verifyYesOrNo(action);
        while (!validAction) {
            System.out.println("Invalid action.  Please re-enter. ");
            menu.displaySpearAdd();
            action = toUpperCase(keyboard.nextLine().charAt(0));
            validAction = menu.verifyYesOrNo(action);
        }
        switch (action) {
            case 'Y':
                basicCharacter = new Spear(basicCharacter);
                break;
            case 'N':
                break;
        }
        
        menu.displayShieldAdd();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        validAction = menu.verifyYesOrNo(action);
        while (!validAction) {
            System.out.println("Invalid action.  Please re-enter. ");
            menu.displayShieldAdd();
            action = toUpperCase(keyboard.nextLine().charAt(0));
            validAction = menu.verifyYesOrNo(action);
        }
        switch (action) {
            case 'Y':
                basicCharacter = new Shield(basicCharacter);
                break;
            case 'N':
                break;
        }
        
        
        // Loop to display menu and process user commands
        do {
            menu.displayMenu();
            action = toUpperCase(keyboard.nextLine().charAt(0));
            validAction = menu.verifyAction(action);
            while (!validAction) {
                System.out.println("Invalid action.  Please re-enter. ");
                menu.displayMenu();
                action = toUpperCase(keyboard.nextLine().charAt(0));
                validAction = menu.verifyAction(action);
            }
            switch (action) {
                case 'A':       // Read scroll
                    basicCharacter = menu.readScroll(basicCharacter);
                    break;
                case 'B':       // Eat food
                    basicCharacter = menu.eatFood(basicCharacter);
                    break;
                case 'C':       // Drink potion
                    basicCharacter = menu.drinkPotion(basicCharacter);
                    break;
                case 'D':       // Exit campaign
                    endUserLoop = true;
                    break;
            }
            if (basicCharacter.getMight() <= 0) {
                endUserLoop = true;
            }
            
            if (!endUserLoop) {
                menu.promptEnter();
                keyboard.nextLine();
            }
        } while (!endUserLoop);
        
        if (basicCharacter.getMight() <= 0) {
            System.out.println("");
            System.out.print(basicCharacter.getName());
            System.out.println("  you have perished. ");
            System.out.println("Your might is: " + basicCharacter.getMight());
        } else {
            System.out.println("");
            System.out.print(basicCharacter.getName());
            System.out.println("  best of luck in your future ventures. ");
            System.out.println("Your might is: " + basicCharacter.getMight());
        }
        
    }
}
