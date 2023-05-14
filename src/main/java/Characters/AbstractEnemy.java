package Characters;

public abstract class AbstractEnemy extends Caracter{


    public AbstractEnemy(int health, int defense, int accuracy, boolean living, String name) {
        super(health, defense, accuracy, living, name);
    }
}
