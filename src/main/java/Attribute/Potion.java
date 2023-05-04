package Attribute;
//import lombok.Setter;
//import lombok.Getter;


public class Potion {
    private  String name;
    private  int curePoint;

    public Potion(String name, int cure) {
        this.name = name;
        this.curePoint = cure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurePoint() {
        return curePoint;
    }

    public void setCurePoint(int curePoint) {
        this.curePoint = curePoint;
    }
}
