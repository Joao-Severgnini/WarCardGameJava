import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Creation of the main deck
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);

    // Create player 1 and their hand
    System.out.print("Player 1 name: ");
    String name1 = scanner.nextLine();
    List<Card> hand1 = deck.getFirstHalf();
    // Use the constructor Player(name, hand)
    Player player1 = new Player(name1, hand1);

    // Create player 2 and their hand
    System.out.print("Player 2 name: ");
    String name2 = scanner.nextLine();
    List<Card> hand2 = deck.getSecondHalf();
    // Use the constructor Player(name, hand)
    Player player2 = new Player(name2, hand2);

    // Initialize the round counter and War class
    int roundCount = 1;
    War war = new War();

    // Display the number of cards each player has at the start
    System.out.println("--------------------------------------------------");
    System.out.println(player1.getName() + "'s cards: " + player1.getHandSize());
    System.out.println(player2.getName() + "'s cards: " + player2.getHandSize());
    System.out.println("--------------------------------------------------");

    while (player1.hasCards() && player2.hasCards()) {

      // Draw a card from each player
      Card card1 = player1.drawCard();
      Card card2 = player2.drawCard();

      System.out.println("--------------------------------------------------");
      System.out.println("🎴 Round " + roundCount + ":");
      System.out.println(player1.getName() + " played: " + card1);
      System.out.println(player2.getName() + " played: " + card2);

      // Mechanism to handle victory and tie
      if (card1.getCard() > card2.getCard()) {
        System.out.println("✅ " + player1.getName() + " won this round!");
        player1.addCard(card1);
        player1.addCard(card2);
      } else if (card1.getCard() < card2.getCard()) {
        System.out.println("✅ " + player2.getName() + " won this round!");
        player2.addCard(card1);
        player2.addCard(card2);
      } else {

        // Handle the tie case
        System.out.println("⚔️ TIE! Starting the war...");
        List<Card> warCards1 = new LinkedList<>();
        List<Card> warCards2 = new LinkedList<>();

        // Add the cards in question to the War mechanism
        warCards1.add(card1);
        warCards2.add(card2);

        war.handleWar(player1, player2, warCards1, warCards2);
      }

      // Check to ensure the total number of cards is always 52
      int totalCards = player1.getHandSize() + player2.getHandSize();
      if (totalCards != 52) {
        System.out.println("ALERT: The total number of cards is " + totalCards + " (it should be 52)");
      }

      // Display the remaining number of cards for each player
      System.out.println("Remaining cards -> " + player1.getName() + ": " + player1.getHandSize() +
          " | " + player2.getName() + ": " + player2.getHandSize());
      System.out.println("--------------------------------------------------");
      System.out.println("");

      roundCount++;

      // Make the thread sleep for 0.1 sec for better visualization
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // Announce the winner
    if (player1.hasCards()) {
      System.out.println("🏆 " + player1.getName() + " won the game!");
    } else {
      System.out.println("🏆 " + player2.getName() + " won the game!");
    }

    scanner.close();
  }
}
