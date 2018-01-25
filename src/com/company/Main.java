package com.company;
/*
generate random number (int)
prompt user for (input) guess of number
stdout to user whether guess is too high, low, or correct
allow up to 5 chances; if number is never correct, inform user of correct answer
if number is guessed correctly, congratulate user
give user option to play again
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //initialize scanner

        String userDecides = "yes"; //declare and initialize variable for loop to play again

        //start while loop to play guessing game
        while (userDecides.equals("yes")) {

            int guessNum = 1; //declare and initialize count # of user guesses
            int userNum; // declare user's guess # input

            //computer-generated random integer
            int randomNum = (int) (1 + Math.random() * 101);

            //explain "guessing game" to user. give user instructions.
            System.out.println(); //spacial order for less confusion during multiple games
            System.out.println("I have generated a random integer between 1 and 100. You have five chances to guess what it is.");
            System.out.println("Enter your guess: ");

            do {
                //checkUserInput
                while (true) {
                    try {
                        userNum = Integer.parseInt(input.next()); //read in user input as string and attempt to parse to int. if int read in, break from loop while(true){} into "too high, too low".
                        break;
                    } catch (NumberFormatException ignore) { //if string read in, output "invalid entry"
                        System.out.println("Invalid entry. Enter an integer: ");
                    }
                }

                //when checkUserInput passes, too low, too high game begins:

                //outside of spec range. counts as 1 of 5 guesses.
                if ((userNum < 0 || userNum > 100) && (guessNum < 5)) {
                    System.out.println("Entry outside the specified range of [1,100].");
                }
                //too low
                if ((userNum < randomNum) && (guessNum < 5)) {
                    System.out.println("Too low! Enter your guess: ");
                }
                //too high
                if ((userNum > randomNum) && (guessNum < 5)) {
                    System.out.println("Too high! Enter your guess: ");
                }
                guessNum++; //add one to guess # count variable
            } while ((userNum != randomNum) && (guessNum < 6));
            //guesses correctly. winner.
            if (userNum == randomNum) {
                System.out.println("CONGRATULATIONS! " + userNum + " is the correct integer.");
                System.out.println("Would you like to play again?");
                Scanner answer = new Scanner(System.in); //create second scanner
                userDecides = answer.nextLine();
                if (userDecides.equals("no")) { //user input breaks while(userDecides.equals("yes")) loop. ends program.
                    System.out.println("Thank you for playing The Guessing Game.");
                }
            } else {
                //exceeds alloted # guesses. loses game.
                System.out.println("Sorry, you have exceeded five guesses without guessing correctly.");
                System.out.println("The correct integer was " + randomNum + ".");
                System.out.println("Would you like to play again? Enter yes or no: ");
                Scanner answer = new Scanner(System.in); //create second scanner
                userDecides = answer.nextLine();
                if (userDecides.equals("no")) { //user input breaks while(userDecides.equals("yes")) loop. ends program.
                    System.out.println("Thank you for playing The Guessing Game.");
                }
            }
        }
    }
}