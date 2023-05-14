package Levels;

import Attribute.Potion;
import Attribute.Spell;
import Characters.Enemy;
import Characters.Wizard;
import Controleur.Game;
import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

public class Lev1 extends level {
    //@Getter @Setter
    String name;
    //@Getter @Setter
    Wizard wizard;
    //@Getter @Setter
    Enemy Troll ;
    //@Getter @Setter
    Spell rewardSpell;
    //@Getter @Setter
    Potion rewardPotion;

    public Lev1(Wizard wizard, Enemy troll, Spell rewardSpell, Potion rewardPotion, String name) {
        this.wizard = wizard;
        this.Troll = troll;
        this.rewardSpell = rewardSpell;
        this.rewardPotion = rewardPotion;
        this.name=name;
    }

    public void attackOnTroll(){
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
        boolean isTrolldead = false;
        while (!isTrolldead){
            Console.log("Attack !");
            int powerSpell= spell.getPowerSpell();
            float damage = wizard.attack(powerSpell, Troll);
            float result = Troll.defend(damage);
            isTrolldead = Troll.isDeadEnemy(result);
            timer.getTime(1000);
            nbTry+=1;
        }
        if (nbTry<=100){
            Console.log("What efficiency ! Congratuation "+ wizard.getName());
            timer.getTime(1500);
            Console.log("You win a new spell : " + rewardSpell.getName()+ " and 2 new basic potions : "+rewardPotion.getName());
            wizard.getSpellReward(rewardSpell);
            wizard.getPotionReward(rewardPotion);
            wizard.getPotionReward(rewardPotion);

            //Reward next Spell +  2 new Potion

        } else
            //if (nbTry>=4&&nbTry<6)
            {
            Console.log("What a game ! you are on the good way "+ wizard.getName());
            timer.getTime(1500);
            Console.log("You win a new spell : " + rewardSpell.getName()+ " and a new basic potions : "+rewardPotion.getName());
            wizard.getSpellReward(rewardSpell);
            //wizard.getPotionReward(rewardPotion);
            //Reward next Spell + 1 new Potion
        }
//        else{
//            Console.log("You win the level ! Be more efficient the next time, you'll win more potion and chance to go far in the game  "+ wizard.getName());
//            timer.getTime(1500);
//            Console.log("You win a new spell " +rewardSpell.getName());
//            wizard.getSpellReward(rewardSpell);
//            //Reward next spell
//        }
        timer.getTime(2000);
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

    public Enemy getTroll() {
        return Troll;
    }

    public void setTroll(Enemy troll) {
        Troll = troll;
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
}