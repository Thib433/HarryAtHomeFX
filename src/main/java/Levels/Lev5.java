package Levels;

import Attribute.Core;
import Attribute.Potion;
import Attribute.Spell;
import Attribute.object;
import Characters.Enemy;
import Characters.Wizard;
import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Random;
//import java.util.logging.Level;

public class Lev5 extends level {
    //@Getter @Setter
    String name;
    //@Getter @Setter
    Wizard wizard;
    //@Getter @Setter
    Enemy DoloresOmbrage;
    //@Getter @Setter
    Spell rewardSpell;
    //@Getter @Setter
    Potion rewardPotion;
    //@Setter
    //@Getter
    int progressFireworks =0; //Pourcentage de progression des deux feu d'artifices. Pendant ce temps, Dolores Ombrage jettes des sort dur le wizard

    //@Getter
    //@Setter
    int efficiencyFireworks ;
    Timer timer = new Timer();

    public Lev5(String name,Wizard wizard, Enemy doloresOmbrage, Spell rewardSpell, Potion rewardPotion) {
        this.wizard = wizard;
        DoloresOmbrage = doloresOmbrage;
        this.rewardSpell = rewardSpell;
        this.rewardPotion = rewardPotion;
        this.name=name;
    }

    public void createFireworks(Wizard wizard) {
        object fireworks = new object("fireworks", 35);
        wizard.getInventory().add(fireworks);
    }
    public void occupyDo(){
        int nbTry = 0;
        Console.log("This time you don't need to choose Spell ! Occupy the Dolore Ombrage when firework are in preparation !");
        getTime(1000);
        boolean areReady =false;
        while (!areReady){
            efficiencyFireworks= new Random().nextInt(3);
            Console.log("Efficiency Fireworks");
            Console.logFloat(efficiencyFireworks);
            getTime(1000);
            Console.log("Distrayez là ! ... FIREWORKS in PROGRESS ...");
            getTime(1000);
            float result;
            result = efficiencyFireworks*wizard.getAccuracy();
            Console.log("Result avancement");
            Console.logFloat(result);
            getTime(1000);
            progressFireworks+=result;
            Console.log("Progressing Fireworks");
            Console.logFloat(progressFireworks);
            getTime(1000);
            if (progressFireworks>=100){
                createFireworks(wizard);
                areReady=true;
            }else{
                Console.log("Fireworks aren't ready anymore ! Continue");
            }
        }
        boolean isDoDead = false;
        while(!isDoDead){
            Console.log("Attack !");
            getTime(2000);
            int power= wizard.getInventory().get(0).getPower();
            float damage = wizard.attack(power, DoloresOmbrage);
            float result = DoloresOmbrage.defend(damage);
            isDoDead=DoloresOmbrage.isDeadEnemy(result);
            nbTry+=1;
        }
        if (nbTry==1){
            Console.log("What efficiency ! Congratuation "+ wizard.getName());
            Console.log("You win a new spell : " + rewardSpell.getName()+ " and 2 new basic potions : "+rewardPotion.getName());
            wizard.getSpellReward(rewardSpell);
            wizard.getPotionReward(rewardPotion);
            wizard.getPotionReward(rewardPotion);

            //Reward next Spell +  2 new Potion

        } else if (nbTry==2) {
            Console.log("What a game ! you are on the good way "+ wizard.getName());
            Console.log("You win a new spell : " + rewardSpell.getName()+ " and a new basic potions : "+rewardPotion.getName());
            wizard.getSpellReward(rewardSpell);
            wizard.getPotionReward(rewardPotion);
            //Reward next Spell + 1 new Potion
        }else {
            Console.log("You win the level ! Be more efficient the next time, you'll win more potion and chance to go far in the game  " + wizard.getName());
            Console.log("You win a new spell " + rewardSpell.getName());
            wizard.getSpellReward(rewardSpell);
            //Reward next spell
        }
    }
    public void getTime(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

