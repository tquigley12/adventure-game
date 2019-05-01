package decorator;

public class Inspired extends CharacterDecorator {

    public Inspired(Character character) {
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
