import java.util.LinkedList;
import java.util.List;

public class War {
  public void handleWar(Player player1, Player player2, List<Card> warCards1, List<Card> warCards2) {

    // Check if any player is ineligible for War
    if (player1.getHandSize() < 4) {
      System.out.println(player1.getName() + " does not have enough cards! " + player2.getName() + " wins the war!");
      player2.addCards(warCards1);
      player2.addCards(warCards2);
      return;
    } else if (player2.getHandSize() < 4) {
      System.out.println(player2.getName() + " does not have enough cards! " + player1.getName() + " wins the war!");
      player1.addCards(warCards1);
      player1.addCards(warCards2);
      return;
    }

    // Add 3 cards from each player
    for (int i = 0; i < 3; i++) {
      warCards1.add(player1.drawCard());
      warCards2.add(player2.drawCard());
    }

    // Draw the decisive card from each player
    Card warCard1 = player1.drawCard();
    Card warCard2 = player2.drawCard();

    // Add the war card to the collection for the winner to collect
    warCards1.add(warCard1);
    warCards2.add(warCard2);

    System.out.println("⚔️ War: ");
    System.out.println(player1.getName() + " played: " + warCard1);
    System.out.println(player2.getName() + " played: " + warCard2);

    // Create a single LinkedList for all the war cards
    List<Card> allWarCards = new LinkedList<>();
    allWarCards.addAll(warCards1);
    allWarCards.addAll(warCards2);

    // Display the winner of the War based on the decisive card
    // Assign all the war cards to the winning player
    if (warCard1.getCard() > warCard2.getCard()) {
      System.out.println("🏆 " + player1.getName() + " won the war!");
      player1.addCards(allWarCards);
      warCards1.clear();
      warCards2.clear();

    } else if (warCard1.getCard() < warCard2.getCard()) {
      System.out.println("🏆 " + player2.getName() + " won the war!");
      player2.addCards(allWarCards);
      warCards1.clear();
      warCards2.clear();

    } else {
      System.out.println("⚔️ Tie in the war! Continuing the war...");
      // Do not add the cards again here, they are already in warCards1 and warCards2
      handleWar(player1, player2, warCards1, warCards2);
    }
  }
}
