import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.*;

public class Blackjack {

    static int player_card1;
    static int player_card2;
    static int computer_card1;
    static int computer_card2;
    static int player_card;
    static int computer_card;

    Blackjack() {
        Random random = new Random();

        // Using Random class in Java to add random number
        player_card1 = random.nextInt(11);
        player_card1 += 1;

        // Using Math.random() to add random number
        player_card2 = (int) (Math.random() * 11 + 1);
        computer_card1 = (int) (Math.random() * 11 + 1);
        computer_card2 = (int) (Math.random() * 11 + 1);
        computer_card = computer_card1 + computer_card2;
        player_card = player_card1 + player_card2;

    }

    public static void game_card(int player_card1, int player_card2, int player_card, int computer_card1,
            int computer_card2, int computer_card) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hit or Stand?: ");
        String answer = scanner.nextLine();
        int another_card = (int) (Math.random() * 11 + 1);
        if (answer.equals("Hit")) {
            player_card += another_card;
            System.out.println("You have: " + another_card);
            System.out.println("Total You have " + player_card);
            System.out.print("The computer have: " + computer_card);
        } else {
            System.out.println("You have " + player_card);
            System.out.println("The computer have: " + computer_card);
        }
    }

    public static String getwinconuation() {
        String win = "";
        if ((player_card <= 21 && computer_card > 21) || (21 - player_card < 21 - computer_card)) {
            win = "Player win";
            System.out.println(win);
        } else if ((computer_card <= 21 && player_card > 21) || (21 - computer_card < 21 - player_card)) {
            win = "Computer win";
            System.out.println(win);
        } else if (player_card == computer_card) {
            win = "Push";
            System.out.println(win);
        }
        return win;
    }

    public static boolean replay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? Y or N: ");
        String userinput = scanner.nextLine();
        char letter = userinput.charAt(0);
        if (letter == 'Y' || letter == 'y') {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Blackjack play1 = new Blackjack();

        System.out.println("Weclome to The Blackjack game");
        do {
            System.out.println("Your card:" + player_card1 + " " + player_card2);
            System.out.println("The computer card:" + computer_card1);
            play1.game_card(player_card1, player_card2, player_card, computer_card1, computer_card2, computer_card);
            System.out.println(" ");
            play1.getwinconuation();
        } while (replay());
    }
}
