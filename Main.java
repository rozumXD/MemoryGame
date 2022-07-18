import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner;

import javax.swing.border.Border;

import org.w3c.dom.TypeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws FileNotFoundException{
       System.out.println("XD");

       int choosenLvl = levelSelector(); 
       levelInformation(choosenLvl);
       List words = words();
       board(words, choosenLvl);
       
    }

    static void board(List words, int choosenLvl){
        

        if(choosenLvl==1){
            int bet = 10;
            String[][] boardOfWords = new String[2][4];
            

            for(int i=0;i<boardOfWords.length;i++){  //wyswietlanie tablicy dwu
                String[] firstRow = boardOfWords[i];
                
                Random rand = new Random();
                int r = rand.nextInt(100);

                boardOfWords[1][1] = words.get(r);

                for(int j=0; j<firstRow.length; j++){  
                    System.out.print(boardOfWords[i][j] + " ");
                }
                System.out.println();
            

        }


        }else if(choosenLvl==2){
            

            }
        }
        
    

     static List words() throws FileNotFoundException{  //wczytanie slow z pliku do tablicy arraylist
        File file = new File("Words.txt");
        
            Scanner scanner = new Scanner(file);
            List<String> words = new ArrayList<>();
    
            while(scanner.hasNext()){
                words.add(scanner.nextLine());
            }
           
        return words;
    }

     static int levelSelector(){     
        Scanner scan = new Scanner(System.in);
        boolean shouldContinue = true;
        int result = 0;

        while(shouldContinue){                                              //wybieranie poziomu trudnosci
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

            shouldContinue = false;
        }
        return result;
    }

 static void levelInformation(int choosenLvl){   //informacja na temat wybranego poziomu

    if(choosenLvl==1){
        System.out.println("-------------------------------");
        System.out.println("\nLevel: easy \n") ;
    }else if(choosenLvl==2){
        System.out.println("-------------------------------");
        System.out.println("\nLevel: hard \n") ;
    }    
 }

}

