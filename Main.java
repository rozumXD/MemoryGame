import java.io.Console;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        int choosenLvl = LevelSelector(); 
        File file = new File("../Words.txt");
        String path = file.getAbsolutePath();
        

        
    }

    public static String fileExists() {   //Sprawdzamy czy plik istnieje.
        File file = new File("Words.txt");
        boolean exists = file.exists();
        String path = file.getAbsolutePath();
        
        return null;
      

        
   }

    public static void RunGame(int choosenLvl){   //start gry
        
        if(choosenLvl==1){
            int bet = 10;
            System.out.println("\nLevel: easy");
            System.out.println("\nGuess chances : " +  bet);
            for(int i=0;i<10;i++){

            }

        }else if(choosenLvl==2){
            int bet = 15;
            System.out.println("\nLevel: hard");
            System.out.println("\nGuess chances : " +  bet);
        
        }

    }

    public static int LevelSelector(){     
        Scanner scan = new Scanner(System.in);
        boolean shouldContinue = true;
        int result = 0;

        while(shouldContinue){                                          //wybieranie poziomu trudnosci
            System.out.println("\nChoose the game difficulty level : ");
            System.out.println("[ 1 ] - Easy.");
            System.out.println("[ 2 ] - Hard.");
            System.out.println("[ 3 ] - Exit the game.");
            
            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1 -> result = 1;
                case 2 -> result = 2;
                case 3 -> result = 3;  
            }
        }
        return result;
    }


}