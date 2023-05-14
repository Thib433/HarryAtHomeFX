package Characters;

import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Random;

public abstract class Caracter {
    String name;
    float health; //Vie : entre 0 et 100 : à 0 le character est mort
     // Point de dégats ou d'attaque : puissance spécifique à chaque sort : entre 0 et 100;

    private float defense; //Point de défenses : 0 à 100, à aquérir pour le wizard
    private float accuracy; //Point de précision : 0 à 100, à aquérir
      boolean living;

    public Caracter(float health, float defense, float accuracy, boolean living, String name) {
        this.health = health;
        this.defense = defense;
        this.accuracy = accuracy;
        this.living = living;
        this.name=name;
    }

    public float attack(float powerSpell, Caracter targeted){

        float random = new Random().nextFloat(accuracy)+30;
        Timer timer = new Timer();
        float damage;
        float defense = targeted.getDefense();
        float efficiency = random;
//        Console.log("Spell Power");
//        Console.logFloat(powerSpell);
//        timer.getTime(2000);
//        Console.log("Enemy defense");
//        Console.logFloat(defense);
//        timer.getTime(2000);
//        Console.log("Accuracy");
//        Console.logFloat(accuracy);
//        timer.getTime(2000);
        Console.log("Efficiency of your knok of "+name);
        Console.logFloat(efficiency);
        timer.getTime(2000);
//        float inter1 = powerSpell*(accuracy/100);
//        Console.log("puissance * précision");
//        Console.logFloat(inter1);
//        timer.getTime(2000);
//        float inter2 = ((100-defense)/100);
//        Console.log("100-defense    / 100");
//        Console.logFloat(inter2);
//        timer.getTime(2000);
        damage = powerSpell*(efficiency/100)*((100-defense)/100);
        Console.log("Point of damage on "+targeted.getName());
        Console.logFloat(damage);
        timer.getTime(2000);
        return damage;
    }

    public float defend(float damage){
        Timer timer = new Timer();
        setHealth(health-damage);
        Console.log("Life of "+name+" is now");
        Console.logFloat(health);
        timer.getTime(2000);
        return health;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }
}
