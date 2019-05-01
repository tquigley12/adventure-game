package decorator;

public class Energized extends CharacterDecorator {

    public Energized(Character character) {
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
