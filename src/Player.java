import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player {
  // Each player has a name and their half of the deck (hand)
  private String name;
  private List<Card> hand;

  // Constructor
  public Player(String name, List<Card> hand) {
    this.name = name;
    this.hand = hand;
  }

  // Getter methods
  public String getName() {
    return name;
  }

  public int getHandSize() {
    return hand.size();
  }

  // Implementation of drawing a card
  public Card drawCard() {
    if (hand.isEmpty()) {
      return null; // Returns null if no cards are left
    }
    return hand.remove(0); // Removes and returns the first card from the hand
  }

  // Adds a single card to the hand randomly
  public void addCard(Card card) {
    /*
     * Create a random position variable that will determine where the card should
     * go
     * using the Random.nextInt function that generates a position
     * based on a random number within the range of hand.size + 1
     */
    int position = new Random().nextInt(hand.size() + 1);
    hand.add(position, card);
  }

  // Adds two or more cards to the hand randomly
  public void addCards(List<Card> cards) {
    List<Card> cardsCopy = new LinkedList<>(cards);
    // It's important to shuffle the cards randomly to avoid a loop in the game
    Collections.shuffle(cardsCopy);
    // And we use .addAll() to add multiple elements to the end of the list
    hand.addAll(cardsCopy);
  }

  // Check if the player has any cards left
  public boolean hasCards() {
    return !hand.isEmpty();
  }
}
