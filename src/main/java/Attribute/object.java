package Attribute;

//import lombok.Getter;
//import lombok.Setter;

public class object {
    private  String name;
     int power;

    public object(String name, int power) {
        this.name = name;
        this.power=power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
