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

public class Lev3 extends level {
    //@Getter
    //@Setter
    String name;
    //@Getter @Setter
    Wizard wizard;
    //@Getter @Setter
    Potion rewardPotion;
    //@Setter @Getter
    Spell rewardSpell;

    int nbDetraqueurs = new Random().nextInt(100);
    int effciency = new Random().nextInt(10)+1;//à multiplier avec les PD du sort pour fumer plus ou moins efficacement les Detraqueurs et/ou nombre de Détraqueurs touché en même temps
    List<Enemy> Detraqueurs = new ArrayList<>();

    public Lev3(String name, Wizard wizard, Potion rewardPotion, List<Enemy> detraqueurs, Spell rewardSpell) {
        this.name = name;
        this.wizard = wizard;
        this.rewardPotion = rewardPotion;
        Detraqueurs = detraqueurs;
        this.rewardSpell=rewardSpell;
    }

    public List<Enemy> fillDetList(){
        Timer timer = new Timer();
        Console.log("Nb detraqueur");
        Console.logFloat(nbDetraqueurs);
        timer.getTime(1000);
        for (int i = 0; i < nbDetraqueurs; i++) {
            Enemy detraqueur = new Enemy(100, 20, 0, true, "Detraqueur"); //ou tout autre constructeur de Detraqueur
            Detraqueurs.add(detraqueur);
        }
        return Detraqueurs;
    }
    public void deadMembList(List<Enemy> listEnemy){

        listEnemy.remove(1);
    }

    public void attackDetraqueurs() {
        Timer timer = new Timer();
        Detraqueurs=fillDetList();
        int nbTry = 0;
        Console.log("Choose Expectro Patronum as spell ! ");
        Spell spell = wichSpell(wizard.getKnownSpells());
        timer.getTime(1500);
        Console.log("\"Now you have to learn it to rise yours chances to win the spell !\"");
        timer.getTime(1500);
        boolean wantStop =false;
        while(!wantStop){
            spell.setLuck(learnSpell(spell.getLuck()));
            Console.log("Spell luck to win is set to "+spell.getLuck());
            Console.log("Do you want to continue to learn your spell ? Yes (1) or Not (0)");
            int answer=scanner.getInt();
            if (answer==1){
                wantStop=false;
            }else{
                wantStop=true;
            }
        }
        boolean isWinSpell = false;
        while (!isWinSpell) {
            isWinSpell=spell.trySpell(isWinSpell);
            //Test to know if the spell is success
        }
        boolean isAllDetDead = false;
        while (!isAllDetDead) {
            while(Detraqueurs.size()>2){
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
                    if (Detraqueurs.size()>2){
                        deadMembList(Detraqueurs);
                    }
                }
                Console.log("There are "+Detraqueurs.size()+" dementors left ! Continue...");
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
    public int learnSpell(int luck){
        Timer timer =  new Timer();
        //Entrainement pour faire le sort, il retourne le pourcentage augmenté
        Console.log("Learning progressing ...");
        int random = new Random().nextInt(4)+1;
        timer.getTime(random*1000);
        int reward =luck*random;
        if (reward>=100){
            return 100;
        }else {
            return reward;
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

    public int getNbDetraqueurs() {
        return nbDetraqueurs;
    }

    public void setNbDetraqueurs(int nbDetraqueurs) {
        this.nbDetraqueurs = nbDetraqueurs;
    }

    public int getEffciency() {
        return effciency;
    }

    public void setEffciency(int effciency) {
        this.effciency = effciency;
    }

    public List<Enemy> getDetraqueurs() {
        return Detraqueurs;
    }

    public void setDetraqueurs(List<Enemy> detraqueurs) {
        Detraqueurs = detraqueurs;
    }
}
