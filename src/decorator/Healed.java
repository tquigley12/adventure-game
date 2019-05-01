package decorator;

public class Healed extends CharacterDecorator {

    public Healed(Character character) {
        super(character);
    }

    @Override
    public String getName() {
        return character.getName();
    }

    @Override
    public double getMight() {
        return character.getMight() + 5;
    }
}
