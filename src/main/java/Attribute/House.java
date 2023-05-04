package Attribute;
//
//import lombok.Getter;
//import lombok.Setter;

import java.util.Random;

public enum House {
    HUFFLEPUFF{
        //@Getter @Setter
        String name = "HUFFLEPUFF";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }
        public int applyPotion(int health){
            return health+new Random().nextInt(10)+20;
        }
    },

    SLYTHERIN{
        //@Getter @Setter
        String name ="SLYTHERIN";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }

        public int applySpell(int damage){
            return damage+new Random().nextInt(10)+10;
        }
    },

    GRYFFINDOR{
        //@Getter @Setter
        String name ="GRYFFINDOR";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }
        public int takeDamage(int damage){
            return damage /2; //damage coming from enemy
        }
    },

    RAVENCLAW {
        //@Getter @Setter
        String name ="RAVENCLAW";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }
        public double applyAccuracy(double accuracy){
            return accuracy+0.2;
        }
    },



    }
