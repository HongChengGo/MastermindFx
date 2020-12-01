package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main extends Application {
    private static String[] answer;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Welcome to Mastermind");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void colorid() {
        answer = new String[4];
    //0 with new Integer(0)
       HashMap<Integer, String> Pattern = new HashMap<>(4);
        Pattern.put(0, "Blue");
        Pattern.put(1, "Green");
        Pattern.put(2, "Red");
        Pattern.put(3, "Yellow");

        int random = 0;
        for(int i = 0; i <= 3; i++) {
            random = (int) ((Math.random() * (3 - 0)) + 0);
            answer[i] = Pattern.get(random);
            //Red   Green   Blue   Red
        }
        // <"Red",1>;
        // <"Green",2>;
        // <"Yellow",3>;
        //Random pattern reference
        //Int array for the color id's
        //Each index to represent a different color (0-3)
        //0- Blue  1- Red  2- Green  3- Yellow
        //Every new game the system will randomize the order of 0-3 to get the current secretCode

    }


    //Hashmap<Integer> guess = {0,3),(1,2),(2,1),(3,0)}
        public static void guessChecking() {
        colorid();
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
        System.out.println(answer[3]);

        Scanner input = new Scanner(System.in);
        String [] guess = new String[4];
        String [] peg = new String[4];
        int attempts = 0;

            //read in guess
                //increment attempts
            do {
                attempts++;
                System.out.println("Attempt " + attempts);
                System.out.print("Enter your guess (space separated): ");
                guess[0] = input.next();
                System.out.println("First: " + guess[0]);
                guess[1] = input.next();
                System.out.println("Second: " + guess[1]);
                guess[2] = input.next();
                System.out.println("Third: " + guess[2]);
                guess[3] = input.next();
                System.out.println("Last: " + guess[3]);

                //Green Blue Orange Green  >>> 3, 5, 1, 3 (guess) >>> Green Yellow Blue Orange >>> 3, 2, 5, 1
                //compare index i of guess array with index i of secret code array >>> black, white, or no peg
                if (guess[0].equals(answer[0])) {
                    //Add black peg to peg array
                    peg[0] = "Black";
                } //else if right color wrong position >> white peg
                else if (guess[0].equals(answer[1]) || guess[0].equals(answer[2]) || guess[0].equals(answer[3])) {
                    //add white peg to peg array
                    peg[0] = "White";
                } else {
                    //blank peg
                    peg[0] = "Blank";
                }

                if (guess[1].equals(answer[1])) {
                    //Add black peg to peg array
                    peg[1] = "Black";
                } //else if right color wrong position >> white peg
                else if (guess[1].equals(answer[0]) || guess[1].equals(answer[2]) || guess[1].equals(answer[3])) {
                    //add white peg to peg array
                    peg[1] = "White";
                } else {
                    //blank peg
                    peg[1] = "Blank";
                }

                if (guess[2].equals(answer[2])) {
                    //Add black peg to peg array
                    peg[2] = "Black";
                } //else if right color wrong position >> white peg
                else if (guess[2].equals(answer[0]) || guess[2].equals(answer[1]) || guess[2].equals(answer[3])) {
                    //add white peg to peg array
                    peg[2] = "White";
                } else {
                    //blank peg
                    peg[2] = "Blank";
                }

                if (guess[3].equals(answer[3])) {
                    //Add black peg to peg array
                    peg[3] = "Black";
                } //else if right color wrong position >> white peg
                else if (guess[3].equals(answer[0]) || guess[3].equals(answer[1]) || guess[3].equals(answer[2])) {
                    //add white peg to peg array
                    peg[3] = "White";
                } else {
                    //blank peg
                    peg[3] = "Blank";
                }
                System.out.println("Peg 1: " + peg[0]);
                System.out.println("Peg 2: " + peg[1]);
                System.out.println("Peg 3: " + peg[2]);
                System.out.println("Peg 4: " + peg[3]);
            } while((!(peg[0].equals("Black")) || !(peg[1].equals("Black")) || !(peg[2].equals("Black")) || !(peg[3].equals("Black"))) && attempts < 3);

            if(peg[0].equals("Black") && peg[1].equals("Black") && peg[2].equals("Black") && peg[3].equals("Black")) {
                System.out.println("You won!");
            } else {
                System.out.println("You lost!");
            }
        }


    public static void main(String[] args) {
        launch(args);
        guessChecking();
        //HashMap<Integer, Integer> guess = Generate();
        //HashMap<Integer, Integer> secretCode = Generate();
        //int[] Indicator = compared(guess,secretCode);

    }
}
