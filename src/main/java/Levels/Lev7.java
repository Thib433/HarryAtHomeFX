package Levels;

import Attribute.Spell;
import Characters.Enemy;
import Characters.Wizard;
import Tools.Console;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Random;
//import java.util.logging.Level;

public class Lev7 extends level {
    //@Getter
    //@Setter
    String name;
    //@Getter @Setter
    Wizard wizard;

    //Voldemort peut à tout moment te péter d'un coup avec le sort Avada Kedavra si n'est pas prêt -> avoir bien développé sa défense
    //@Getter @Setter
    Enemy voldemort ;
    //@Getter @Setter
    Enemy bellatrixLestrange ;

    public Lev7(String name, Wizard wizard, Enemy voldemort, Enemy bellatrixLestrange) {
        this.name = name;
        this.wizard = wizard;
        this.voldemort = voldemort;
        this.bellatrixLestrange = bellatrixLestrange;
    }

    public void attackOnBasilic(){
        boolean isVolDead = false;
        boolean isBellDead = false;
        boolean isWizDead = false;
        while(isWizDead){
            while(isVolDead){
                while(isBellDead){
                    boolean isWinSpell;
                    Spell spell= wichSpell(wizard.getKnownSpells());
                    Console.log("You choose "+spell+ " as spell ! Let check if that's the good choice !");
                    isWinSpell = spell.isWinSpell(spell.getLuck());
                    if (isWinSpell==false){
                        Console.log("Spell loosed ! Try again after enemie's attack :/ Hope you'll not die !");
                    }else{
                        int powerSpell= spell.getPowerSpell();
                        float damageA = wizard.attack(powerSpell, bellatrixLestrange);
                        float result = bellatrixLestrange.defend(damageA);
                        isBellDead = bellatrixLestrange.isDeadEnemy(result);
                    }
                    //Bellatrix attack
                    float damageS = bellatrixLestrange.attack(25, wizard);
                    float resultS = wizard.defend(damageS);
                    isWizDead= wizard.isDeadWizard(resultS);
                }
                Console.log("You kill Bellatrix Lestrange ! But Voldemort is always inlive ! Kill him !");
                boolean isWinSpell2;
                Spell spell= wichSpell(wizard.getKnownSpells());
                Console.log("You choose "+spell+ " as spell ! Let check if that's the good choice !");
                isWinSpell2 = spell.isWinSpell(spell.getLuck());
                if (isWinSpell2==false){
                    Console.log("Spell loosed ! Try again after enemie's attack :/ Hope you'll not die !");
                }else{
                    float powerSpell= spell.getPowerSpell();
                    float damageA = wizard.attack(powerSpell, voldemort);
                    float result = voldemort.defend(damageA);
                    isBellDead = voldemort.isDeadEnemy(result);
                }
                //Bellatrix attack
                int range = new Random().nextInt(10);
                if (range==10){
                    isWizDead=true;
                }
            }
            Console.log("Congratulation !! You survived face to all the level and get the HarryAtHome diplome and win the game !");

        }
        Console.log("Oh no your didn't survive face to the Basilic :/");
        wizard.deathToStop();

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

    public Enemy getVoldemort() {
        return voldemort;
    }

    public void setVoldemort(Enemy voldemort) {
        this.voldemort = voldemort;
    }

    public Enemy getBellatrixLestrange() {
        return bellatrixLestrange;
    }

    public void setBellatrixLestrange(Enemy bellatrixLestrange) {
        this.bellatrixLestrange = bellatrixLestrange;
    }
}
