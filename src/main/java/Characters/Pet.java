package Characters;

//import lombok.Getter;
//import lombok.Setter;

public enum Pet {
    OWL{
        //@Getter @Setter
        String name = "OWL";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }
    },
    RAT{
        //@Getter @Setter
        String name = "RAT";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }
    }, CAT{
        //@Getter @Setter
        String name = "CAT";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return super.toString();
        }
    }
}
