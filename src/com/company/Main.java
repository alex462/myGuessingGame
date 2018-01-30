/*
generate random number (int)
prompt user for (input) guess of number
stdout to user whether guess is too high, low, or correct
allow up to 5 chances; if number is never correct, inform user of correct answer
if number is guessed correctly, congratulate user
give user option to play again
 */

package com.company;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        String playAgain = "yes";

        do {

//            final int MAX_GUESS_COUNT = 4;
            System.out.println("Enter your guess: ");
            int userGuess = input.nextInt();

            int generatedNumber = (int) Math.ceil(Math.random() * 100);

            int numberOfGuesses = 1;

            do {

                if (userGuess > generatedNumber) {
                    System.out.println("Your number is too high!");
                    System.out.println("Guess again: ");
                    numberOfGuesses++;
                    userGuess = input.nextInt();
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your number is too low!");
                    System.out.println("Guess again: ");
                    numberOfGuesses++;
                    userGuess = input.nextInt();
                }

            }
            while ((numberOfGuesses < 4) && (userGuess != generatedNumber));

            if (userGuess == generatedNumber) {
                System.out.println("You guessed the correct number!");
                System.out.println("Would you like to play again? Enter yes or no: ");
                Scanner answer = new Scanner(System.in);
                playAgain = answer.nextLine();
            } else {
                System.out.println("Sorry, you have run out of chances. The correct number was: " + generatedNumber);
                System.out.println("Would you like to play again? Enter yes or no: ");
                Scanner answer = new Scanner(System.in);
                playAgain = answer.nextLine();
            }


            System.out.println("Would you like to play again? Enter yes or no: ");
            Scanner answer = new Scanner(System.in);
            playAgain = answer.nextLine();

        }
        while(playAgain.equals("yes"));

    }

}
