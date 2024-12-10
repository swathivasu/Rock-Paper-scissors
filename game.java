import java.util.Random;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Welcome to rock paper scissor game");
            System.out.println("Choose: 1 - Rock, 2 - Paper, 3 - Scissors, 4 - Quit");
            int userChoice = scanner.nextInt();

            if (userChoice == 4) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice. Please choose again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            int result = determineWinner(userChoice, computerChoice);

            if (result == 0) {
                System.out.println("It's a tie!");
            } else if (result == 1) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }
    }

    static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid Choice";
        }
    }

    static int determineWinner(int userChoice, int computerChoice) {
        // 0 - Tie, 1 - User wins, 2 - Computer wins
        if (userChoice == computerChoice) {
            return 0; // Tie
        } else if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
            return 1; // User wins
        } else {
            return 2; // Computer wins
        }
    }
}