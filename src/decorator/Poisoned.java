package decorator;

public class Poisoned extends CharacterDecorator {

    public Poisoned(Character character) {
        super(character);
    }

    @Override
    public String getName() {
        return character.getName();
    }

    @Override
    public double getMight() {
        return character.getMight() - 10;
    }
}
