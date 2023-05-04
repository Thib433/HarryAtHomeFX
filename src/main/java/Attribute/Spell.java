package Attribute;

import Tools.Console;
import Tools.SafeScanner;
import Tools.Timer;
//import lombok.Getter;
//import lombok.Setter;

import java.util.List;
import java.util.Random;

public class Spell {
    private  String name;
    private int powerSpell;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerSpell() {
        return powerSpell;
    }

    public void setPowerSpell(int powerSpell) {
        this.powerSpell = powerSpell;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    private int luck; //percent of luck to win the spell
    SafeScanner scanner = new SafeScanner();


    public Spell(String name, int powerSpell, int luck) {
        this.name = name;
        this.powerSpell = powerSpell;

        this.luck = luck;
    }

    public boolean isWinSpell(int luck){
        Timer timer = new Timer();
        int random = new Random().nextInt(100)+1;
        if (random <= luck){
            Console.log("Yes ! you win your spell !!");
            timer.getTime(1000);
            return true;
        }else{
            Console.log("Spell lose ! :/ Try again !");
            return false;
        }
    }
    public boolean trySpell(boolean isWinSpell){
        Console.log("Try to success the spell ! type [go]");
        String go = scanner.getString();
        if (go.equals("go")){
            isWinSpell = isWinSpell(luck);
        }
        return isWinSpell;
    }




}
