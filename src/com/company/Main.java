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
        String userDecides = "yes";
        Scanner input = new Scanner(System.in); //initialize scanner

        while (userDecides.equals("yes")) {

            //generate random integer
            int randomNum = (int) (1 + Math.random() * 101);

            //explain "guessing game" to user. give user instructions.
            System.out.println();
            System.out.println("I have generated a random integer between 1 and 100. You have five chances to guess what it is. Enter your first guess: ");

            int userNum = input.nextInt(); //use scanner to append user input into variable userNum, which is the integer the user guesses.
            //initialize int variable guessNum, which number guess the user is on.
            int guessNum = 1;

            //use do...while loop statement
            do {
                if (userNum < 0 || userNum > 100) {
                    System.out.println("Entry outside the specified range of [0,100].");
                }
                if (userNum < randomNum) {
                    System.out.println("Too low! Guess again: ");
                }
                if (userNum > randomNum) {
                    System.out.println("Too high! Guess again: ");
                }
                guessNum++;
                userNum = input.nextInt();
            } while ((userNum != randomNum) && (guessNum <= 4));

            if (userNum == randomNum) {
                System.out.println("CONGRATULATIONS! " + userNum + " is the correct integer.");
                System.out.println("Would you like to play again?");
                Scanner answer = new Scanner(System.in);
                userDecides = answer.nextLine();
                if (userDecides.equals("no")) {
                    System.out.println("Thank you for playing The Guessing Game.");
                }
            } else {
                System.out.println("Sorry, you have exceeded five guesses without guessing correctly.");
                System.out.println("The correct integer was " + randomNum + ".");
                System.out.println("Would you like to play again? Enter yes or no: ");
                Scanner answer = new Scanner(System.in);
                userDecides = answer.nextLine();
                if (userDecides.equals("no")) {
                    System.out.println("Thank you for playing The Guessing Game.");
                }
            }
        }
    }
}