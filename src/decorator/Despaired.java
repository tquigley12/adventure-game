package decorator;

public class Despaired extends CharacterDecorator {

    public Despaired(Character character) {
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
