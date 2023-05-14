package Levels;

import Attribute.Potion;
import Attribute.Spell;
import Characters.Enemy;
import Characters.Wizard;
import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
//import java.util.logging.Level;

public class Lev6 extends level {
    //@Getter
    //@Setter
    String name;
    //@Getter @Setter
    Wizard wizard;
    //@Getter @Setter
    Potion rewardPotion;
    //@Getter @Setter
    Spell rewardSpell;
    int effciency = new Random().nextInt(10)+1;


    //@Getter @Setter
    int nbMangemorts = new Random().nextInt(200);
    //@Getter @Setter
    int effciencyAttack = new Random().nextInt(3);
    //@Getter @Setter
    List<Enemy> Mangemorts;
    Timer timer = new Timer();

    public Lev6(String name, Wizard wizard, Potion rewardPotion, Spell rewardSpell, List<Enemy> mangemorts) {
        this.name = name;
        this.wizard = wizard;
        this.rewardPotion = rewardPotion;
        this.rewardSpell=rewardSpell;
        this.Mangemorts = mangemorts;
    }

    public List<Enemy> fillMangList(){
        Timer timer = new Timer();
        Console.log("Nb mangemorts");
        Console.logFloat(nbMangemorts);
        timer.getTime(1000);
        for (int i = 0; i < nbMangemorts; i++) {
            Enemy mangemort = new Enemy(100, 20, 0, true, "Mangemort"); //ou tout autre constructeur de Detraqueur
            Mangemorts.add(mangemort);
        }
        return Mangemorts;
    }
    public void attackMangemorts() {
        Mangemorts=fillMangList();
        int nbTry = 0;
        Console.log("Choose the good spell ! ");
        Spell spell = wichSpell(wizard.getKnownSpells());
        timer.getTime(1500);
        boolean isWinSpell = false;
        while (!isWinSpell) {
            isWinSpell=spell.trySpell(isWinSpell);
            //Test to know if the spell is success
        }
        boolean isAllDetDead = false;
        while (!isAllDetDead) {
            while(Mangemorts.size()>2){
                int powerSpell = spell.getPowerSpell();
                Console.log("Power");
                Console.logFloat(powerSpell);
                timer.getTime(1000);
                int damage = powerSpell+effciency;
                timer.getTime(1000);
                Console.log("Nb kills");
                Console.logFloat(damage);
                timer.getTime(1000);
                for (int i=1; i<=damage;i++){
                    if (Mangemorts.size()>2){
                        deadMembList(Mangemorts);
                    }
                }
                Console.log("There are "+Mangemorts.size()+" mangemors left ! Continue...");
                timer.getTime(1000);
                nbTry += 1;
            }
            isAllDetDead = true;
        }
        if (wizard.isLiving()) {
            if (nbTry < 4) {
                Console.log("What efficiency ! Congratuation " + wizard.getName());
                Console.log("You win 2 new basic potions : " + rewardPotion.getName());
                wizard.getPotionReward(rewardPotion);
                wizard.getPotionReward(rewardPotion);
                wizard.getSpellReward(rewardSpell);
                timer.getTime(2000);
                //Reward next Spell +  2 new Potion
            } else
            //if (nbTry == 2)
            {
                Console.log("What a game ! you are on the good way " + wizard.getName());
                Console.log("You win a new basic potions : " + rewardPotion.getName());
                wizard.getPotionReward(rewardPotion);
                wizard.getSpellReward(rewardSpell);
                timer.getTime(2000);
                //Reward next Spell + 1 new Potion
            }
//            else {
//                Console.log("You win the level ! Be more efficient the next time, you'll win more potion and chance to go far in the game  " + wizard.getName());
//                wizard.getSpellReward(rewardSpell);
//                //Reward next spell
//            }
        } else {
            Console.log("Oh no your didn't survive face to the Basilic :/");
            wizard.deathToStop();
        }
    }
    public void deadMembList(List<Enemy> listEnemy){
        listEnemy.remove(1);
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

    public int getNbMangemorts() {
        return nbMangemorts;
    }

    public void setNbMangemorts(int nbMangemorts) {
        this.nbMangemorts = nbMangemorts;
    }

    public int getEffciencyAttack() {
        return effciencyAttack;
    }

    public void setEffciencyAttack(int effciencyAttack) {
        this.effciencyAttack = effciencyAttack;
    }

    public List<Enemy> getMangemorts() {
        return Mangemorts;
    }

    public void setMangemorts(List<Enemy> mangemorts) {
        Mangemorts = mangemorts;
    }
}

