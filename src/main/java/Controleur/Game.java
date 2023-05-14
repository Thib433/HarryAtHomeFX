package Controleur;

import Attribute.*;
import Characters.Enemy;
import Characters.Pet;
import Characters.Wizard;
import Levels.*;
import Tools.Console;
import Tools.SafeScanner;
import Tools.SortingHat;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //Pour interface graphique, stocker le nom choisi directement
    String nameChoice;
    Lev1 lev1;
    Lev2 lev2;
    Lev3 lev3;
    Lev4 lev4;
    Lev5 lev5;
    Lev6 lev6;
    Lev7 lev7;
    int lev;

    Wizard wizard ;
    String playerName;
    Wand wand;
    Pet pet;
    House house;

    //Potions
    List<Potion> potions = new ArrayList<>();
    Potion skeleGro ;
    Potion essence ;
    Potion draughtDeath ;


    //Spells

    List<Spell> SpellKnowns = new ArrayList<>();
    Spell wingLev ;
    Spell accio ;
    Spell expPatro ;
    Spell sectum ;
    Spell avaKada ;
    Spell expellia;
    List<object> inventory = new ArrayList<>();

    //Enemy
    Enemy troll;
    Enemy Basilic;
    List<Enemy> Detraqueurs = new ArrayList<>();
    Enemy Voldemorts;
    Enemy Pettigrow;
    Enemy DoloresOmbrage;
    List<Enemy> Mangemorts = new ArrayList<>();
    Enemy bellatrixLestrange;
    private SafeScanner scanner = new SafeScanner();

    public void play(){ //Funciton who start the game
        //Start of the Game
        while (true){
            startAssignement();     //Ok
            while (!wizard.isDeadWizard(wizard.getHealth())){
                //year1(wizard);
                //year2(wizard);
                //year3(wizard);
                //year4(wizard);
                year5(wizard);
                year6(wizard);
                year7(wizard);
            }
            Console.log("Game over ! Try again ;)");
        }
    }
    public void year1(Wizard wizard){ //Instantiating each level class
        Console.log("Welcome to the first level : The Philosopher's Stone !!");
        getTime(1300);
        troll = new Enemy(100, 20, 0, true, "Troll");
        Console.log("You have to face the evil Troll who is in the toilets next to the Dungeon.\n" +
                "To win, you must lift objects and release them when they are above his head using the GOOD SPELL !.");
        lev1 = new Lev1(wizard, troll, accio, skeleGro, "The Philosopher’s Stone");
        getTime(1000);
        lev1.attackOnTroll();
        endLevel(lev1);
    }
    public void year2(Wizard wizard){//Instantiating each level class
        Console.log("Welcome to the second level : The Chamber of Secrets\n");
        getTime(1000);
        Basilic= new Enemy(100, 25, 5, true, "Basilic");
        Console.log("You are facing the terrible basilisk !");
        getTime(1000);
        Console.log("Use Basilisk Fangs with Accio");
        getTime(1500);
        lev2 = new Lev2("The Chamber of Secrets", Basilic, wizard, skeleGro, expPatro);
        getTime(1000);
        lev2.attackOnBasilic();
        endLevel(lev2);
    }
    public  void year3(Wizard wizard){
        Console.log("Welcome to the 3 rd level : The Prisonner of Azkaban");
        getTime(1000);
        Console.log("Lake of the Forbidden Forest");
        getTime(1000);
        Console.log("The countryside is bombarded with Dementors! Use your Patronus to put the Dementors " +
                "on the run !");
        getTime(1000);
        lev3=new Lev3("The Prisonner of Azkaban", wizard, skeleGro, Detraqueurs,expPatro);
        lev3.attackDetraqueurs();
        endLevel(lev3);
    }
    public void year4(Wizard wizard){
        Console.log("Welcome to the 4th : The Goblet of Fire");
        getTime(2000);
        Console.log("Unfortunately, you won the Triwizard Tournament... and the right to die. You are\n" +
                "in a cemetery, where Voldemort and Peter Pettigrew are also. Your only chance of escape is\n" +
                "to approach the Portkey to attract it to you (Accio!). Don't worry, you'll see again\n" +
                "Flight of death");
        getTime(4500);
        Voldemorts = new Enemy(100, 80, 20, true, "Voldemort");
        Pettigrow = new Enemy(100, 60, 20, true, "Pettigrow");
        lev4= new Lev4("The Goblet of Fire", wizard, sectum, essence, 100, Voldemorts, Pettigrow);
        lev4.fleeGraveyard();
        endLevel(lev4);
    }
    public void year5(Wizard wizard){
        Console.log("The Order of the Phenix");
        getTime(2000);
        DoloresOmbrage = new Enemy(100, 30, 20, true, "Dolores Ombrage");
        Console.log("It's time for the OWL (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge watches over\n" +
                "the seed. Your goal is to distract her until the fireworks are ready to go.");
        getTime(4500);
        lev5=new Lev5("The Order of the Phenix", wizard, DoloresOmbrage, sectum, essence);
        lev5.occupyDo();
        endLevel(lev5);
    }
    public void year6(Wizard wizard){
        Console.log("The Half-Blood Prince");
        getTime(2000);
        lev6=new Lev6("The Half-Blood Prince", wizard, essence, expellia,Mangemorts);
        Console.log("Kill all the mangemorts !...");
        getTime(2000);
        lev6.attackMangemorts();
        endLevel(lev6);
    }
    public  void year7(Wizard wizard){
        Console.log("The Deathly Hallows\n");
        getTime(2000);
        Console.log("There are still your two worst enemies! Kill them all !");
        getTime(2000);
        Voldemorts = new Enemy( 100, 50, 60, true, "Voldemort");
        bellatrixLestrange =  new Enemy(100, 30, 50, true, "Bellatrix Lestrange");
        lev7 = new Lev7("The Deathly Hallows\n", wizard, Voldemorts, bellatrixLestrange);
        lev7.attackOnBasilic();
        Console.log("Congratulation !! You survived face to all the level and get the HarryAtHome diplome and win the game !");

    }
    public void endLevel(level level){ //End of all level
        Console.log("Congratulation ! You successfully survived to the level " +level.getName());
        getTime(1500);
        Console.log("You now have these potions in your bag : ");
        wizard.printPotionList(potions);
        getTime(1500);
        Console.log("You can now consume one Potion ! Please choose now the potion you want !");
        getTime(1000);
        Potion potionConsumed = level.wichPotion(potions);
        getTime(1000);
        wizard.consumePotion(potionConsumed);//Afficher la vie restante
        wizard.usePotion(potionConsumed);
    }
    public void startAssignement(){ //Message to start
        Console.log(wizard.getName() + ", your bag is ready !");
        getTime(800);
        Console.log("Your wizard's name is " + wizard.getName()+ ". You will studie to the house : "+wizard.getHouse());
        getTime(800);
        Console.log("Your bag is completed by portions and spell and has to be completed during your schooling to be able to survive your 7 years of survival");
        getTime(800);
        Console.log("Are you ready ? ");
        getTime(1500);
    }
    public void initializeSpell(){ //Initialisation of all the wizard's need
        wingLev = new Spell("Wingardium Leviosa", 50, 60);
        accio = new Spell("Accio", 25,  50);
        expPatro = new Spell("Expectro Patronum", 25,  15);
        sectum = new Spell("Sectumsempra", 50, 40);
        avaKada = new Spell("Avada Kevadra",40, 70);
        expellia = new Spell("expelliarum", 40, 75);
    }
    public void initializeInventory(){
        Console.log("You have an inventory to complete");
        getTime(300);
    }
    public void initializeHouse(){
        Console.log("Your house will now be raffled ! Wait a second ...");
        //getTime(1000);
        SortingHat sortingHat = new SortingHat();
        house = sortingHat.attributeHouse(house);
        Console.log("Your new House is :" + house.toString());
        //getTime(300);
        //Console.log(house.name());
    }
    public Wizard createNewWizard(int level, String name, Wand wand, Pet pet, House house, List<Spell> Spellknowns, List<Potion> potions, int health, int defense, int accuracy, boolean living, List<object> inventory){ //create the new wizard with all the parametters

        wizard  = new Wizard( health, defense, accuracy, living, level, name, wand, pet, house, Spellknowns, potions, inventory);
        return wizard;
    }
    public void createListSpells(Spell spell){
        SpellKnowns.add(spell);
        //getTime(500);
    }
    public void initialisePotions(){
        skeleGro = new Potion("Skele-Gro", 35);
        essence = new Potion("Essence of Dittany", 25);
        draughtDeath = new Potion("Draught of Living Death", -90);
    }
    public void createListPotion(Potion potion){
        potions.add(potion);
        //getTime(500);
    }
    public Wand initializeWand(int choice){
        Wand choiceWand;
        switch(choice){
            case 1:
                choiceWand = new Wand("The Elder Wand", Core.PHOENIX_FEATHER, 10);
                return choiceWand;

            case 2:
                choiceWand = new Wand("Vine Wand", Core.DRAGON_HEARTSTRING, 30);
                return choiceWand;
        }
        return null;
    }
    public void getTime(int time){
        try {
            Thread.sleep(time+500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Pet initialisePet(int choice){
        Pet choicePet;
        switch (choice){
            case 1:
                choicePet = Pet.CAT;
                return choicePet;
            case 2:
                choicePet = Pet.OWL;
                return choicePet;
            case 3:
                choicePet = Pet.RAT;
                return choicePet;
        }
        return null;
    }
    public String Welcome(){
        Console.log("Welcome to Harry Potter at Home ! Please enter your name !");
        String playerName = scanner.getString();
        getTime(1000);
        return playerName;
    }
    public Wand chooseWand(){
        Console.log("Equip yourself with the wand that suits you!" + "You have the choice between :" +" The Elder Wand [Enter 1](core : PHOENIX_FEATHER, size : 10) et " +"Vine Wand [Enter 2] (core : DRAGON_HEARTSTRING, size : 30)");
        int choiceWand = 0;
        while (choiceWand != 1&&choiceWand!=2){
            Console.log("Enter 1 or 2");
            choiceWand = scanner.getInt();
        }
        wand = initializeWand(choiceWand);
        getTime(1000);
        //Test
        Console.log(wand.getName());
        //Test
        return wand;
    }
    public Pet choosePet(){
        Console.log("Choose now your pet !"+ "CAT [Enter 1], OWL [Enter 2] or RAT [Enter 3]");
        int choicePet = 0;
        while (choicePet !=1 && choicePet!=2 && choicePet!=3){
            Console.log("Enter 1, 2 or 3");
            choicePet = scanner.getInt();
        }
        pet = initialisePet(choicePet);
        getTime(1000);
        //test
        Console.log(pet.toString());
        return pet;
    }

    //Faire tout les initialise


    public Lev1 getLev1() {
        return lev1;
    }

    public void setLev1(Lev1 lev1) {
        this.lev1 = lev1;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public Potion getSkeleGro() {
        return skeleGro;
    }

    public void setSkeleGro(Potion skeleGro) {
        this.skeleGro = skeleGro;
    }

    public Potion getEssence() {
        return essence;
    }

    public void setEssence(Potion essence) {
        this.essence = essence;
    }

    public Potion getDraughtDeath() {
        return draughtDeath;
    }

    public void setDraughtDeath(Potion draughtDeath) {
        this.draughtDeath = draughtDeath;
    }

    public List<Spell> getSpellKnowns() {
        return SpellKnowns;
    }

    public void setSpellKnowns(List<Spell> spellKnowns) {
        SpellKnowns = spellKnowns;
    }

    public Spell getWingLev() {
        return wingLev;
    }

    public void setWingLev(Spell wingLev) {
        this.wingLev = wingLev;
    }

    public Spell getAccio() {
        return accio;
    }

    public void setAccio(Spell accio) {
        this.accio = accio;
    }

    public Spell getExpPatro() {
        return expPatro;
    }

    public void setExpPatro(Spell expPatro) {
        this.expPatro = expPatro;
    }

    public Spell getSectum() {
        return sectum;
    }

    public void setSectum(Spell sectum) {
        this.sectum = sectum;
    }

    public Spell getAvaKada() {
        return avaKada;
    }

    public void setAvaKada(Spell avaKada) {
        this.avaKada = avaKada;
    }

    public Spell getExpellia() {
        return expellia;
    }

    public void setExpellia(Spell expellia) {
        this.expellia = expellia;
    }



    public void setInventory(List<object> inventory) {
        this.inventory = inventory;
    }

    public Enemy getTroll() {
        return troll;
    }

    public void setTroll(Enemy troll) {
        this.troll = troll;
    }

    public Enemy getBasilic() {
        return Basilic;
    }

    public void setBasilic(Enemy basilic) {
        Basilic = basilic;
    }

    public List<Enemy> getDetraqueurs() {
        return Detraqueurs;
    }

    public void setDetraqueurs(List<Enemy> detraqueurs) {
        Detraqueurs = detraqueurs;
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

    public Enemy getDoloresOmbrage() {
        return DoloresOmbrage;
    }

    public void setDoloresOmbrage(Enemy doloresOmbrage) {
        DoloresOmbrage = doloresOmbrage;
    }

    public List<Enemy> getMangemorts() {
        return Mangemorts;
    }

    public void setMangemorts(List<Enemy> mangemorts) {
        Mangemorts = mangemorts;
    }

    public Enemy getBellatrixLestrange() {
        return bellatrixLestrange;
    }

    public void setBellatrixLestrange(Enemy bellatrixLestrange) {
        this.bellatrixLestrange = bellatrixLestrange;
    }

    public List<object> getInventory() {
        return inventory;
    }

    public String getNameChoice() {
        return nameChoice;
    }

    public void setNameChoice(String nameChoice) {
        this.nameChoice = nameChoice;
    }
}
