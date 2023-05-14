package Characters;

import Tools.Console;
//import lombok.Getter;
//import lombok.Setter;

public class Enemy extends Caracter{

    public Enemy(float health, float defense, float accuracy, boolean living, String name) {
        super(health, defense, accuracy, living, name);
    }

    public boolean isDeadEnemy(float health){
        if (health <=0){
            Console.log("Good game ! Your enemy is dead");
            return true;
        }else{
            return false;
        }
    }

}
