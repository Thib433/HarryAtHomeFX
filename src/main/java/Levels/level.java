package Levels;

import Attribute.Potion;
import Attribute.Spell;
import Tools.Console;
import Tools.SafeScanner;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

import java.util.List;

public abstract class level {
    //@Getter @Setter
    String name;

    private    int nPV;
    SafeScanner scanner = new SafeScanner();

    public Spell wichSpell(List<Spell> SpellList){//A completer !!, si il n'y a plus de Spell que le joeur demande

        Console.log("Choose a spell from the following list : ");
        for (int i = 0; i < SpellList.size(); i++) {
            System.out.println((i+1) + ". " + SpellList.get(i).getName());
        }
        int choice = scanner.getInt();
        while (choice < 1 || choice > SpellList.size()) {
            Console.log("Invalid choice. Please enter a number between 1 and " + SpellList.size());
            choice = scanner.getInt();
        }
        return SpellList.get(choice - 1);
    }

    public Potion wichPotion(List<Potion> PotionList){
        Timer timer = new Timer();

        Console.log("Choose a spell from the following list : [Enter an integer between 1 and "+PotionList.size()+"]");
        for (int i = 0; i < PotionList.size(); i++) {
            System.out.println((i+1) + ". " + PotionList.get(i).getName());
        }
        int choice = scanner.getInt();
        while (choice < 1 || choice > PotionList.size()) {
            Console.log("Invalid choice. Please enter a number between 1 and " + PotionList.size());
            choice = scanner.getInt();
        }
        Console.log(PotionList.get(choice-1).getName());
        return PotionList.get(choice - 1);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnPV() {
        return nPV;
    }

    public void setnPV(int nPV) {
        this.nPV = nPV;
    }

    public SafeScanner getScanner() {
        return scanner;
    }

    public void setScanner(SafeScanner scanner) {
        this.scanner = scanner;
    }
}
