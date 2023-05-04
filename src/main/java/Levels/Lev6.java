package Levels;

import Attribute.Potion;
import Attribute.Spell;
import Characters.Enemy;
import Characters.Wizard;
import Tools.Console;
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


    //@Getter @Setter
    int nbMangemorts = new Random().nextInt(50);
    //@Getter @Setter
    int effciencyAttack = new Random().nextInt(3);
    //@Getter @Setter
    List<Enemy> Mangemorts;

    public Lev6(String name, Wizard wizard, Potion rewardPotion, Spell rewardSpell, List<Enemy> mangemorts) {
        this.name = name;
        this.wizard = wizard;
        this.rewardPotion = rewardPotion;
        this.rewardSpell=rewardSpell;
        Mangemorts = mangemorts;
    }

    public List<Enemy> fillMangList(int nbMangemorts){
        for (int i = 0; i < nbMangemorts; i++) {
            Enemy mangemorts = new Enemy(100, 20, 0, true, "Mangemort"); //ou tout autre constructeur de Detraqueur
            Mangemorts.add(mangemorts);
        }
        return Mangemorts;
    }
    public void attackMangemorts() {
        Mangemorts=fillMangList(nbMangemorts);
        int nbTry = 0;
        Console.log("Choose Spell ! ");
        Spell spell = wichSpell(wizard.getKnownSpells());
        boolean isWinSpell = false;
        while (isWinSpell) {
            Console.log("Try to success the spell ! type [go]");
            String go = scanner.getString();
            if (Objects.equals(go, "go")){
                isWinSpell =spell.isWinSpell(spell.getLuck());
            }else isWinSpell = false;
            //Test to know if the spell is success
        }
        boolean isAllManDead = false;
        while (isAllManDead) {
            while(Mangemorts.size()>2){
                int powerSpell = spell.getPowerSpell();
                int damage = powerSpell*effciencyAttack;
                for (int i=1; i<=damage;i++){
                    deadMembList(Mangemorts);
                }
            }
            isAllManDead = true;
            nbTry += 1;
        }
        if (wizard.isLiving()) {
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
            }else{
                Console.log("You win the level ! Be more efficient the next time, you'll win more potion and chance to go far in the game  "+ wizard.getName());
                Console.log("You win a new spell " +rewardSpell.getName());
                wizard.getSpellReward(rewardSpell);
                //Reward next spell
            }

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

