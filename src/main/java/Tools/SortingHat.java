package Tools;

import Attribute.House;

import java.util.Random;

public class SortingHat {
    public House attributeHouse(House house){
        int random = new Random().nextInt(4)+1;
        while (true){
            switch (random){
                case 1:
                    house = House.RAVENCLAW;
                    return house;

                case 2:
                    house=House.HUFFLEPUFF;
                    return house;

                case 3:
                    house = House.SLYTHERIN;
                    return house;

                case 4:
                    house = House.GRYFFINDOR;
                    return house;

            }
        }

    }

    public static class Console {
        public void print(String text){
            System.out.println(text);
        }
    }
}
