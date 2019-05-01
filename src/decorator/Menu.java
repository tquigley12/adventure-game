package decorator;

import java.util.Random;

public class Menu {
    private Random randomNumber = new Random();
    private final int MAX_VALUE = 10;
    private final int MAX_STARVE_VALUE = 20;
    
public Menu() {

}

public void displayMenu() {
    System.out.println("Character options");
    System.out.println("");
    System.out.println("\ta. Read scroll");
    System.out.println("\tb. Eat food");
    System.out.println("\tc. Drink potion");
    System.out.println("\td. Exit campaign");
    System.out.println("");
    System.out.println("What do you do? ");
}

public boolean verifyAction(char action) {
    switch (action) {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
            return true;
        default:
            return false;
    }
}

public void displaySwordAdd() {
    System.out.println("");
    System.out.println("Do you wish to add a sword? (Y/N) ");
}

public void displaySpearAdd() {
    System.out.println("");
    System.out.println("Do you wish to add a spear? (Y/N) ");
}

public void displayShieldAdd() {
    System.out.println("");
    System.out.println("Do you wish to add a shield? (Y/N) ");
}

public boolean verifyYesOrNo(char action) {
    switch (action) {
        case 'Y':
        case 'N':
            return true;
        default:
            return false;
    }
}

public Character readScroll(Character basicCharacter) {
    Character returnCharacter = basicCharacter;
    int value;
    value = randomNumber.nextInt(MAX_VALUE) + 1;
    if (value >= 1 && value < 8) {
        returnCharacter = new Inspired(returnCharacter);
        System.out.println("You are inspired by the message of the scroll.  "
                + "Your might is increased by 5.  ");
    } else {
        returnCharacter = new Despaired(returnCharacter);
        System.out.println("The scroll has a devastating message, causing despair.  "
                + "Your might is decreased by 10.  ");
    }
    int starveValue;
    starveValue = randomNumber.nextInt(MAX_STARVE_VALUE) + 1;
    if (starveValue == 1) {
        returnCharacter = new Starving(returnCharacter);
        System.out.println("Remember to eat.  Your character is starving.  "
        + "Might is decreased by 10.  ");
    }
    return returnCharacter;
}

public Character eatFood(Character basicCharacter) {
    Character returnCharacter = basicCharacter;
    int value;
    value = randomNumber.nextInt(MAX_VALUE) + 1;
    if (value >= 1 && value < 8) {
        returnCharacter = new Energized(returnCharacter);
        System.out.println("The food has energized you.  "
                + "Your might is increased by 5.  ");
    } else {
        returnCharacter = new Poisoned(returnCharacter);
        System.out.println("The food is poisoned.  "
                + "Your might is decreased by 10.  ");
    }
    return returnCharacter;
}

public Character drinkPotion(Character basicCharacter) {
    Character returnCharacter = basicCharacter;
    int value;
    value = randomNumber.nextInt(MAX_VALUE) + 1;
    if (value >= 1 && value < 8) {
        returnCharacter = new Inspired(returnCharacter);
        System.out.println("You feel the healing effects of the potion.  "
                + "Your might is increased by 5.  ");
    } else {
        returnCharacter = new Despaired(returnCharacter);
        System.out.println("The potion is poisoned.  "
                + "Your might is decreased by 10.  ");
    }
    int starveValue;
    starveValue = randomNumber.nextInt(MAX_STARVE_VALUE) + 1;
    if (starveValue == 1) {
        returnCharacter = new Starving(returnCharacter);
        System.out.println("Remember to eat.  Your character is starving.  "
        + "Might is decreased by 10.  ");
    }
    return returnCharacter;
}

public void promptEnter() {
    System.out.println("");
    System.out.println("");
    System.out.println("Press enter for next option ");
}

}
