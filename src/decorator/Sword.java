package decorator;

public class Sword extends CharacterDecorator {

    public Sword(Character character) {
        super(character);
    }

    @Override
    public String getName() {
        return character.getName() + ", Sword-Wielder";
    }

    @Override
    public double getMight() {
        return character.getMight() + 10;
    }
}
