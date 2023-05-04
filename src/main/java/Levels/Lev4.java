package Levels;

import Attribute.Potion;
import Attribute.Spell;
import Characters.Enemy;
import Characters.Wizard;
import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

//import java.awt.*;
import java.util.Objects;
import java.util.Random;
//import java.util.logging.Level;

public class Lev4 extends level {
    //@Getter @Setter
    String name;
   // @Getter @Setter
    Wizard wizard;
    //@Getter @Setter
    Spell rewardSpell;
    //@Getter @Setter
    Potion rewardPotion;

    //@Getter @Setter int range = new Random().nextInt(30)+10;// Distance entre Wizard et le Portekeys dans le cimetière
    //@Getter @Setter
    int distance;
    //@Getter @Setter
    Enemy Voldemorts ;
    //@Getter @Setter
    Enemy Pettigrow ;
    Timer timer = new Timer();

    public Lev4(String name, Wizard wizard, Spell rewardSpell, Potion rewardPotion, int distance, Enemy voldemorts, Enemy pettigrow) {
        this.name = name;
        this.wizard = wizard;
        this.rewardSpell = rewardSpell;
        this.rewardPotion = rewardPotion;
        this.distance = distance;
        Voldemorts = voldemorts;
        Pettigrow = pettigrow;
    }

    public float bringPortkey(Spell accio){
        int multRange = new Random().nextInt(5)+1;
        float newDistance = accio.getPowerSpell()+multRange;

        return newDistance;
    }
    public boolean isOut(int distance){
        if (distance>0){
            Console.log("The exit got closer, but try again next turn to exit as fast as possible!");
            return false;
        }else{
            return true;
        }
    }

    public void fleeGraveyard(){
        int nbTry = 0;
        Console.log("Choose Accio as spell to bring closer the Portkey to flee Voldemort and Pettigrow ! ");
        Spell spell = wichSpell(wizard.getKnownSpells());
        timer.getTime(1000);
        boolean isWinSpell = false;
        while(!isWinSpell){
            isWinSpell=spell.trySpell(isWinSpell);
            //Test to know if the spell is success
        }
        boolean flee = false;
        boolean isDeadWizard = false;
        while (!flee
                && !isDeadWizard)
        {
            //Exit attempt
            float bring = bringPortkey(spell);
            Console.log("bring");
            Console.logFloat(bring);
            timer.getTime(1500);
            distance-=bring;
            Console.log("New distance");
            Console.logFloat(distance);
            timer.getTime(1500);
            flee=isOut(distance);
            //Voldemort and Pettigrow attack
            float damageV = Voldemorts.attack(20, wizard);
            float damageP = Pettigrow.attack(10, wizard);
            float result = wizard.defend(damageV);
            result=wizard.defend(damageP);
            isDeadWizard= wizard.isDeadWizard(result);
            nbTry+=1;
        }
        if (wizard.isLiving()) {
            if (nbTry==1){
                Console.log("What efficiency ! Congratuation "+ wizard.getName());
                Console.log("You win a new spell : " + rewardSpell.getName()+ " and 2 new basic potions : "+rewardPotion.getName());
                wizard.getSpellReward(rewardSpell);
                wizard.getPotionReward(rewardPotion);
                wizard.getPotionReward(rewardPotion);
                timer.getTime(1000);

                //Reward next Spell +  2 new Potion

            } else
                //if (nbTry==2)
                {
                Console.log("What a game ! you are on the good way "+ wizard.getName());
                Console.log("You win a new spell : " + rewardSpell.getName()+ " and a new basic potions : "+rewardPotion.getName());
                wizard.getSpellReward(rewardSpell);
                wizard.getPotionReward(rewardPotion);
                timer.getTime(1000);
                //Reward next Spell + 1 new Potion
            }
//            else{
//                Console.log("You win the level ! Be more efficient the next time, you'll win more potion and chance to go far in the game  "+ wizard.getName());
//                Console.log("You win a new spell " +rewardSpell.getName());
//                wizard.getSpellReward(rewardSpell);
//                //Reward next spell
//
//            }
        }else {
            Console.log("Oh no your didn't survive face to Voldemort and Pettigrow :/");
            wizard.deathToStop();
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Spell getRewardSpell() {
        return rewardSpell;
    }

    public void setRewardSpell(Spell rewardSpell) {
        this.rewardSpell = rewardSpell;
    }

    public Potion getRewardPotion() {
        return rewardPotion;
    }

    public void setRewardPotion(Potion rewardPotion) {
        this.rewardPotion = rewardPotion;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Enemy getVoldemorts() {
        return Voldemorts;
    }

    public void setVoldemorts(Enemy voldemorts) {
        Voldemorts = voldemorts;
    }

    public Enemy getPettigrow() {
        return Pettigrow;
    }

    public void setPettigrow(Enemy pettigrow) {
        Pettigrow = pettigrow;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
