package Attribute;

        //import lombok.Getter;
        //import lombok.Setter;

public abstract class AbstractSpell {
    private int damage;
    private  String name;
    private  int accuracy;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public AbstractSpell(int damage, String name, int accuracy) {
        this.damage = damage;
        this.name = name;
        this.accuracy = accuracy;
    }


}
