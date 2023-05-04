package Tools;
import java.util.InputMismatchException;
import java.util.Scanner;
//créer un SafeScanner, avec un try catch et boucle pour vérifier que chaque chose entrée soient du bon format..., au lieu de le faire à chaque fois

public class SafeScanner {
    Scanner sc;
    public SafeScanner(){
        this.sc = new Scanner(System.in);

    }
    public int getInt() {
        boolean inputValid = false;
        int result = 0;
        while (!inputValid) {//autre possibilité: cf photo
            try {
                result = sc.nextInt();

                inputValid = true;

                inputValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous n'avez pas entré le bon type de donnée");
                sc.next();
            }

        }
        return result;
    }
    public String getString(){
        boolean inputValid = false;
        String result = "";
        while (!inputValid) {//autre possibilité: cf photo
            try {
                result = sc.nextLine();

                inputValid = true;

                inputValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous n'avez pas entré le bon type de donnée");
                sc.next();
            }

        }
        return result;
    }

    public void closeScanner(){
        sc.close();
    }
}
