package Levels;

import Attribute.Potion;
import Attribute.Spell;
import Characters.Enemy;
import Characters.Wizard;
import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

//import java.util.logging.Level;

public class Lev2 extends level {

    //@Getter @Setter
    String name;
    //@Getter @Setter
    Enemy Basilic ;
    //@Getter @Setter
    Wizard wizard;
    //@Getter @Setter
    Potion rewardPotion;
    //@Getter @Setter
    Spell rewardSpell;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Enemy getBasilic() {
        return Basilic;
    }

    public void setBasilic(Enemy basilic) {
        Basilic = basilic;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Potion getRewardPotion() {
        return rewardPotion;
    }

    public void setRewardPotion(Potion rewardPotion) {
        this.rewardPotion = rewardPotion;
    }

    public Spell getRewardSpell() {
        return rewardSpell;
    }

    public void setRewardSpell(Spell rewardSpell) {
        this.rewardSpell = rewardSpell;
    }

    public Lev2(String name, Enemy basilic, Wizard wizard, Potion rewardPotion, Spell rewardSpell) {
        this.name = name;
        Basilic = basilic;
        this.wizard = wizard;
        this.rewardPotion = rewardPotion;
        this.rewardSpell = rewardSpell;
    }

    public void attackOnBasilic(){
        Timer timer = new Timer();
        timer.getTime(1000);
        int nbTry = 0;
        Spell spell= wichSpell(wizard.getKnownSpells());
        Console.log("You choose "+spell.getName()+ " as spell ! Let check if that's the good choice !");
        boolean isWinSpell = false;
        while(!isWinSpell){
            isWinSpell=spell.trySpell(isWinSpell);
            nbTry+=1;
        }
        boolean isBasdead = false;
        boolean isDeadWizard = false;
        while (!isBasdead && !isDeadWizard){
            float powerSpell= spell.getPowerSpell();
            float damageA = wizard.attack(powerSpell, Basilic);
            float result = Basilic.defend(damageA);
            isBasdead = Basilic.isDeadEnemy(result);
            //Basilic attack too
            float damageS = Basilic.attack(15, wizard);
            float resultS = wizard.defend(damageS);
            isDeadWizard= wizard.isDeadWizard(resultS);
            nbTry+=1;
        }
        if (wizard.isLiving()){
            if (nbTry<=3){
                Console.log("What efficiency ! Congratuation "+ wizard.getName());
                Console.log("You win 2 new basic potions : "+rewardPotion.getName());
                wizard.getPotionReward(rewardPotion);
                wizard.getPotionReward(rewardPotion);
                wizard.getSpellReward(rewardSpell);
                timer.getTime(2000);
                //Reward next Spell +  2 new Potion
            }
//            else if (nbTry>=4&&nbTry<6) {
//                Console.log("What a game ! you are on the good way "+ wizard.getName());
//                Console.log("You win a new basic potions : "+rewardPotion.getName());
//                wizard.getPotionReward(rewardPotion);
//                wizard.getSpellReward(rewardSpell);
//                //Reward next Spell + 1 new Potion
//            }
            else{
                Console.log("You win the level ! Be more efficient the next time, you'll win more potion and chance to go far in the game  "+ wizard.getName());
                //Reward next spell         //Obligfé de lui donner au minimum un sors utile sinon il peut pas avancer
                //Sinon niveau 2 validé
                wizard.getSpellReward(rewardSpell);
                timer.getTime(2000);
            }
        }else {
            Console.log("Oh no your didn't survive face to the Basilic :/");
            wizard.deathToStop();
        }

    }

}
