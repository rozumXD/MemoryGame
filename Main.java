import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner;
import javax.print.event.PrintJobListener;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument.BlockElement;
import org.w3c.dom.TypeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws FileNotFoundException{
       int choosenLvl = levelSelector(); 
       levelInformation(choosenLvl);
       List words = words();
       board(words, choosenLvl);

    }

    static void board(List words, int choosenLvl){

        if(choosenLvl==1){                                 //POZIOM TRUDNOSCI LATWY
            int chances = 10;
            Object[][] boardOfWords = new Object[2][4];

            for(int i=0;i<boardOfWords.length;i++){       //tworzenie tablicy kart
                Object[] firstRow = boardOfWords[i];
                Random rand = new Random();
                
                while(boardOfWords[0][3]==null){          //przypisywanie kart do pierwszego wiersza tablicy
                    boardOfWords[0][0] = words.get(rand.nextInt(100));
                    boardOfWords[0][1] = words.get(rand.nextInt(100));
                    boardOfWords[0][2] = words.get(rand.nextInt(100));
                    boardOfWords[0][3] = words.get(rand.nextInt(100));
                }

                while(boardOfWords[1][3]==null){          //mieszanie kart dla drugiego wiersza
                    Random rand2 = new Random();
                    boardOfWords[1][0] = boardOfWords[0][rand2.nextInt(4)];
                    boardOfWords[1][1] = boardOfWords[0][rand2.nextInt(4)];
                    boardOfWords[1][2] = boardOfWords[0][rand2.nextInt(4)];
                    boardOfWords[1][3] = boardOfWords[0][rand2.nextInt(4)];
                }
        }

        boolean gameStart = true ;
        while(gameStart){                       

            Object a1 = "X"; 
            Object a2 = "X";
            Object a3 = "X";
            Object a4 = "X";  
            
            Object b1 = "X"; 
            Object b2 = "X";
            Object b3 = "X";
            Object b4 = "X";  
            

            while(chances!=0){
                gameStart = false;
                System.out.println("Guess chances: " + chances);
                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4);   //wyswietlanie kart
                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4);

                Scanner scanner = new Scanner(System.in);                      //pobieranie danych od uzytkownika
                String bet1 = scanner.nextLine();
                
                Object temp_a=null;
                Object temp_b=null;

                if(bet1.startsWith("A")&&bet1.endsWith("1")){     //sprawdzanie danych pobranych od uzytkownika
                    a1 = boardOfWords[0][0];
                    temp_a = boardOfWords[0][0];
                }else if(bet1.startsWith("A")&&bet1.endsWith("2")){
                    a2 = boardOfWords[0][1];
                    temp_a = boardOfWords[0][1];
                }else if(bet1.startsWith("A")&&bet1.endsWith("3")){   
                    a3 = boardOfWords[0][2];
                    temp_a = boardOfWords[0][2];
                }else if(bet1.startsWith("A")&&bet1.endsWith("4")){
                    a4 = boardOfWords[0][3];
                    temp_a = boardOfWords[0][3];
                }

                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4);
                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4);

                String bet2 = scanner.nextLine();                                    //pobieranie danych B

                if(bet2.startsWith("B")&&bet2.endsWith("1")){
                    b1 = boardOfWords[1][0];
                    temp_b = boardOfWords[1][0];
                }else if(bet2.startsWith("B")&&bet2.endsWith("2")){
                    b2 = boardOfWords[1][1];
                    temp_b = boardOfWords[1][1];
                }else if(bet2.startsWith("B")&&bet2.endsWith("3")){   
                    b3 = boardOfWords[1][2];
                    temp_b = boardOfWords[1][2];
                }else if(bet2.startsWith("B")&&bet2.endsWith("4")){
                    b4 = boardOfWords[1][3];
                    temp_b = boardOfWords[1][3];
                }

                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4);
                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4);

                if(temp_a.equals(temp_b)){                                         //wyswietlanie stale dobrych odpowiedzi
                    Object goodGuess_a = temp_a;
                    Object goodGuess_b = temp_b;

                }else{
                    Object badGuess_a = temp_a;                    //markowanie zlych odpowiedzi na X
                    Object badGuess_b = temp_b;
                    temp_a = "X";
                    temp_b = "X";

                    if(a1.equals(badGuess_a)){
                        a1="X";
                    }
                    if(a2.equals(badGuess_a)){
                        a2="X";
                    }
                    if(a3.equals(badGuess_a)){
                        a3="X";
                    }
                    if(a4.equals(badGuess_a)){
                        a4="X";
                    }
                    if(b1.equals(badGuess_b)){
                        b1="X";
                    }
                    if(b2.equals(badGuess_b)){
                        b2="X";
                    }
                    if(b3.equals(badGuess_b)){
                        b3="X";
                    }
                    if(b4.equals(badGuess_b)){
                        b4="X";
                    }
                    
                    badGuess_a = null;
                    badGuess_b = null;
                    
                }
                 
                if(a1!="X"){      //sprawdzanie czy jesli wszystkie 4 karty w wieszu sa rozne od X tzn odmarkowane - gra sie konczy
                    if(a2!="X"){
                        if(a3!="X"){
                            if(a4!="X"){    
                                System.out.println("\nCongratulations ! U found them all!\n");
                                System.out.println("    1    " + "    2    " + "    3    " + "    4    ");
                                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4);
                                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4);

                                gameStart = false;
                            }
                        }
                    }
                }

                chances--;

                if(chances==0){                                   //adnotacja i koniec gry jesli proby wyniosly wartosc 0
                    System.out.println("GAME OVER :(\n ");
                    gameStart=false;
                }
            }
        }

        }else if(choosenLvl==2){              //---------------------------------------POZIOM TRUDNOSCI TRUDNY --------------------------------------------------
            int chances = 15;
            Object[][] boardOfWords = new Object[2][8];

            for(int i=0;i<boardOfWords.length;i++){              //tworzenie tablicy kart
                Object[] firstRow = boardOfWords[i];
                Random rand = new Random();
                
                while(boardOfWords[0][7]==null){                //przypisywanie kart do pierwszego wiersza tablicy
                    boardOfWords[0][0] = words.get(rand.nextInt(100));
                    boardOfWords[0][1] = words.get(rand.nextInt(100));
                    boardOfWords[0][2] = words.get(rand.nextInt(100));
                    boardOfWords[0][3] = words.get(rand.nextInt(100));
                    boardOfWords[0][4] = words.get(rand.nextInt(100));
                    boardOfWords[0][5] = words.get(rand.nextInt(100));
                    boardOfWords[0][6] = words.get(rand.nextInt(100));
                    boardOfWords[0][7] = words.get(rand.nextInt(100));
                }

                while(boardOfWords[1][7]==null){                //mieszanie kart dla drugiego wiersza
                    Random rand2 = new Random();
                    boardOfWords[1][0] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][1] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][2] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][3] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][4] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][5] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][6] = boardOfWords[0][rand2.nextInt(8)];
                    boardOfWords[1][7] = boardOfWords[0][rand2.nextInt(8)];
                }
        }

        Boolean gameStart = true;
        while(gameStart){
            gameStart = false;

            Object a1 = "X"; 
            Object a2 = "X";
            Object a3 = "X";
            Object a4 = "X"; 
            Object a5 = "X"; 
            Object a6 = "X";
            Object a7 = "X";
            Object a8 = "X"; 
            
            Object b1 = "X"; 
            Object b2 = "X";
            Object b3 = "X";
            Object b4 = "X";  
            Object b5 = "X"; 
            Object b6 = "X";
            Object b7 = "X";
            Object b8 = "X";

            while(chances!=0){
                gameStart = false;
                System.out.println("Guess chances: " + chances);
                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4+" "+ a5 +" "+ a6 +" "+ a7 +" "+ a8);
                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4+" "+ b5 +" "+ b6 +" "+ b7 +" "+ b8);

                Scanner scanner = new Scanner(System.in);  //pobieranie danych od uzytkownika
                String bet1 = scanner.nextLine();
                
                Object temp_a=null;
                Object temp_b=null;

                if(bet1.startsWith("A")&&bet1.endsWith("1")){    //sprawdzanie danych od uzutkownika dla trudnego poziomu
                    a1 = boardOfWords[0][0];
                    temp_a = boardOfWords[0][0];
                }else if(bet1.startsWith("A")&&bet1.endsWith("2")){
                    a2 = boardOfWords[0][1];
                    temp_a = boardOfWords[0][1];
                }else if(bet1.startsWith("A")&&bet1.endsWith("3")){   
                    a3 = boardOfWords[0][2];
                    temp_a = boardOfWords[0][2];
                }else if(bet1.startsWith("A")&&bet1.endsWith("4")){
                    a4 = boardOfWords[0][3];
                    temp_a = boardOfWords[0][3];
                }else if(bet1.startsWith("A")&&bet1.endsWith("5")){
                    a4 = boardOfWords[0][4];
                    temp_a = boardOfWords[0][4];
                }else if(bet1.startsWith("A")&&bet1.endsWith("6")){
                    a4 = boardOfWords[0][5];
                    temp_a = boardOfWords[0][5];
                }else if(bet1.startsWith("A")&&bet1.endsWith("7")){
                    a4 = boardOfWords[0][6];
                    temp_a = boardOfWords[0][6];
                }else if(bet1.startsWith("A")&&bet1.endsWith("8")){
                    a4 = boardOfWords[0][7];
                    temp_a = boardOfWords[0][7];
                }

                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4+" "+ a5 +" "+ a6 +" "+ a7 +" "+ a8); //wyswietlanie kart
                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4+" "+ b5 +" "+ b6 +" "+ b7 +" "+ b8);

                String bet2 = scanner.nextLine();    //pobieranie wartosci od uzytkownika

                if(bet2.startsWith("B")&&bet2.endsWith("1")){    //sprawdzanie wartosci dla B
                    b1 = boardOfWords[1][0];
                    temp_b = boardOfWords[1][0];
                }else if(bet2.startsWith("B")&&bet2.endsWith("2")){
                    b2 = boardOfWords[1][1];
                    temp_b = boardOfWords[1][1];
                }else if(bet2.startsWith("B")&&bet2.endsWith("3")){   
                    b3 = boardOfWords[1][2];
                    temp_b = boardOfWords[1][2];
                }else if(bet2.startsWith("B")&&bet2.endsWith("4")){
                    b4 = boardOfWords[1][3];
                    temp_b = boardOfWords[1][3];
                }else if(bet2.startsWith("B")&&bet2.endsWith("5")){
                    b4 = boardOfWords[1][4];
                    temp_b = boardOfWords[1][4];
                }else if(bet2.startsWith("B")&&bet2.endsWith("6")){
                    b4 = boardOfWords[1][5];
                    temp_b = boardOfWords[1][5];
                }else if(bet2.startsWith("B")&&bet2.endsWith("7")){
                    b4 = boardOfWords[1][6];
                    temp_b = boardOfWords[1][6];
                }else if(bet2.startsWith("B")&&bet2.endsWith("8")){
                    b4 = boardOfWords[1][7];
                    temp_b = boardOfWords[1][7];
                }

                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4+" "+ a5 +" "+ a6 +" "+ a7 +" "+ a8);
                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4+" "+ b5 +" "+ b6 +" "+ b7 +" "+ b8);

                if(temp_a.equals(temp_b)){      //jesli dobre karty to zostaja wyswietlone wciaz 
                    Object goodGuess_a = temp_a;
                    Object goodGuess_b = temp_b;

                }else{                           //dla zlego odgadniecia karty zamieniaja sie na X
                    Object badGuess_a = temp_a;
                    Object badGuess_b = temp_b;
                    temp_a = "X";
                    temp_b = "X";

                    if(a1.equals(badGuess_a)){
                        a1="X";
                    }
                    if(a2.equals(badGuess_a)){
                        a2="X";
                    }
                    if(a3.equals(badGuess_a)){
                        a3="X";
                    }
                    if(a4.equals(badGuess_a)){
                        a4="X";
                    }
                    if(a5.equals(badGuess_a)){
                        a5="X";
                    }
                    if(a6.equals(badGuess_a)){
                        a6="X";
                    }
                    if(a7.equals(badGuess_a)){
                        a7="X";
                    }
                    if(a8.equals(badGuess_a)){
                        a8="X";
                    }
                    
                    if(b1.equals(badGuess_b)){
                        b1="X";
                    }
                    if(b2.equals(badGuess_b)){
                        b2="X";
                    }
                    if(b3.equals(badGuess_b)){
                        b3="X";
                    }
                    if(b4.equals(badGuess_b)){
                        b4="X";
                    }
                    if(b5.equals(badGuess_b)){
                        b5="X";
                    }
                    if(b6.equals(badGuess_b)){
                        b6="X";
                    }
                    if(b7.equals(badGuess_b)){
                        b7="X";
                    }
                    if(b8.equals(badGuess_b)){
                        b8="X";
                    }
                    
                    badGuess_a = null;
                    badGuess_b = null;
                    
                }

                
                
                if(a1!="X"){                        //sprawdzanie czy karty sa odkryte, jestli tak, adnotacja oraz koniec gry
                    if(a2!="X"){
                        if(a3!="X"){
                            if(a4!="X"){
                                if(a5!="X"){
                                    if(a6!="X"){
                                        if(a7!="X"){ 
                                            if(a8!="X"){
                                                System.out.println("\nGOOD JOB! U found them all!\n");
                                                System.out.println("    1    " + "    2    " + "    3    " + "    4    ");
                                                System.out.println("A" +" "+ a1 +" "+ a2 +" "+ a3 +" "+ a4+" "+ a5 +" "+ a6 +" "+ a7 +" "+ a8);
                                                System.out.println("B" +" "+ b1 +" "+ b2 +" "+ b3 +" "+ b4+" "+ b5 +" "+ b6 +" "+ b7 +" "+ b8);


                                                    gameStart = false;
                                            }
                                        }
                                    }
                                }    
                            }
                        }
                    }
                }

                chances--; 

                if(chances==0){
                    System.out.println("GAME OVER :(\n ");
                    gameStart=false;
                }
            }
        }      
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

