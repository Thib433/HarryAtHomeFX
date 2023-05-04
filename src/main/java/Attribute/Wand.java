package Attribute;
//import lombok.Data;
//import lombok.Setter;
//import lombok.Getter;

public  class Wand {
    private  String name;
    private  Core core;
    private  int size;

    public Wand(String name, Core core, int size) {
        this.name = name;
        this.core = core;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


