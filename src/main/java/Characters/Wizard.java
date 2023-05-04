package Characters;


import Attribute.House;
import Attribute.Potion;
import Attribute.Spell;
import Attribute.Wand;
import Attribute.object;

import java.util.List;

import Tools.Console;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;




public class Wizard extends Caracter{

    private  int level;


    Wand wand;
     Pet  pet;
     House house;
     List<Spell> knownSpells;
     List<Potion> potions;
     List<object> inventory;


    public Wizard(float health, float defense, float accuracy, boolean living, int level, String name, Wand wand, Pet pet, House house, List<Spell> knownSpells, List<Potion> potions, List<object> inventory) {
        super(health, defense, accuracy, living);
        this.level = level;
        this.name = name;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
        this.inventory = inventory;
    }

    public void getSpellReward(Spell reward){
        knownSpells.add(reward);
    }
    public void getPotionReward(Potion reward){
        potions.add(reward);
    }
    public void consumePotion(Potion potionConsumed){
        potions.remove(potionConsumed);
    }



    public boolean isDeadWizard(float health){
        if (health <=0){
            Console.log("oh no you're dead ! Game over");
            living = false;
            return true;
        }else{
            return false;
        }
    }

    public void printSpellList(List<Spell> listSpell){
        for (Spell element : listSpell) {
            String name = element.getName();
            Console.log(name);
        }
    }
    public void printPotionList(List<Potion> listPotion){
        for (Potion element : listPotion) {
            String name = element.getName();
            Console.log(name);
        }
    }

    public void usePotion(Potion potion){
        float reward = potion.getCurePoint();
        Timer timer = new Timer();
        if (health>=100){
            Console.log("Your life is already at his maximum");
        } else if (health>=100-reward && health<100) {
            setHealth(100);
            Console.log("Your life is now : "+health);
        } else{
            setHealth(health+reward);
            Console.log("Your life is now : "+health);
        }
        timer.getTime(1000);
    }
    public void deathToStop(){
        System.exit(0);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void setKnownSpells(List<Spell> knownSpells) {
        this.knownSpells = knownSpells;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public List<object> getInventory() {
        return inventory;
    }

    public void setInventory(List<object> inventory) {
        this.inventory = inventory;
    }
}
