package Tools;


import com.example.harryathomefx.GameControlleur;

public class Console {
    public static void log(String text){
        System.out.println(text);
       // GameControlleur gameController = new GameControlleur(); // récupère l'objet GameController
        //String consoleText = "Vous avez trouvé une épée magique !";
        //gameController.addToConsole(text); // ajoute le texte à la console
    }
    public static void logFloat(float number){
        System.out.println(number);
    }
}
